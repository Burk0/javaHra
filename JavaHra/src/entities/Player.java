package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Game.RenderLayer;

public class Player extends Entities implements MouseMotionListener{
	Image image;

	public Player(RenderLayer l) {
		super(l);
//		this.color=Color.GREEN;
//		ImageIcon image = new ImageIcon("src/6cr6RMdqi.png");
//		this.height=this.width=25;
		this.xpoz=800/2;
		this.ypoz=550;
		image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("spaceship.gif"));
//		BufferedImage ret = new BufferedImage(32,32,BufferedImage.TYPE_INT_RGB);
		// TODO Auto-generated constructor stub
	}
	
	ArrayList<Bullet> bullet=new ArrayList<Bullet>();

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.mouseMoved(e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.xpoz=e.getX()-this.width/2;
		//this.ypoz=e.getY()-this.height/2;
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
//		g.setColor(this.color);
//		g.fillRect(this.xpoz, this.ypoz, this.width, this.height);
		g.drawImage(image,this.xpoz-17,this.ypoz,32,70,null);
		for(int i=0;i<bullet.size();i++)
		{
			Bullet b=bullet.get(i);
			b.render(g);
			if(b.move())
				bullet.remove(b);
		}
	}
	
	
	
	public void shoot()
	{
		//System.out.println("strielam :D");
		bullet.add(new Bullet(new Vector(this.xpoz+(this.width/2),this.ypoz),1));
		
	}
	
	public ArrayList<Bullet> getArrayBullets()
	{
		return (bullet);
	}
}
