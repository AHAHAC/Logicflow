package com.ben.logicflow.flowchart.model;

public final class InputOutputModel extends SymbolModel {
	public InputOutputModel(FlowchartModel flowchartModel) {
		super(flowchartModel);
	}
	@Override
	public VertexModel execute() {
		return getNextVertex();
	}
}