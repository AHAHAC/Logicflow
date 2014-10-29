package com.ben.logicflow.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ben.logicflow.Application;
import com.ben.logicflow.Assets;

public final class MenuState extends State {
	private static final Table TABLE = new Table(Assets.getSkin());
	private static final Label TITLE_LABEL = new Label("Logicflow", Assets.getSkin());
	private static final TextButton LEARN_BUTTON = new TextButton("Learn", Assets.getSkin());
	private static final TextButton PRACTICE_BUTTON = new TextButton("Practice", Assets.getSkin());
	private static final TextButton TEST_BUTTON = new TextButton("Test", Assets.getSkin());
	private static final TextButton QUIT_BUTTON = new TextButton("Quit", Assets.getSkin());
	public static void initialise() {
		TABLE.setFillParent(true);
		Application.addActor(TABLE);
		TABLE.add(TITLE_LABEL).width(180).space(10).left().row();
		LEARN_BUTTON.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent inputEvent, float x, float y) {
				StateManager.setLearnState();
			}
		});
		TABLE.add(LEARN_BUTTON).fillX().height(50).space(10).row();
		PRACTICE_BUTTON.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				StateManager.setPracticeState();
			}
		});
		TABLE.add(PRACTICE_BUTTON).fillX().height(50).space(10).row();
		TABLE.add(TEST_BUTTON).fillX().height(50).space(10).row();
		QUIT_BUTTON.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		TABLE.add(QUIT_BUTTON).fillX().height(50).space(10);
	}
	@Override
	public void show() {
		TABLE.setVisible(true);
	}
	@Override
	public void hide() {
		TABLE.setVisible(false);
	}
}