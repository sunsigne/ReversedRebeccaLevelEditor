package com.sunsigne.reversedrebeccaleveleditor.panel;

import com.sunsigne.reversedrebeccaleveleditor.system.Window;

public class LayerPanel extends GamePanel {

	public LayerPanel() {
		super(0, Window.HEIGHT - Window.HEIGHT / 6, 2 * Window.WIDHT, Window.HEIGHT / 6);
	}

	private static LayerPanel instance = new LayerPanel();

	public static LayerPanel getInstance() {
		return instance;
	}

}
