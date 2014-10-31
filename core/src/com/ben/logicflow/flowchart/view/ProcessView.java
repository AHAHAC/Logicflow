package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.Variable;

public final class ProcessView extends SymbolView {
	private final SelectBox<String> VARIABLE_SELECT_BOX = new SelectBox<String>(Assets.getSkin());
	private final SelectBox<String> OPERATION_SELECT_BOX = new SelectBox<String>(Assets.getSkin());
	private final TextField VALUE_TEXT_FIELD = new TextField("", Assets.getSkin());
	public ProcessView() {
		super(Assets.getProcess());
		VARIABLE_SELECT_BOX.setItems("X", "Y", "Z");
		getTable().add(VARIABLE_SELECT_BOX).space(10);
		OPERATION_SELECT_BOX.setItems("=", "+=", "-=", "*=", "/=");
		getTable().add(OPERATION_SELECT_BOX).space(10);
		VALUE_TEXT_FIELD.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
		VALUE_TEXT_FIELD.setMaxLength(5);
		getTable().add(VALUE_TEXT_FIELD).width(51).space(10);
	}
	public SelectBox<String> getVariableSelectBox() {
		return VARIABLE_SELECT_BOX;
	}
	public SelectBox<String> getOperationSelectBox() {
		return OPERATION_SELECT_BOX;
	}
	public TextField getValueTextField() {
		return VALUE_TEXT_FIELD;
	}
	public Variable getCurrentVariable() {
		if (VARIABLE_SELECT_BOX.getSelected().equals("X")) {
			return Variable.X;
		} else if (VARIABLE_SELECT_BOX.getSelected().equals("Y")) {
			return Variable.Y;
		} else {
			return Variable.Z;
		}
	}
	public String getCurrentOperation() {
		return OPERATION_SELECT_BOX.getSelected();
	}
	public String getCurrentValue() {
		return VALUE_TEXT_FIELD.getText();
	}
}