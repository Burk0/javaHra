package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Okno extends JFrame{

public static final String Game_Title = "Moja hra";

public static void main(String[]args){
	Okno hra=new Okno();
	hra.init();
	}

private Input input=new Input();
	
	private void init(){
		RenderLayer layer = new RenderLayer();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(layer);
		this.pack();
		this.setTitle(Game_Title);
		this.setResizable(false);
		this.setVisible(true);
		//this.setSize(400, 300);
		//this.setBackground(Color.black);
		layer.addMouseListener(input);
		
		input.addPlayer(layer.getPlayer());
		
		layer.start();
	}

}
