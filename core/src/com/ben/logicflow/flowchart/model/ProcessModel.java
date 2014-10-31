package com.ben.logicflow.flowchart.model;

public final class ProcessModel extends VertexModel implements ISymbol {
	@Override
	public VertexModel execute() {
		/*
		try {
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
		*/
		return getNextVertex();
	}
}