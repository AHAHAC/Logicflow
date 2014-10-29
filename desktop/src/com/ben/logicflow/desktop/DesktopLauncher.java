package com.ben.logicflow.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ben.logicflow.Application;

public final class DesktopLauncher {
	private DesktopLauncher() {
	}
	public static void main (String[] arg) {
		final LwjglApplicationConfiguration CONFIG = new LwjglApplicationConfiguration();
        CONFIG.title = "Logicflow";
        CONFIG.width = 1280;
        CONFIG.height = 800;
        CONFIG.resizable = false;
		new LwjglApplication(new Application(), CONFIG);
	}
}