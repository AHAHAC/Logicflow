package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.ben.logicflow.Application;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.FlowchartController;
import com.ben.logicflow.flowchart.model.VertexModel;
import com.ben.logicflow.flowchart.Variable;

public final class OutputDialog extends Dialog {
	private final Label OUTPUT_LABEL = new Label("", Assets.getSkin());
	private FlowchartController flowchartController;
	private VertexModel nextVertex;
	private boolean active;
	public OutputDialog(FlowchartController flowchartController) {
		super("", Assets.getSkin());
		this.flowchartController = flowchartController;
		setMovable(false);
		getContentTable().add(OUTPUT_LABEL);
		button("Ok");
	}
	public void output(Variable variable, VertexModel nextVertex, String title) {
		OUTPUT_LABEL.setText(String.valueOf(flowchartController.getVariable(variable)));
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
		active = false;
		if (nextVertex != null) {
			flowchartController.execute(nextVertex);
		}
	}
	public boolean isActive() {
		return active;
	}
}