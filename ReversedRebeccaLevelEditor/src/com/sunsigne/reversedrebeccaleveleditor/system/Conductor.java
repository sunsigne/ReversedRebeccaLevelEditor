package com.sunsigne.reversedrebeccaleveleditor.system;

import com.sunsigne.reversedrebeccaleveleditor.world.World;

public class Conductor {

	////////// START & STOP ////////////

	public void startApp() {
		
		// new GameCursor().setCursor(CURSOR_TYPE.NORMAL);
		new Window(Editor.getInstance());
		Editor.getInstance().start();
		
		// LOADING OF MINIMAL RESSOURCES
		new RessourceLoader().loadMinimalRessources();
		Editor.getInstance().forceLoop();
		
		// LOADING OF RESSOURCES
		new RessourceLoader().loadRessources();
		Editor.getInstance().forceLoop();
				
		new World("test");
	}

	public void stopApp() {
		System.exit(1);
	}

}
