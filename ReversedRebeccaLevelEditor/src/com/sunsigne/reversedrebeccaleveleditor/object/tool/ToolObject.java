package com.sunsigne.reversedrebeccaleveleditor.object.tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebeccaleveleditor.object.PanelObject;
import com.sunsigne.reversedrebeccaleveleditor.panel.ToolPanel;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseController;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseUserEvent;
import com.sunsigne.reversedrebeccaleveleditor.world.Tool;
import com.sunsigne.reversedrebeccaleveleditor.world.Tool.TOOL;

public abstract class ToolObject extends PanelObject implements TickFree, MouseUserEvent {

	public ToolObject(int x) {
		this(x, 25);
	}

	public ToolObject(int x, int w) {
		super(ToolPanel.getInstance(), x + 5, 5, w, 25);
		LAYER.PANEL.addObject(this);
	}

	public abstract TOOL getTool();

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
		if (isSelected())
			new Tool().setTool(getTool());
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
