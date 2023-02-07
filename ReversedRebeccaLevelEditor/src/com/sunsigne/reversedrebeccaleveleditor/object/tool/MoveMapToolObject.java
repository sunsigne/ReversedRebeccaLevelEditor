package com.sunsigne.reversedrebeccaleveleditor.object.tool;

import com.sunsigne.reversedrebeccaleveleditor.world.Tool.TOOL;

public class MoveMapToolObject extends ToolObject {

	public MoveMapToolObject() {
		super(30);
	}

	@SuppressWarnings("unused")
	private static ToolObject instance = new MoveMapToolObject();
	
	@Override
	public TOOL getTool() {
		return TOOL.MOVEMAP;
	}

}
