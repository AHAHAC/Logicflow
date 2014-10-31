package com.ben.logicflow.flowchart.model;

import com.ben.logicflow.flowchart.*;

//TODO refactoring
public final class FlowchartModel {
	private ProcessModel startVertex;
	private double variableX;
	private double variableY;
	private double variableZ;
	public VertexModel addStartVertex() {
		final VertexModel START_VERTEX = addSymbol(SymbolType.PROCESS);
		startVertex = (ProcessModel) START_VERTEX;
		return START_VERTEX;
	}
	public VertexModel addSymbol(SymbolType symbolType) {
		VertexModel symbol = null;
		switch (symbolType) {
			case PROCESS:
				symbol = new ProcessModel();
				break;
			case IO:
				symbol = new InputOutputModel();
		}
		if (startVertex != null) {
			VertexModel currentVertexModel = startVertex;
			while (currentVertexModel.getNextVertex() != null) {
				currentVertexModel = currentVertexModel.getNextVertex();
			}
			currentVertexModel.setNextVertex(symbol);
		}
		return symbol;
	}
	public void execute() {
	}
	public void execute(VertexModel startVertexModel) {
	}
	public VertexModel getStartVertex() {
		return startVertex;
	}
	public double getVariable(Variable variable) {
		switch (variable) {
			case X:
				return variableX;
			case Y:
				return variableY;
			case Z:
				return variableZ;
		}
		return 0;
	}
	public void setVariable(Variable variable, double value) {
		switch (variable) {
			case X:
				variableX = value;
				break;
			case Y:
				variableY = value;
				break;
			case Z:
				variableZ = value;
		}
	}
}