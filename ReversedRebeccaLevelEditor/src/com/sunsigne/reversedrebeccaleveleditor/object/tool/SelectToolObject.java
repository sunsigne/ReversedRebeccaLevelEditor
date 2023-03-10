package com.sunsigne.reversedrebeccaleveleditor.object.tool;

import java.awt.Cursor;

import com.sunsigne.reversedrebeccaleveleditor.world.Tool.TOOL;

public class SelectToolObject extends ToolObject {

	public SelectToolObject() {
		super(0);
	}

	@SuppressWarnings("unused")
	private static ToolObject instance = new SelectToolObject();

	@Override
	public TOOL getTool() {
		return TOOL.SELECT;
	}

	////////// CURSOR ////////////

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
	}

}
