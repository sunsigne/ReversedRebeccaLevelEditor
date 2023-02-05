package com.sunsigne.reversedrebeccaleveleditor.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.reversedrebecca.pattern.ForceInit;
import com.sunsigne.reversedrebecca.ressources.images.ImageTask;
import com.sunsigne.reversedrebecca.system.Size;
import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebecca.system.mainloop.Updatable;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;
import com.sunsigne.reversedrebeccaleveleditor.system.Editor;
import com.sunsigne.reversedrebeccaleveleditor.world.mouse.WorldMouse;

public class World implements Updatable, TickFree, Zoomable {

	////////// SELF-CONTAINED ////////////

	private static World instance = null;

	public static World get() {
		return instance;
	}

	private void updateInstance() {
		if (instance != null)
			destroy();
		instance = this;
	}

	////////// WORLD ////////////

	public World(String mapName) {
		initParameters(mapName);
		createMap();
		addControllers();
		start();
	}

	private void initParameters(String mapName) {
		updateInstance();
		this.mapName = mapName;
	}

	private void createMap() {
		loadImageMap();
		// new MapCreator().loadAllLayers(this);
	}

	private void addControllers() {
		addMouseListener();
	}

	private void start() {
		LAYER.MAP.addObject(this);
		Editor.getInstance().forceLoop();
	}

	////////// NAME ////////////

	private String mapName;

	public String getMapName() {
		return mapName;
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

	////////// MAP OR LIST ////////////

	private BufferedImage map;

	private void loadImageMap() {
		map = new ImageTask().loadImage("maps/" + mapName + "/" + "ground"/* , true */);
	}

	public BufferedImage getImageMap() {
		return map;
	}

	////////// USEFULL ////////////

	public void destroy() {
		LAYER.MAP.getHandler().clear();
		instance = null;
		Editor.getInstance().forceLoop();
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {
		BufferedImage img = map;

		int ratio = Size.M / zoom.getSize();
		int width = img.getWidth() * ratio;
		int height = img.getHeight() * ratio;

		g.drawImage(img, 0, 0, width, height, null);
	}

	////////// MOUSE ////////////

	private void addMouseListener() {
		new ForceInit().loadAllClassesInPackage(WorldMouse.class.getPackageName());
	}

}
