package com.ben.logicflow.flowchart.model;

import com.ben.logicflow.flowchart.Variable;

public final class ProcessModel extends SymbolModel {
	private boolean active;
	private Variable variable = Variable.X;
	private String operation = "=";
	private int value;
	public ProcessModel(FlowchartModel flowchartModel) {
		super(flowchartModel);
	}
	@Override
	public VertexModel execute() {
		if (active) {
			if (operation.equals("=")) {
				getFlowchartModel().setVariable(variable, value);
			} else if (operation.equals("+=")) {
				getFlowchartModel().setVariable(variable, getFlowchartModel().getVariable(variable) + value);
			} else if (operation.equals("-=")) {
				getFlowchartModel().setVariable(variable, getFlowchartModel().getVariable(variable) - value);
			} else if (operation.equals("*=")) {
				getFlowchartModel().setVariable(variable, getFlowchartModel().getVariable(variable) * value);
			} else if (operation.equals("/=")) {
				getFlowchartModel().setVariable(variable, getFlowchartModel().getVariable(variable) / value);
			}
		}
		return getNextVertex();
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setVariable(Variable variable) {
		this.variable = variable;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setValue(int value) {
		this.value = value;
	}
}