package com.sunsigne.reversedrebeccaleveleditor.panel;

import java.awt.Graphics;

import com.sunsigne.reversedrebeccaleveleditor.system.Window;

public class MapPanel extends GamePanel {

	public MapPanel() {
		super(0, 0, 2 * Window.WIDHT / 3, Window.HEIGHT);
	}

	private static GamePanel instance = new MapPanel();

	public static GamePanel getInstance() {
		return instance;
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {

	}

}
