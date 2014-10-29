package com.ben.logicflow;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public final class Assets {
	private static final Skin SKIN = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas(Gdx.files.internal("uiskin.atlas")));
	private static final TextureAtlas FLOWCHART_SYMBOLS = new TextureAtlas(Gdx.files.internal("new\\flowchart_symbols\\flowchart_symbols.atlas"));
	private static final TextureRegion PROCESS = FLOWCHART_SYMBOLS.findRegion("process");
	private static final TextureRegion DECISION = FLOWCHART_SYMBOLS.findRegion("decision");
	private static final TextureRegion IO = FLOWCHART_SYMBOLS.findRegion("io");
	private static final TextureRegion ARROW_HEAD = FLOWCHART_SYMBOLS.findRegion("arrow_head");
	private Assets() {
	}
	public static void dispose() {
		SKIN.dispose();
		FLOWCHART_SYMBOLS.dispose();
	}
	public static Skin getSkin() {
		return SKIN;
	}
	public static TextureRegion getProcess() {
		return PROCESS;
	}
	public static TextureRegion getDecision() {
		return DECISION;
	}
	public static TextureRegion getIO() {
		return IO;
	}
	public static TextureRegion getArrowHead() {
		return ARROW_HEAD;
	}
}