package com.sunsigne.reversedrebeccaleveleditor.menu;

import java.awt.Color;
import java.awt.Graphics;

import com.sunsigne.reversedrebecca.object.characteristics.Position;
import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebecca.system.mainloop.Updatable;
import com.sunsigne.reversedrebeccaleveleditor.system.Window;

public class LibraryMenu implements Position, Updatable, TickFree {

	public LibraryMenu() {

	}

	////////// POSITION ////////////

	private int x = 2 * Window.WIDHT / 3;
	private int y = 0;

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

	@Override
	public int getWidth() {
		return Window.WIDHT / 3;
	}

	@Override
	public int getHeight() {
		return Window.HEIGHT;
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

}
