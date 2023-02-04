package com.sunsigne.reversedrebeccaleveleditor.world.mouse;

import java.awt.event.MouseEvent;

import com.sunsigne.reversedrebecca.system.camera.CameraDependency;
import com.sunsigne.reversedrebecca.system.controllers.mouse.MousePos;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;

public class UserCanMoveCamera extends WorldMouse implements CameraDependency {

	private UserCanMoveCamera() {
		LAYER.MENU.addObject(this);
	}

	private static WorldMouse worldMouse = new UserCanMoveCamera();

	@Override
	public WorldMouse getWorldMouse() {
		return worldMouse;
	}

	////////// TICK ////////////

	private boolean dragging;

	@Override
	public void tick() {
		if (dragging == false)
			return;

		int mouseX = new MousePos().get()[0] - registeredMouseX;
		int mouseY = new MousePos().get()[1] - registeredMouseY;

		CAMERA.setX(registeredCamX + mouseX);
		CAMERA.setY(registeredCamY + mouseY);
	}

	////////// MOUSE ////////////

	@Override
	public void mousePressed(MouseEvent e) {
		if (isSelected() == false || dragging == true)
			return;

		dragging = true;
		redefineRegisteredPos();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragging = false;
	}

	private int registeredCamX, registeredCamY;
	private int registeredMouseX, registeredMouseY;

	private void redefineRegisteredPos() {
		registeredCamX = (int) CAMERA.getX();
		registeredCamY = (int) CAMERA.getY();
		registeredMouseX = new MousePos().get()[0];
		registeredMouseY = new MousePos().get()[1];
	}

}
