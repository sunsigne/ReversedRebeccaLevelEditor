package com.sunsigne.reversedrebeccaleveleditor.object.tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.sunsigne.reversedrebecca.ressources.images.ImageTask;
import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebeccaleveleditor.object.PanelObject;
import com.sunsigne.reversedrebeccaleveleditor.object.characteristics.UpdateCursor;
import com.sunsigne.reversedrebeccaleveleditor.panel.ToolPanel;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseController;
import com.sunsigne.reversedrebeccaleveleditor.world.Tool;
import com.sunsigne.reversedrebeccaleveleditor.world.Tool.TOOL;

public abstract class ToolObject extends PanelObject implements TickFree, UpdateCursor {

	public ToolObject(int x) {
		this(x, 25);
	}

	public ToolObject(int x, int w) {
		super(ToolPanel.getInstance(), x + 5, 5, w, 25);
		LAYER.PANEL.addObject(this);
	}

	public abstract TOOL getTool();

	////////// TEXTURE ////////////
	
	private BufferedImage image;
	
	protected BufferedImage getImage() {
		if(image == null)
			image = new ImageTask().loadImage("textures/cursor/editor_" + getTool().getName());
		return image;
	}
	
	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		g.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), null);
	}

	////////// MOUSE ////////////

	private MouseController mouseController = new MouseController(this);

	@Override
	public MouseController getMouseController() {
		return mouseController;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (isSelected() == false)
			return;

		new Tool().setTool(getTool());
		updateCursor(getCursor());
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
