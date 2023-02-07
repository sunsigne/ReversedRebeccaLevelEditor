package com.sunsigne.reversedrebeccaleveleditor.system;

import com.sunsigne.reversedrebecca.pattern.ForceInit;
import com.sunsigne.reversedrebeccaleveleditor.object.tool.ToolObject;
import com.sunsigne.reversedrebeccaleveleditor.panel.MapPanel;

public class RessourceLoader {

	protected void loadMinimalRessources() {

	}

	protected void loadRessources() {

		new ForceInit().loadAllClassesInPackage(MapPanel.class.getPackageName());
		new ForceInit().loadAllClassesInPackage(ToolObject.class.getPackageName());
	}

}
