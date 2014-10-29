package com.ben.logicflow.flowchart;

import com.ben.logicflow.flowchart.view.ProcessView;

public final class ProcessModel extends VertexModel implements ISymbol {
	FlowchartModel flowchartModel;
	public ProcessModel(FlowchartModel flowchartModel) {
		this.flowchartModel = flowchartModel;
	}
	@Override
	public VertexModel execute() {
		try {
			ProcessView processView = (ProcessView) getView();
			if (processView.getOperation().equals("=")) {
				flowchartModel.setVariable(processView.getVariable(), processView.getValue());
			} else if (processView.getOperation().equals("+=")) {
				flowchartModel.setVariable(processView.getVariable(), flowchartModel.getVariable(processView.getVariable()) + processView.getValue());
			} else if (processView.getOperation().equals("-=")) {
				flowchartModel.setVariable(processView.getVariable(), flowchartModel.getVariable(processView.getVariable()) - processView.getValue());
			} else if (processView.getOperation().equals("*=")) {
				flowchartModel.setVariable(processView.getVariable(), flowchartModel.getVariable(processView.getVariable()) * processView.getValue());
			} else if (processView.getOperation().equals("/=")) {
				flowchartModel.setVariable(processView.getVariable(), flowchartModel.getVariable(processView.getVariable()) / processView.getValue());
			}
		} catch (NumberFormatException ignored) {
		}
		return getNextVertexModel();
	}
}