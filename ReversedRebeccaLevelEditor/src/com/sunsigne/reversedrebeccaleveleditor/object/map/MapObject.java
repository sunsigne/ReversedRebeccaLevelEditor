package com.sunsigne.reversedrebeccaleveleditor.object.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.reversedrebecca.ressources.images.ImageTask;
import com.sunsigne.reversedrebecca.system.Size;
import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebeccaleveleditor.object.PanelObject;
import com.sunsigne.reversedrebeccaleveleditor.object.characteristics.Zoomable;
import com.sunsigne.reversedrebeccaleveleditor.panel.MapPanel;

public class MapObject extends PanelObject implements TickFree, Zoomable {

	public MapObject(String name) {
		super(MapPanel.getInstance(), 0, 0, MapPanel.getInstance().getWidth(), MapPanel.getInstance().getHeight());
		this.name = name;
	}

	////////// NAME ////////////

	private String name;

	public String getName() {
		return name;
	}

	////////// SIZE ////////////

	private SIZE zoom = SIZE.L;

	@Override
	public SIZE getZoom() {
		return zoom;
	}

	@Override
	public void setZoom(SIZE zoom) {
		this.zoom = zoom;
	}

	////////// TEXTURE ////////////

	private BufferedImage image;

	public BufferedImage getImage() {
		if (image == null)
			image = new ImageTask().loadImage("maps/" + name + "/" + "ground");
		return image;
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {
		BufferedImage map = getImage();

		int ratio = Size.M / zoom.getSize();
		int width = map.getWidth() * ratio;
		int height = map.getHeight() * ratio;

		g.drawImage(map, getX(), getY(), width, height, null);
	}

}
