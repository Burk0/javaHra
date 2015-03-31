package entities;

import java.awt.Color;
import java.awt.Graphics;

import Game.RenderLayer;

public abstract class Entities {
	protected int hp;
	protected int xpoz;
	protected int ypoz;
	protected Color color;
	protected RenderLayer map;
	protected int width;
	protected int height;

	public Entities(RenderLayer l) {
		this.map = l;
	}

	abstract public void update();

	public int getXpoz() {
		return xpoz;
	}

	public void setXpoz(int xpoz) {
		this.xpoz = xpoz;
	}

	public int getYpoz() {
		return ypoz;
	}

	public void setYpoz(int ypoz) {
		this.ypoz = ypoz;
	}

	abstract public void render(Graphics g);
}
