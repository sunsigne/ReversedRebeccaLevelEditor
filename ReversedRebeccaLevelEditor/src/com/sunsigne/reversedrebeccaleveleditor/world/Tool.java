package com.sunsigne.reversedrebeccaleveleditor.world;

public class Tool {

	private static TOOL tool = TOOL.SELECT;

	public TOOL getCurrentTool() {
		return Tool.tool;
	}

	public void setTool(TOOL tool) {
		Tool.tool = tool;
	}

	////////// TOOL ////////////

	public enum TOOL {
		SELECT("default"), MOVE("move");

		private String name;

		TOOL(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

}
