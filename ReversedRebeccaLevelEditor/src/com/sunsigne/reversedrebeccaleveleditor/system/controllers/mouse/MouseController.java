package com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import com.sunsigne.reversedrebeccaleveleditor.system.Editor;

public class MouseController extends MouseAdapter {

	public MouseController(MouseUserEvent mouseUserEvent) {
		this.mouseUserEvent = mouseUserEvent;
		Editor.getInstance().addMouseListener(this);
		Editor.getInstance().addMouseWheelListener(this);
	}

	public void removeMouseListener() {
		Editor.getInstance().removeMouseListener(this);
		Editor.getInstance().removeMouseWheelListener(this);
	}

	////////// MOUSE ////////////

	private MouseUserEvent mouseUserEvent;

	@Override
	public void mousePressed(MouseEvent e) {
		mouseUserEvent.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseUserEvent.mouseReleased(e);
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseUserEvent.mouseWheelMoved(e);
	}
	

}
