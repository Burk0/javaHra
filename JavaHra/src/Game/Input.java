package Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entities.Player;

public class Input implements MouseListener{

	
private Player player;

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(e.getButton());
		if(e.getButton()==1)
		{
			player.shoot();
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		this.player=player;
		
	}

}
