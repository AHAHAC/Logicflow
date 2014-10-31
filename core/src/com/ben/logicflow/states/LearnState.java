package com.ben.logicflow.states;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ben.logicflow.Application;
import com.ben.logicflow.Assets;

public final class LearnState extends ScreenAdapter {
	private static enum SubState {
		ALGORITHMS, CONCEPTS, FLOWCHARTS
	}
	private static SubState currentSubState = SubState.ALGORITHMS;
	private static final Table TABLE = new Table(Assets.getSkin());
	private static final Label TITLE_LABEL = new Label("", Assets.getSkin());
	private static final Label INFORMATION_LABEL = new Label("", Assets.getSkin());
	private static final Table INFORMATION_TABLE = new Table(Assets.getSkin());
	private static final TextButton NEXT_BUTTON = new TextButton("", Assets.getSkin());
	protected static void initialise() {
		TABLE.setVisible(false);
		TABLE.setFillParent(true);
		Application.addActor(TABLE);
		TABLE.add(TITLE_LABEL).space(20).left().row();
		INFORMATION_LABEL.setWrap(true);
		TABLE.add(INFORMATION_LABEL).width(900).space(20).row();
		TABLE.add(INFORMATION_TABLE).row();
		NEXT_BUTTON.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent inputEvent, float x, float y) {
				switch (currentSubState) {
					case ALGORITHMS:
						showConceptsInfo();
						currentSubState = SubState.CONCEPTS;
						break;
					case CONCEPTS:
						showFlowchartsInfo();
						currentSubState = SubState.FLOWCHARTS;
						break;
					case FLOWCHARTS:
						StateManager.setState(State.MENU_STATE);
						showAlgorithmInfo();
						currentSubState = SubState.ALGORITHMS;
				}
			}
		});
		TABLE.add(NEXT_BUTTON).width(100).height(50);
		showAlgorithmInfo();
	}
	@Override
	public void show() {
		TABLE.setVisible(true);
	}
	private static void showAlgorithmInfo() {
		INFORMATION_TABLE.clear();
		TABLE.getCell(INFORMATION_TABLE).space(0);
		TABLE.getCell(NEXT_BUTTON).space(10);
		TITLE_LABEL.setText("What is an algorithm?");
		INFORMATION_LABEL.setText("An algorithm is a clear set of instructions that solve a certain problem and is independent of any programming language. A recipe is an example of an algorithm; recipes have clear instructions that are to be carried out one after the other and solve a certain problem (e.g. \"How do I cook pasta?\"). Algorithms can be expressed in many different ways, in the case of a recipe it's standard English. The two most common ways to express algorithms in Computing are pseudocode and flowcharts.");
		NEXT_BUTTON.setText("Next");
	}
	private static void showConceptsInfo() {
		TABLE.getCell(INFORMATION_TABLE).space(30);
		TABLE.getCell(NEXT_BUTTON).space(30);
		TITLE_LABEL.setText("Flow of control");
		INFORMATION_LABEL.setText("The order in which instructions are followed, the conditions which determine which instructions are followed and the number of times instructions are followed are all important in problem solving. These are called sequence, selection and repetition respectively and are commonly used in algorithms.");
		INFORMATION_TABLE.add("Control Flow Statement").space(20);
		INFORMATION_TABLE.add("Example").space(20);
		INFORMATION_TABLE.add("Key Phrase").space(20).left().row();
		INFORMATION_TABLE.add("Sequence").space(20);
		INFORMATION_TABLE.add("Unscrew the broken light bulb and then replace it with a working one.").space(20).left();
		INFORMATION_TABLE.add("\"and then\"").space(20).left().row();
		INFORMATION_TABLE.add("Selection").space(20);
		INFORMATION_TABLE.add("Unscrew the light bulb if it's broken.").space(20).left();
		INFORMATION_TABLE.add("\"if it's broken\"").space(20).left().row();
		INFORMATION_TABLE.add("Repetition").space(20);
		INFORMATION_TABLE.add("Unscrew the broken light bulb until it comes out.").space(20).left();
		INFORMATION_TABLE.add("\"until it comes out\"").space(20).left();
	}
	private static void showFlowchartsInfo() {
		INFORMATION_TABLE.clear();
		TITLE_LABEL.setText("What are flowcharts?");
		INFORMATION_LABEL.setText("As stated earlier, flowcharts are one of the many ways of expressing algorithms. As sequence, selection and repetition are essential to problem solving they can all be used in flowcharts.");
		INFORMATION_TABLE.add("Symbol").space(20);
		INFORMATION_TABLE.add("Symbol Name").space(20);
		INFORMATION_TABLE.add("Control Flow Statement").space(20).row();
		INFORMATION_TABLE.add(new Image(Assets.getProcess())).space(20);
		INFORMATION_TABLE.add("Process").space(20);
		INFORMATION_TABLE.add("Sequence").space(20).row();
		INFORMATION_TABLE.add(new Image(Assets.getDecision())).space(20);
		INFORMATION_TABLE.add("Decision").space(20);
		INFORMATION_TABLE.add("Selection").space(20).row();
		INFORMATION_TABLE.add(new Image(Assets.getIO())).space(20);
		INFORMATION_TABLE.add("Input/output").space(20);
		NEXT_BUTTON.setText("Menu");
	}
	@Override
	public void hide() {
		TABLE.setVisible(false);
	}
}