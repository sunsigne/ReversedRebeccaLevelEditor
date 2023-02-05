package com.sunsigne.reversedrebeccaleveleditor.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.reversedrebecca.object.characteristics.Position;
import com.sunsigne.reversedrebecca.pattern.ForceInit;
import com.sunsigne.reversedrebecca.ressources.images.ImageTask;
import com.sunsigne.reversedrebecca.system.Size;
import com.sunsigne.reversedrebecca.system.mainloop.TickFree;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;
import com.sunsigne.reversedrebeccaleveleditor.system.Editor;
import com.sunsigne.reversedrebeccaleveleditor.system.Window;
import com.sunsigne.reversedrebeccaleveleditor.world.mouse.WorldMouse;

public class World implements Position, TickFree, Zoomable {

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

	////////// POSITION ////////////

	private int x, y;

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
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

	@Override
	public int getWidth() {
		return 2 * Window.WIDHT / 3;
	}

	@Override
	public int getHeight() {
		return Window.HEIGHT;
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

		g.drawImage(img, getX(), getY(), width, height, null);
	}

	////////// MOUSE ////////////

	private void addMouseListener() {
		new ForceInit().loadAllClassesInPackage(WorldMouse.class.getPackageName());
	}

}
