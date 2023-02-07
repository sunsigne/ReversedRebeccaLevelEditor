package com.sunsigne.reversedrebeccaleveleditor.object.tool;

import java.awt.Cursor;

import com.sunsigne.reversedrebeccaleveleditor.world.Tool.TOOL;

public class MoveToolObject extends ToolObject {

	public MoveToolObject() {
		super(30);
	}

	@SuppressWarnings("unused")
	private static ToolObject instance = new MoveToolObject();
	
	@Override
	public TOOL getTool() {
		return TOOL.MOVE;
	}

	////////// CURSOR ////////////
	
	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
	}
	
}
