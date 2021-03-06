package com.ben.logicflow.flowchart.model;

import com.ben.logicflow.flowchart.*;

public final class FlowchartModel {
	private ProcessModel startVertex;
	private double variableX;
	private double variableY;
	private double variableZ;
	private RequestType requestType = RequestType.NONE;
	private Variable requestVariable;
	private VertexModel requestVertex;
	private String requestTitle = "";
	public VertexModel addStartVertex() {
		final VertexModel START_VERTEX = addSymbol(SymbolType.PROCESS);
		startVertex = (ProcessModel) START_VERTEX;
		return START_VERTEX;
	}
	public VertexModel addSymbol(SymbolType symbolType) {
		VertexModel symbol = null;
		switch (symbolType) {
			case PROCESS:
				symbol = new ProcessModel(this);
				break;
			case IO:
				symbol = new InputOutputModel(this);
		}
		if (startVertex != null) {
			VertexModel currentVertex = startVertex;
			while (currentVertex.getNextVertex() != null) {
				currentVertex = currentVertex.getNextVertex();
			}
			currentVertex.setNextVertex(symbol);
		}
		return symbol;
	}
	public void execute() {
		variableX = 0;
		variableY = 0;
		variableZ = 0;
		execute(startVertex);
	}
	public void execute(VertexModel startVertex) {
		VertexModel currentVertex = startVertex;
		while (currentVertex != null) {
			if (currentVertex instanceof SymbolModel) {
				currentVertex = ((SymbolModel) currentVertex).execute();
			} else {
				currentVertex = currentVertex.getNextVertex();
			}
		}
	}
	public void resetRequest() {
		requestType = RequestType.NONE;
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
	public RequestType getRequestType() {
		return requestType;
	}
	public Variable getRequestVariable() {
		return requestVariable;
	}
	public VertexModel getRequestVertex() {
		return requestVertex;
	}
	public String getRequestTitle() {
		return requestTitle;
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
	public void setRequestType(RequestType request) {
		this.requestType = request;
	}
	public void setRequestVariable(Variable requestVariable) {
		this.requestVariable = requestVariable;
	}
	public void setRequestVertex(VertexModel requestVertex) {
		this.requestVertex = requestVertex;
	}
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
}