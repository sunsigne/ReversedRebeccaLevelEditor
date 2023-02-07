package com.sunsigne.reversedrebeccaleveleditor.panel;

import com.sunsigne.reversedrebeccaleveleditor.system.Window;

public class ToolPanel extends GamePanel {

	public ToolPanel() {
		super(0, 0, 2 * Window.WIDHT / 3, 35);
	}

	private static ToolPanel instance = new ToolPanel();

	public static ToolPanel getInstance() {
		return instance;
	}

}
