package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.ben.logicflow.Application;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.model.FlowchartModel;
import com.ben.logicflow.flowchart.model.VertexModel;
import com.ben.logicflow.flowchart.Variable;

//TODO refactoring
public final class OutputDialog extends Dialog {
	private FlowchartModel flowchartModel;
	private VertexModel nextVertexModel;
	private boolean active;
	private final Label OUTPUT_LABEL = new Label("", Assets.getSkin());
	public OutputDialog(FlowchartModel flowchartModel) {
		super("OUTPUT", Assets.getSkin());
		this.flowchartModel = flowchartModel;
		setMovable(false);
		getContentTable().add(OUTPUT_LABEL);
		button("Ok");
	}
	public void output(Variable variable, VertexModel nextVertexModel) {
		switch (variable) {
			case X:
				OUTPUT_LABEL.setText(String.valueOf(flowchartModel.getVariable(Variable.X)));
				break;
			case Y:
				OUTPUT_LABEL.setText(String.valueOf(flowchartModel.getVariable(Variable.Y)));
				break;
			case Z:
				OUTPUT_LABEL.setText(String.valueOf(flowchartModel.getVariable(Variable.Z)));
		}
		this.nextVertexModel = nextVertexModel;
		show(Application.getStage());
		active = true;
	}
	@Override
	protected void result(Object object) {
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