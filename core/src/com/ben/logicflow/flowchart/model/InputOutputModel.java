package com.ben.logicflow.flowchart.model;

import com.ben.logicflow.flowchart.RequestType;
import com.ben.logicflow.flowchart.Variable;

public final class InputOutputModel extends SymbolModel {
	private String operation = "INPUT";
	private Variable variable = Variable.X;
	private String title;
	public InputOutputModel(FlowchartModel flowchartModel) {
		super(flowchartModel);
	}
	@Override
	public VertexModel execute() {
		if (operation.equals("INPUT")) {
			getFlowchartModel().setRequestType(RequestType.INPUT);
		} else {
			getFlowchartModel().setRequestType(RequestType.OUTPUT);
		}
		getFlowchartModel().setRequestVariable(variable);
		getFlowchartModel().setRequestVertex(getNextVertex());
		getFlowchartModel().setRequestTitle(title);
		return null;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setVariable(Variable variable) {
		this.variable = variable;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}