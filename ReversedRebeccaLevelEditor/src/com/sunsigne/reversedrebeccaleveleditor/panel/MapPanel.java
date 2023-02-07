package com.sunsigne.reversedrebeccaleveleditor.panel;

import java.awt.Graphics;

import com.sunsigne.reversedrebecca.pattern.ForceInit;
import com.sunsigne.reversedrebecca.system.camera.CameraDependency;
import com.sunsigne.reversedrebeccaleveleditor.object.map.MapObject;
import com.sunsigne.reversedrebeccaleveleditor.object.map.mouse.MapMouse;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;
import com.sunsigne.reversedrebeccaleveleditor.system.Window;

public class MapPanel extends GamePanel implements CameraDependency {

	public MapPanel() {
		super(0, 35, 2 * Window.WIDHT / 3, Window.HEIGHT - 35);	
		addMouseListener();
	}

	private static MapPanel instance = new MapPanel();

	public static MapPanel getInstance() {
		return instance;
	}

	////////// MAP ////////////
	
	private MapObject map;

	public MapObject getMap() {
		return map;
	}

	public void loadMap(String name) {
		
		LAYER.MAP.getHandler().clear();
		CAMERA.setX(0);
		CAMERA.setY(0);
		
		map = new MapObject(name);
		LAYER.MAP.addObject(map);
	}
	
	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {

	}

	////////// MOUSE ////////////

	private void addMouseListener() {
		new ForceInit().loadAllClassesInPackage(MapMouse.class.getPackageName());
	}
	
}
