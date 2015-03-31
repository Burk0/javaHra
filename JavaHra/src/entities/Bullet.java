package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Game.RenderLayer;

public class Bullet {
	protected Vector pos;
	protected Vector dir;
	protected int dmg;
	protected int sizeX;
	protected int sizeY;
	protected Color color;
	protected int speed;
	
	public Vector getPos() {
		return pos;
	}

	public Bullet(Vector pos, int dmg)
	{
		this.pos=pos;
		dir=new Vector(0,-1);
		this.dmg=dmg;
		this.color=Color.CYAN;
		sizeX=2;
		sizeY=5;
		speed=5;
	}
	
	public void render(Graphics g)
	{
		g.setColor(color);
		g.fillRect(pos.getXi(), pos.getYi(), sizeX, sizeY);
	}
	public boolean move()
	{
//		pos.add(dir.mul(speed));
		
		pos.add(dir.mul(speed));
		if(pos.getY()<=40+30)
		{
			//zavola funckiu na koliziu
//			colision();
			
			//System.out.println("som v vyske");
		}
		return (pos.getY()+sizeY < 0);
			
	}
	
//	public void colision()
//	{
//		RenderLayer enemy=new RenderLayer();
////		Player bullet=new Player(enemy);
////		bullet.getArrayBullets();
//		//enemy.getArrayEnemy();
//		//System.out.println("som vo funckii :D");
//		
////		for(int i=0;i<enemy.getArrayEnemy().size();i++)
////		{
////			Enemy e = enemy.getArrayEnemy().get(i);
////			
////			if((e.getPos().getXi()+30<this.pos.getXi()  || this.pos.getXi()+2<e.getPos().getXi())){
////				System.out.println("maže sa "+e); // zly xpos 
////				enemy.getArrayEnemy().remove(i);
////				i--;
////			}
////			
////			
////		}
//		ArrayList<Enemy> enemies = enemy.getEnemies();
//		for(Enemy e: enemies)
//		{
////			System.out.println(e.getPos()+" "+pos );
//			e.isColision(this);
//		}
//		
//	}

}
