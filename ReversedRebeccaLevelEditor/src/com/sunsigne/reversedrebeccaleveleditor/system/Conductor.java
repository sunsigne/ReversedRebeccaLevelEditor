package com.sunsigne.reversedrebeccaleveleditor.system;

import com.sunsigne.reversedrebecca.ressources.sound.SoundTask;
import com.sunsigne.reversedrebecca.ressources.sound.SoundTask.SOUNDTYPE;
import com.sunsigne.reversedrebeccaleveleditor.panel.MapPanel;

public class Conductor {

	////////// START & STOP ////////////

	public void startApp() {

		new Window(Editor.getInstance());
		Editor.getInstance().start();

		// LOADING OF MINIMAL RESSOURCES
		new RessourceLoader().loadMinimalRessources();
		Editor.getInstance().forceLoop();

		// LOADING OF RESSOURCES
		new RessourceLoader().loadRessources();
		Editor.getInstance().forceLoop();

		new SoundTask().play(SOUNDTYPE.MUSIC, 1, "level_editor", false, true);
		MapPanel.getInstance().loadMap("test");
		// new World("test");
	}

	public void stopApp() {
		System.exit(1);
	}

}
