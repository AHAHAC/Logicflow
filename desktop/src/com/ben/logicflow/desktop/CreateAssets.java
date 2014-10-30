package com.ben.logicflow.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;

public final class CreateAssets {
	private CreateAssets() {
	}
	public static void main(String[] args) {
		final Settings SETTINGS = new Settings();
		SETTINGS.pot = false;
		TexturePacker.process(SETTINGS, "C:\\Users\\Ben\\Desktop\\Developer\\Projects\\Logicflow\\core\\assets\\new\\view", "C:\\Users\\Ben\\Desktop\\Developer\\Projects\\Logicflow\\core\\assets\\new\\view", "view");
		TexturePacker.process(SETTINGS, "C:\\Users\\Ben\\Desktop\\Developer\\Projects\\Logicflow\\core\\assets\\new\\flowchart_symbols", "C:\\Users\\Ben\\Desktop\\Developer\\Projects\\Logicflow\\core\\assets\\new\\flowchart_symbols", "flowchart_symbols");
	}
}