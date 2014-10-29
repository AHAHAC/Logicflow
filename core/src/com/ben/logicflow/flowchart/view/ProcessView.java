package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.Variable;

public final class ProcessView extends SymbolView {
	private final SelectBox<String> VARIABLES = new SelectBox<String>(Assets.getSkin());
	private final SelectBox<String> OPERATIONS = new SelectBox<String>(Assets.getSkin());
	private final TextField VALUE = new TextField("", Assets.getSkin());
	public ProcessView() {
		super(Assets.getProcess());
		VARIABLES.setItems("X", "Y", "Z");
		getTable().add(VARIABLES).space(10);
		OPERATIONS.setItems("=", "+=", "-=", "*=", "/=");
		getTable().add(OPERATIONS).space(10);
		VALUE.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
		VALUE.setMaxLength(5);
		getTable().add(VALUE).width(51).space(10);
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
	public String getOperation() {
		return OPERATIONS.getSelected();
	}
	public int getValue() {
		return Integer.parseInt(VALUE.getText());
	}
}