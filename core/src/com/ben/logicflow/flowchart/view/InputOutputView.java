package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.model.Variable;

public final class InputOutputView extends SymbolView {
	private final SelectBox<String> OPERATIONS = new SelectBox<String>(Assets.getSkin());
	private final SelectBox<String> VARIABLES = new SelectBox<String>(Assets.getSkin());
	public InputOutputView() {
		super(Assets.getIO());
		OPERATIONS.setItems("INPUT", "OUTPUT");
		getTable().add(OPERATIONS).space(10);
		VARIABLES.setItems("X", "Y", "Z");
		getTable().add(VARIABLES).space(10);
	}
	public String getOperation() {
		return OPERATIONS.getSelected();
	}
	public Variable getVariable() {
		if (VARIABLES.getSelected().equals("X")) {
			return Variable.X;
		} else if (VARIABLES.getSelected().equals("Y")) {
			return Variable.Y;
		} else {
			return Variable.Z;
		}
	}
}