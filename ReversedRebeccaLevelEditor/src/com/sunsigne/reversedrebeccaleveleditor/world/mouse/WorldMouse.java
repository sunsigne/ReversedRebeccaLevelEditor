package com.sunsigne.reversedrebeccaleveleditor.world.mouse;

import com.sunsigne.reversedrebecca.system.mainloop.RenderFree;
import com.sunsigne.reversedrebeccaleveleditor.system.Window;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseController;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseUserEvent;
import com.sunsigne.reversedrebeccaleveleditor.world.World;

public abstract class WorldMouse implements MouseUserEvent, RenderFree {

	public abstract WorldMouse getWorldMouse();

	////////// POSITION ////////////

	@Override
	public int getX() {
		if (World.get() != null)
			return World.get().getX();
		return 0;
	}

	@Override
	public int getY() {
		if (World.get() != null)
			return World.get().getY();
		return 0;
	}

	@Override
	public void setX(int x) {
		if (World.get() != null)
			World.get().setX(x);
	}

	@Override
	public void setY(int y) {
		if (World.get() != null)
			World.get().setY(y);
	}

	////////// SIZE ////////////

	@Override
	public int getWidth() {
		if (World.get() != null)
			return World.get().getWidth();
		return 2 * Window.WIDHT / 3;
	}

	@Override
	public int getHeight() {
		if (World.get() != null)
			return World.get().getHeight();
		return Window.HEIGHT;
	}

	////////// MOUSE ////////////

	private MouseController mouseController = new MouseController(this);

	@Override
	public MouseController getMouseController() {
		return mouseController;
	}

}
