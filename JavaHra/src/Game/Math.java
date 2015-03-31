package Game;

import entities.Bullet;
import entities.Enemy;

public class Math {
	public static boolean colision(Enemy e, Bullet b){
		//System.out.println(e.getPos()+" "+ b.getPos());
		//return rectRect(e.getPos().getX(),e.getPos().getY(),40,40,b.getPos().getX(),b.getPos().getX(),2,5);
		
		if(b.getPos().getY()==e.getPos().getY())
		{
			return e.getPos().sub(b.getPos()).abs().average()<15;
		}
		return false;
//		return (e.getPos().getXi()+30<b.getPos().getXi()  || b.getPos().getXi()+2<e.getPos().getXi());
	}
	
	public static boolean rectRect(float ax, float ay, float aw, float ah, float bx, float by, float bw, float bh){
		return ((bx+bw>ax) && (by+bh>ay) && (bx<ax+aw) && (by<ay+ah));
		
	};
}
