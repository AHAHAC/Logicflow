package com.ben.logicflow.states;

import com.ben.logicflow.flowchart.FlowchartController;
import com.ben.logicflow.flowchart.FlowchartModel;
import com.ben.logicflow.flowchart.SymbolType;

public final class PracticeState extends State {
	private static final FlowchartController FLOWCHART_CONTROLLER = new FlowchartController();
	public static void initialise() {
		FLOWCHART_CONTROLLER.initialise();
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, 450, 600);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, 450, 500);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.IO, 450, 400);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, 450, 300);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, 450, 200);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.IO, 450, 100);
		FLOWCHART_CONTROLLER.setVisible(false);
	}
	public static void executeFlowchart() {
		FLOWCHART_CONTROLLER.execute();
	}
	public static void updateFlowchartEdges() {
		FLOWCHART_CONTROLLER.updateEdges();
	}
	@Override
	public void render(float delta) {
		FLOWCHART_CONTROLLER.updateVertexViews();
	}
	@Override
	public void show() {
		FLOWCHART_CONTROLLER.setVisible(true);
	}
	@Override
	public void hide() {
		FLOWCHART_CONTROLLER.setVisible(false);
	}
}