package com.sunsigne.reversedrebeccaleveleditor.ressources.layers;

import com.sunsigne.reversedrebecca.system.mainloop.Handler;
import com.sunsigne.reversedrebecca.system.mainloop.Updatable;

public enum LAYER {
	
	MAP("map", new Handler(true)),
	MENU("menu", new Handler(false));

	private String name;
	private Handler handler;
	
	LAYER(String name, Handler handler) {
		this.name = name;
		this.handler = handler;
	}
	
	public String getName() {
		return name;
	}
	
	public Handler getHandler() {
		return handler;
	}
	
	public void addObject(Updatable object) {
		handler.addObject(object);
	}
	
}
