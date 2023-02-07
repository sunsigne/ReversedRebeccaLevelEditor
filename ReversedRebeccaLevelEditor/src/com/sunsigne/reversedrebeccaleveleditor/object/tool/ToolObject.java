package com.sunsigne.reversedrebeccaleveleditor.object.tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import com.sunsigne.reversedrebecca.system.controllers.mouse.MouseController;
import com.sunsigne.reversedrebecca.system.controllers.mouse.MouseUserEvent;
import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebeccaleveleditor.object.PanelObject;
import com.sunsigne.reversedrebeccaleveleditor.panel.ToolPanel;

public class ToolObject extends PanelObject implements TickFree, MouseUserEvent {

	public ToolObject(int x) {
		this(x, 25);
	}

	public ToolObject(int x, int w) {
		super(ToolPanel.getInstance(), x + 5, 5, w, 25);
	}


	////////// RENDER ////////////
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	////////// MOUSE ////////////

	private MouseController mouseController = new MouseController(this);

	@Override
	public MouseController getMouseController() {
		return mouseController;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	
}
