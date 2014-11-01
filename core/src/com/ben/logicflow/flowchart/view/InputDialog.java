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
	private boolean active;
	public InputDialog(FlowchartController flowchartController) {
		super("", Assets.getSkin());
		this.flowchartController = flowchartController;
		setMovable(false);
		INPUT_FIELD.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
		INPUT_FIELD.setMaxLength(7);
		getContentTable().add(INPUT_FIELD).width(69);
		button("Ok");
	}
	public void input(Variable variable, VertexModel nextVertex, String title) {
		this.variable = variable;
		this.nextVertex = nextVertex;
		if (title == null || title.equals("")) {
			setTitle("INPUT");
		} else {
			setTitle(title);
		}
		show(Application.getStage());
		active = true;
	}
	@Override
	protected void result(Object object) {
		try {
			flowchartController.setVariable(variable, Integer.parseInt(INPUT_FIELD.getText()));
		} catch (NumberFormatException ignored) {
		}
		active = false;
		if (nextVertex != null) {
			flowchartController.execute(nextVertex);
		}
	}
	public boolean isActive() {
		return active;
	}
}