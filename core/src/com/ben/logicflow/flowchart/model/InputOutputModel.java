package com.ben.logicflow.flowchart.model;

public final class InputOutputModel extends VertexModel implements ISymbol {
	@Override
	public VertexModel execute() {
		/*
		if (inputOutputView.getOperation().equals("input")) {
			System.out.println(inputOutputView.getVariable());
			System.out.println(getNextVertex());
		} else {
			System.out.println(inputOutputView.getVariable());
			System.out.println(getNextVertex());
		}
		*/
		return getNextVertex();
	}
}