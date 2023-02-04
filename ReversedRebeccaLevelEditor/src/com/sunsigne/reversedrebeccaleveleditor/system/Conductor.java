package com.sunsigne.reversedrebeccaleveleditor.system;

import com.sunsigne.reversedrebeccaleveleditor.world.World;

public class Conductor {

	////////// START & STOP ////////////

	public void startApp() {
		
		new Window(Editor.getInstance());
		Editor.getInstance().start();
		
		new World("test");
		
		/*
		new GameCursor().setCursor(CURSOR_TYPE.NORMAL);
		new Window(Game.getInstance());
		Game.getInstance().start();

		// LOADING OF MINIMAL RESSOURCES
		new RessourceLoader().loadMinimalRessources();
		Game.getInstance().forceLoop();

		// LOADING OF RESSOURCES
		new RessourceLoader().loadRessources();
		Game.getInstance().forceLoop();

		new TitleScreen();
		*/
	}

	public void stopApp() {
		System.exit(1);
	}

}
