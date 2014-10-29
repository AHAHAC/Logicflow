package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.ben.logicflow.Application;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.FlowchartModel;
import com.ben.logicflow.flowchart.Variable;
import com.ben.logicflow.flowchart.VertexModel;

public final class InputDialog extends Dialog {
	private FlowchartModel flowchartModel;
	private Variable variable;
	private VertexModel nextVertexModel;
	private boolean active;
	private final TextField INPUT_FIELD = new TextField("", Assets.getSkin());
	public InputDialog(FlowchartModel flowchartModel) {
		super("INPUT", Assets.getSkin());
		this.flowchartModel = flowchartModel;
		setMovable(false);
		INPUT_FIELD.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
		INPUT_FIELD.setMaxLength(5);
		getContentTable().add(INPUT_FIELD).width(51);
		button("Ok");
	}
	public void input(Variable variable, VertexModel nextVertexModel) {
		this.variable = variable;
		this.nextVertexModel = nextVertexModel;
		show(Application.getStage());
		active = true;
	}
	@Override
	protected void result(Object object) {
		try {
			switch (variable) {
				case X:
					flowchartModel.setVariable(Variable.X, Integer.parseInt(INPUT_FIELD.getText()));
					break;
				case Y:
					flowchartModel.setVariable(Variable.Y, Integer.parseInt(INPUT_FIELD.getText()));
					break;
				case Z:
					flowchartModel.setVariable(Variable.Z, Integer.parseInt(INPUT_FIELD.getText()));
			}
		} catch (NumberFormatException ignored) {
		}
		active = false;
		if (nextVertexModel != null) {
			flowchartModel.execute(nextVertexModel);
		}
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
}