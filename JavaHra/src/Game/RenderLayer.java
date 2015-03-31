package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entities.Bullet;
import entities.Enemy;
import entities.Player;
import entities.Vector;

public class RenderLayer extends Canvas  implements Runnable {
	private boolean isRunning;
	private boolean isGameOver;
	private float score;
	private int width;
	private int height;
	private Image background;

	private Player player;
//	private Enemy enemy;
//	private Enemy enemy2;
	private ArrayList<Enemy> enemies =new ArrayList<Enemy>();

	public Player getPlayer() {
		return player;
	}

	public RenderLayer() {
		super();

		this.isRunning = false;
		this.isGameOver = false;
		this.score = 0;
		this.width = 800;
		this.height = 600;
		
		background= Toolkit.getDefaultToolkit().createImage(getClass().getResource("space.jpg"));
		
		this.setSize(new Dimension(this.width, this.height));

		this.player = new Player(this);
		this.addMouseMotionListener(this.player);
		

//		enemy = new Enemy(new Vector(0, 40), Color.RED);
//		enemy2 = new Enemy(new Vector(70, 40), Color.RED);
		for(int i=0;i<10;i++)
		{
			enemies.add(new Enemy(new Vector(70*i, 40), Color.RED));
		}
	}

	public int getWidght() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public void run() {
		double frameTime = 1000 / 60;
		double startTime;
		double cicleTime = System.currentTimeMillis();
		int FPS = 0;
		int ticks = 0;
		while (isRunning) {
			startTime = System.currentTimeMillis();
			if (System.currentTimeMillis() - cicleTime > 1000) {
				System.out.println("ticks: " + ticks + ",FPS: " + FPS);
				cicleTime = System.currentTimeMillis();
				FPS = 0;
				ticks = 0;
				this.score += 0.5;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (System.currentTimeMillis() - startTime < frameTime) {
				FPS++;
				update();

			}
			ticks++;
			render();

		}

	}

	private void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		int l = 0;
		if (buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D)buffer.getDrawGraphics();
		Okno hra=new Okno();
		//g.setColor(Color.WHITE);
//		g.setColor(new Color(255,255,255));
//		g.fillRect(0, 0, this.getWidth(), getHeight());

		
		g.drawImage(background,0,0,null);
		// g.setColor(Color.BLUE);
		// g.fillRect(200, 150, 50, 60);
		//
		// g.setColor(Color.RED);
		// g.fillRect(0, 150, 50, 60);
		player.render(g);

		boolean changeDir = false;
		for(int i=0;i<enemies.size();i++)
		{
			Enemy e=enemies.get(i);
			e.draw(g);
			if(e.move(this))
			{
				changeDir = true;
				
			}
			for(int j=0 ; j<player.getArrayBullets().size() ; j++){

				if(Math.colision(e, player.getArrayBullets().get(j))){
//					System.out.println("zásah");
					l++;
					e.explode = 100;
					player.getArrayBullets().remove(j);
					j--;
					//enemies.remove(i);
					i--;
				}
			}
			if(e.explode==0)
				enemies.remove(e);
		}
		
		if(changeDir)
			for(int k=0;k<enemies.size();k++)
			{
				Enemy eTwo=enemies.get(k);
//				System.out.println("podmienka");
				eTwo.getDir().mul(new Vector(-1,1));
			}
		
		if(enemies.isEmpty())
		{
			System.out.println("vyhra");
			g.setColor(Color.GREEN);
			g.drawString("You won", this.height/2,this.width/2);
			
		}
		
		g.setColor(Color.BLUE);
		g.drawString("Your score is " + (int) this.score, 15, 15);

		g.dispose();
		buffer.show();
	}

	private void update() {
		// TODO Auto-generated method stub
		player.update();
	}

	public void start() {
		this.isRunning = true;
		Thread t = new Thread(this);
		t.start();
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	

}
