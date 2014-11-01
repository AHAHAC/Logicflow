package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.Variable;

public final class InputOutputView extends SymbolView {
	private final SelectBox<String> OPERATION_SELECT_BOX = new SelectBox<String>(Assets.getSkin());
	private final SelectBox<String> VARIABLE_SELECT_BOX = new SelectBox<String>(Assets.getSkin());
	private final TextField TITLE_TEXT_FIELD = new TextField("", Assets.getSkin());
	public InputOutputView() {
		super(Assets.getIO());
		OPERATION_SELECT_BOX.setItems("INPUT", "OUTPUT");
		getTable().add(OPERATION_SELECT_BOX).space(10);
		VARIABLE_SELECT_BOX.setItems("X", "Y", "Z");
		getTable().add(VARIABLE_SELECT_BOX).space(10);
		TITLE_TEXT_FIELD.setMaxLength(12);
		TITLE_TEXT_FIELD.setMessageText("DIALOG TITLE");
		getTable().add(TITLE_TEXT_FIELD).width(186);
	}
	public SelectBox<String> getOperationSelectBox() {
		return OPERATION_SELECT_BOX;
	}
	public SelectBox<String> getVariableSelectBox() {
		return VARIABLE_SELECT_BOX;
	}
	public TextField getTitleTextField() {
		return TITLE_TEXT_FIELD;
	}
	public String getCurrentOperation() {
		return OPERATION_SELECT_BOX.getSelected();
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
	public String getCurrentTitle() {
		return TITLE_TEXT_FIELD.getText();
	}
}