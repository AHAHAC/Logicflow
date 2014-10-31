package com.ben.logicflow.states;

import com.badlogic.gdx.Gdx;

public final class StateManager {
	private static State currentState = State.MENU_STATE;
	private static final MenuState MENU_STATE = new MenuState();
	private static final LearnState LEARN_STATE = new LearnState();
	private static final PracticeState PRACTICE_STATE = new PracticeState();
	private StateManager() {
	}
	public static void initialise() {
		MenuState.initialise();
		LearnState.initialise();
		PracticeState.initialise();
	}
	public static void update() {
		switch (currentState) {
			case MENU_STATE:
				MENU_STATE.render(Gdx.graphics.getDeltaTime());
				break;
			case LEARN_STATE:
				LEARN_STATE.render(Gdx.graphics.getDeltaTime());
				break;
			case PRACTICE_STATE:
				PRACTICE_STATE.render(Gdx.graphics.getDeltaTime());
		}
	}
	public static void pause() {
		switch (currentState) {
			case MENU_STATE:
				MENU_STATE.pause();
				break;
			case LEARN_STATE:
				LEARN_STATE.pause();
				break;
			case PRACTICE_STATE:
				PRACTICE_STATE.pause();
		}
	}
	public static void resume() {
		switch (currentState) {
			case MENU_STATE:
				MENU_STATE.resume();
				break;
			case LEARN_STATE:
				LEARN_STATE.resume();
				break;
			case PRACTICE_STATE:
				PRACTICE_STATE.resume();
		}
	}
	public static void dispose() {
		MENU_STATE.dispose();
		LEARN_STATE.dispose();
		PRACTICE_STATE.dispose();
	}
	public static State getCurrentState() {
		return currentState;
	}
	public static void setState(State state) {
		switch (currentState) {
			case MENU_STATE:
				MENU_STATE.hide();
				break;
			case LEARN_STATE:
				LEARN_STATE.hide();
				break;
			case PRACTICE_STATE:
				PRACTICE_STATE.hide();
		}
		switch (state) {
			case MENU_STATE:
				MENU_STATE.show();
				break;
			case LEARN_STATE:
				LEARN_STATE.show();
				break;
			case PRACTICE_STATE:
				PRACTICE_STATE.show();
		}
		currentState = state;
	}
}