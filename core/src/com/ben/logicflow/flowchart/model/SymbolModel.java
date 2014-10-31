package com.ben.logicflow.flowchart.model;

public abstract class SymbolModel extends VertexModel {
	private FlowchartModel flowchartModel;
	public SymbolModel(FlowchartModel flowchartModel) {
		this.flowchartModel = flowchartModel;
	}
	public abstract VertexModel execute();
	public FlowchartModel getFlowchartModel() {
		return flowchartModel;
	}
}