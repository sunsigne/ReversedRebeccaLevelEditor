package com.sunsigne.reversedrebeccaleveleditor.panel;

import com.sunsigne.reversedrebeccaleveleditor.system.Window;

public class LibraryPanel extends GamePanel {

	public LibraryPanel() {
		super(2 * Window.WIDHT / 3, 0, Window.WIDHT / 3, Window.HEIGHT);
	}

	private static LibraryPanel instance = new LibraryPanel();

	public static LibraryPanel getInstance() {
		return instance;
	}

}
