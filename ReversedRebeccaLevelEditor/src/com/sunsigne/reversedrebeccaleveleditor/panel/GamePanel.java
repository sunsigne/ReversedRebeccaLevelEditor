package com.sunsigne.reversedrebeccaleveleditor.panel;

import java.awt.Color;
import java.awt.Graphics;

import com.sunsigne.reversedrebecca.object.characteristics.Position;
import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebecca.system.mainloop.Updatable;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;

public abstract class GamePanel implements Position, Updatable, TickFree {

	public GamePanel(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		LAYER.PANEL.addObject(this);
	}

	public abstract GamePanel getPanel();
	
	////////// POSITION ////////////

	private int x, y;

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	////////// SIZE ////////////

	private int w, h;

	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(getX(), getY(), getWidth(), getHeight());

		g.setColor(Color.WHITE);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}

}
