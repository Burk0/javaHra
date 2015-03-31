package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import Game.RenderLayer;

public class Enemy {
	private Vector pos;
	protected Vector dir;
	protected Vector explosionPosition;
	protected int sizeX;
	protected int sizeY;
	protected float speed;
	protected Color color;
	private Image img = Toolkit.getDefaultToolkit().createImage(getClass().getResource("explosion.png"));
	public int explode = -1;
	
//	RenderLayer r=new RenderLayer();
	
//	public Enemy()
//	{
//		this(new Vector (40,40));
//	}
	
//	public Enemy(Vector pos)
//	{
//		this(pos, new Color(int)(Math.random()*255),(Math.random()*255),(Math.random()*255))
//	}
	
	public Enemy(Vector pos, Color color)
	{
		this.pos=pos;
		this.color=color;
		this.speed=2;
		this.dir=new Vector(1,0);
		this.sizeX=30;
		this.sizeY=30;
		
	}
	

	
	public void draw(Graphics g)
	{
	
//			g.setColor(color);
//			g.fillRect(pos.getXi(), pos.getYi(),sizeX, sizeY);
			if(explode == -1){
				g.setColor(color);
				g.fillRect(pos.getXi(), pos.getYi(),sizeX, sizeY);
			}
			if(explode>0){
				g.drawImage(img, pos.getXi(), pos.getYi(),50,50,0,0,img.getWidth(null)/7,img.getHeight(null), null);
				explode--;
			}
	}
	
	
	public boolean move(RenderLayer r)
	{
		if(explode>0)
			pos.add(dir.mul(speed/5));
		else
			pos.add(dir.mul(speed));
		
		if(pos.getX()<0 || pos.getX() + sizeX  >= r.getWidght())
		{
//				dir.mul(new Vector(-1,1));
			return true;
			
		}
	return false;
	}
	

	
	public Vector getDir() {
		return dir;
	}



	public Vector getPos() {
		return pos;
	}



	
//	public boolean isColision(Bullet b)
//	{
////		if(b.pos.getX()+30==pos.getXi())
////		{
////			
////		}
//		System.out.println(b.pos+" "+ pos);
//		return true;
//	}

}

