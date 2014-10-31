package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.Variable;

public final class InputOutputView extends SymbolView {
	private final SelectBox<String> OPERATION_SELECT_BOX = new SelectBox<String>(Assets.getSkin());
	private final SelectBox<String> VARIABLE_SELECT_BOX = new SelectBox<String>(Assets.getSkin());
	public InputOutputView() {
		super(Assets.getIO());
		OPERATION_SELECT_BOX.setItems("INPUT", "OUTPUT");
		getTable().add(OPERATION_SELECT_BOX).space(10);
		VARIABLE_SELECT_BOX.setItems("X", "Y", "Z");
		getTable().add(VARIABLE_SELECT_BOX).space(10);
	}
	public SelectBox<String> getOperationSelectBox() {
		return OPERATION_SELECT_BOX;
	}
	public SelectBox<String> getVariableSelectBox() {
		return VARIABLE_SELECT_BOX;
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
}