package com.sunsigne.reversedrebeccaleveleditor.object.map.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;

public class UserCanZoomOut extends MapMouse implements TickFree {

	private UserCanZoomOut() {
		LAYER.PANEL.addObject(this);
	}

	private static MapMouse mapMouse = new UserCanZoomOut();

	@Override
	public MapMouse getMapMouse() {
		return mapMouse;
	}

	////////// MOUSE ////////////

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (getMap() == null)
			return;

		if (e.getWheelRotation() > 0)
			getMap().zoomIn();

		else
			getMap().zoomOut();
	}

}
