package com.sunsigne.reversedrebeccaleveleditor.object.map.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;

public class UserCanZoomOut {/*extends WorldMouse implements TickFree {

	private UserCanZoomOut() {
		LAYER.PANEL.addObject(this);
	}

	private static WorldMouse worldMouse = new UserCanZoomOut();

	@Override
	public WorldMouse getWorldMouse() {
		return worldMouse;
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
		if (World.get() == null)
			return;

		if (e.getWheelRotation() > 0)
			World.get().zoomIn();

		else
			World.get().zoomOut();
	}*/

}
