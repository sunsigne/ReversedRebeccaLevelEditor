package com.sunsigne.reversedrebeccaleveleditor.world.mouse;

import com.sunsigne.reversedrebecca.system.Window;
import com.sunsigne.reversedrebecca.system.mainloop.RenderFree;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseController;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseUserEvent;

public abstract class WorldMouse implements MouseUserEvent, RenderFree {

	public abstract WorldMouse getWorldMouse();

	////////// POSITION ////////////

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public void setX(int x) {
	}

	@Override
	public void setY(int y) {
	}

	////////// SIZE ////////////

	@Override
	public int getWidth() {
		return Window.WIDHT;
	}

	@Override
	public int getHeight() {
		return Window.HEIGHT;
	}

	////////// MOUSE ////////////

	private MouseController mouseController = new MouseController(this);

	@Override
	public MouseController getMouseController() {
		return mouseController;
	}

}
