package com.ben.logicflow.flowchart;

import com.ben.logicflow.flowchart.view.InputOutputView;

public final class InputOutputModel extends VertexModel implements ISymbol {
	public InputOutputModel() {
	}
	@Override
	public VertexModel execute() {
		InputOutputView inputOutputView = (InputOutputView) getView();
		if (inputOutputView.getOperation().equals("input")) {
			System.out.println(inputOutputView.getVariable());
			System.out.println(getNextVertexModel());
		} else {
			System.out.println(inputOutputView.getVariable());
			System.out.println(getNextVertexModel());
		}
		return getNextVertexModel();
	}
}