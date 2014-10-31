package com.ben.logicflow.flowchart.model;

public abstract class Symbol extends VertexModel {
	private FlowchartModel flowchartModel;
	public Symbol(FlowchartModel flowchartModel) {
		this.flowchartModel = flowchartModel;
	}
	public abstract VertexModel execute();
	public FlowchartModel getFlowchartModel() {
		return flowchartModel;
	}
}