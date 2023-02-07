package com.sunsigne.reversedrebeccaleveleditor.object;

import com.sunsigne.reversedrebecca.object.characteristics.Position;
import com.sunsigne.reversedrebecca.system.mainloop.Updatable;
import com.sunsigne.reversedrebeccaleveleditor.panel.GamePanel;

public abstract class PanelObject implements Position, Updatable {

	public PanelObject(GamePanel panel, int x, int y, int w, int h) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	private GamePanel panel;

	public GamePanel getPanel() {
		return panel;
	}

	////////// POSITION ////////////

	private int x, y;

	@Override
	public int getX() {
		return x - panel.getX();
	}

	@Override
	public int getY() {
		return y - panel.getX();
	}

	@Override
	public void setX(int x) {
		this.x = panel.getX() + x;
	}

	@Override
	public void setY(int y) {
		this.y = panel.getX() + y;
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

}
