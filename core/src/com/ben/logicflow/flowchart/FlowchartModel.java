package com.ben.logicflow.flowchart;

import com.ben.logicflow.flowchart.view.ProcessView;
import com.ben.logicflow.flowchart.view.SymbolView;

import java.util.ArrayList;

public final class FlowchartModel {
	private final ProcessModel START_VERTEX = new ProcessModel(this);
	//private final ArrayList<VertexModel> VERTICES = new ArrayList<VertexModel>();
	private double variableX;
	private double variableY;
	private double variableZ;
	public FlowchartModel() {
		START_VERTEX.setView(new ProcessView());
		//VERTICES.add(START_VERTEX);
	}
	public VertexModel addSymbol(SymbolType symbolType, SymbolView symbolView) {
		VertexModel symbol = null;
		switch (symbolType) {
			case PROCESS:
				symbol = new ProcessModel(this);
				break;
			case IO:
				symbol = new InputOutputModel();
		}
		symbol.setView(symbolView);
		//VERTICES.add(symbol);
		VertexModel currentVertexModel = START_VERTEX;
		while (currentVertexModel.getNextVertexModel() != null) {
			currentVertexModel = currentVertexModel.getNextVertexModel();
		}
		currentVertexModel.setNextVertexModel(symbol);
		return symbol;
	}
	public void execute() {
	}
	public void execute(VertexModel startVertexModel) {
	}
	public VertexModel getStartVertex() {
		return START_VERTEX;
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