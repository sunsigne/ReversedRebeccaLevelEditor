package com.sunsigne.reversedrebeccaleveleditor.panel;

import java.awt.Graphics;

import com.sunsigne.reversedrebeccaleveleditor.object.MapObject;
import com.sunsigne.reversedrebeccaleveleditor.ressources.layers.LAYER;
import com.sunsigne.reversedrebeccaleveleditor.system.Window;

public class MapPanel extends GamePanel {

	public MapPanel() {
		super(0, 35, 2 * Window.WIDHT / 3, Window.HEIGHT - 35);		
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
		map = new MapObject(name);
		LAYER.MAP.addObject(map);
	}
	
	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {

	}

}
