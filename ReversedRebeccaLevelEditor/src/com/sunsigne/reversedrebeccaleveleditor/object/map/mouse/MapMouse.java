package com.sunsigne.reversedrebeccaleveleditor.object.map.mouse;

import com.sunsigne.reversedrebecca.system.mainloop.RenderFree;
import com.sunsigne.reversedrebeccaleveleditor.object.map.MapObject;
import com.sunsigne.reversedrebeccaleveleditor.panel.MapPanel;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseController;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseUserEvent;

public abstract class MapMouse implements MouseUserEvent, RenderFree {

	public abstract MapMouse getMapMouse();

	////////// POSITION ////////////

	protected MapObject getMap() {
		return MapPanel.getInstance().getMap();
	}

	@Override
	public int getX() {
		if (getMap() != null)
			return getMap().getX();
		return MapPanel.getInstance().getX();
	}

	@Override
	public int getY() {
		if (getMap() != null)
			return getMap().getY();
		return MapPanel.getInstance().getY();
	}

	@Override
	public void setX(int x) {
		if (getMap() != null)
			getMap().setX(x);
	}

	@Override
	public void setY(int y) {
		if (getMap() != null)
			getMap().setY(y);
	}

	////////// SIZE ////////////

	@Override
	public int getWidth() {
		if (getMap() != null)
			return getMap().getWidth();
		return MapPanel.getInstance().getWidth();
	}

	@Override
	public int getHeight() {
		if (getMap() != null)
			return getMap().getHeight();
		return MapPanel.getInstance().getHeight();
	}

	////////// MOUSE ////////////

	private MouseController mouseController = new MouseController(this);

	@Override
	public MouseController getMouseController() {
		return mouseController;
	}

}
