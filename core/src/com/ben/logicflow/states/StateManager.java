package com.ben.logicflow.states;

import com.badlogic.gdx.Gdx;

public final class StateManager {
	private static State currentState;
	private static final MenuState MENU_STATE = new MenuState();
	private static final LearnState LEARN_STATE = new LearnState();
	private static final PracticeState PRACTICE_STATE = new PracticeState();
	private StateManager() {
	}
	public static void initialise() {
		MenuState.initialise();
		LearnState.initialise();
		PracticeState.initialise();
		currentState = MENU_STATE;
	}
	public static void resize(int width, int height) {
		currentState.resize(width, height);
	}
	public static void update() {
		currentState.render(Gdx.graphics.getDeltaTime());
	}
	public static void pause() {
		currentState.pause();
	}
	public static void resume() {
		currentState.resume();
	}
	public static void dispose() {
		MENU_STATE.dispose();
		LEARN_STATE.dispose();
		PRACTICE_STATE.dispose();
	}
	public static State getCurrentState() {
		return currentState;
	}
	public static void setMenuState() {
		currentState.hide();
		currentState = MENU_STATE;
		currentState.show();
	}
	public static void setLearnState() {
		currentState.hide();
		currentState = LEARN_STATE;
		currentState.show();
	}
	public static void setPracticeState() {
		currentState.hide();
		currentState = PRACTICE_STATE;
		currentState.show();
	}
}