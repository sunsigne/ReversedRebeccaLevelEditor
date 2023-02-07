package com.sunsigne.reversedrebeccaleveleditor.world;

public class Tool {

	private static TOOL tool;

	public TOOL getCurrentTool() {
		return Tool.tool;
	}

	public void setTool(TOOL tool) {
		Tool.tool = tool;
		updateMouse();
	}

	private void updateMouse() {

	}

	////////// TOOL ////////////

	public enum TOOL {
		SELECT, MOVEMAP;
	}

}
