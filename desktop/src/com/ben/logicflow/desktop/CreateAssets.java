package com.ben.logicflow.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;

public final class CreateAssets {
	private CreateAssets() {
	}
	public static void main(String[] args) {
		final Settings settings = new Settings();
		settings.pot = false;
		TexturePacker.process(settings, "C:\\Users\\Ben\\Desktop\\Developer\\Projects\\Logicflow\\core\\assets\\new\\view", "C:\\Users\\Ben\\Desktop\\Developer\\Projects\\Logicflow\\core\\assets\\new\\view", "view");
		TexturePacker.process(settings, "C:\\Users\\Ben\\Desktop\\Developer\\Projects\\Logicflow\\core\\assets\\new\\flowchart_symbols", "C:\\Users\\Ben\\Desktop\\Developer\\Projects\\Logicflow\\core\\assets\\new\\flowchart_symbols", "flowchart_symbols");
	}
}