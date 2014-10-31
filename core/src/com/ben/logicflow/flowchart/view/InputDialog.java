package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.ben.logicflow.Application;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.FlowchartController;
import com.ben.logicflow.flowchart.Variable;
import com.ben.logicflow.flowchart.model.VertexModel;

public final class InputDialog extends Dialog {
	private final TextField INPUT_FIELD = new TextField("", Assets.getSkin());
	private FlowchartController flowchartController;
	private Variable variable;
	private VertexModel nextVertex;
	public InputDialog(FlowchartController flowchartController) {
		super("INPUT", Assets.getSkin());
		this.flowchartController = flowchartController;
		setMovable(false);
		INPUT_FIELD.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
		INPUT_FIELD.setMaxLength(5);
		getContentTable().add(INPUT_FIELD).width(51);
		button("Ok");
	}
	public void input(Variable variable, VertexModel nextVertex) {
		this.variable = variable;
		this.nextVertex = nextVertex;
		show(Application.getStage());
	}
	@Override
	protected void result(Object object) {
		try {
			flowchartController.setVariable(variable, Integer.parseInt(INPUT_FIELD.getText()));
		} catch (NumberFormatException ignored) {
		}
		if (nextVertex != null) {
			flowchartController.execute(nextVertex);
		}
	}
}