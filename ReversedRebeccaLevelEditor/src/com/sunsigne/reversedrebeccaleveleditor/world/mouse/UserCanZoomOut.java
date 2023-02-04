package com.sunsigne.reversedrebeccaleveleditor.world.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;
import com.sunsigne.reversedrebeccaleveleditor.world.World;

public class UserCanZoomOut extends WorldMouse implements TickFree {

	private UserCanZoomOut() {
		LAYER.MENU.addObject(this);
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
		System.out.println("hello");
		if (World.get() == null)
			return;

		int scale = World.get().pixel == 40 || World.get().pixel == 48 ? 16 : 8;

		if (e.getWheelRotation() > 0) {
			if (World.get().pixel < 56)
				World.get().pixel += scale;
		}

		else {
			if (World.get().pixel > 8)
				World.get().pixel -= scale;
		}

		System.out.println(World.get().pixel);
	}

}
