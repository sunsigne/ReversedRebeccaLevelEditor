package com.sunsigne.reversedrebeccaleveleditor.system;

import com.sunsigne.reversedrebecca.pattern.ForceInit;
import com.sunsigne.reversedrebeccaleveleditor.object.tool.ToolObject;
import com.sunsigne.reversedrebeccaleveleditor.panel.MapPanel;
import com.sunsigne.reversedrebeccaleveleditor.world.Tool;
import com.sunsigne.reversedrebeccaleveleditor.world.Tool.TOOL;

public class RessourceLoader {

	protected void loadMinimalRessources() {
		new Tool().setTool(TOOL.SELECT);
	}

	protected void loadRessources() {

		new ForceInit().loadAllClassesInPackage(MapPanel.class.getPackageName());
		new ForceInit().loadAllClassesInPackage(ToolObject.class.getPackageName());
	}

}
