package com.ben.logicflow;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.ben.logicflow.states.PracticeState;
import com.ben.logicflow.states.State;
import com.ben.logicflow.states.StateManager;

public final class Application extends ApplicationAdapter {
	private static Stage stage;
	@Override
	public void create() {
		stage = new Stage();
		StateManager.initialise();
		stage.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				if (! (event.getTarget() instanceof TextField)) {
					stage.setKeyboardFocus(null);
				}
				return false;
			}
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if (keycode == Keys.F10 && StateManager.getCurrentState() == State.PRACTICE_STATE) {
					PracticeState.executeFlowchart();
				}
				if (keycode == Keys.ESCAPE && StateManager.getCurrentState() == State.PRACTICE_STATE) {
					StateManager.setState(State.MENU_STATE);
				}
				return false;
			}
		});
		Gdx.input.setInputProcessor(stage);
	}
	@Override
	public void render() {
		StateManager.update();
		if (StateManager.getCurrentState() == State.PRACTICE_STATE) {
			PracticeState.checkFlowchartStatus();
		}
		stage.act();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (StateManager.getCurrentState() == State.PRACTICE_STATE) {
			PracticeState.drawFlowchartEdges();
		}
		stage.draw();
	}
	public static void addActor(Actor actor) {
		stage.addActor(actor);
	}
	@Override
	public void pause() {
		StateManager.pause();
	}
	@Override
	public void resume() {
		StateManager.resume();
	}
	@Override
	public void dispose() {
		StateManager.dispose();
		stage.dispose();
		Assets.dispose();
	}
	public static Stage getStage() {
		return stage;
	}
}