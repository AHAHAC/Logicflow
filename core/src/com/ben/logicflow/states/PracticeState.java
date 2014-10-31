package com.ben.logicflow.states;

import com.badlogic.gdx.ScreenAdapter;
import com.ben.logicflow.flowchart.FlowchartController;
import com.ben.logicflow.flowchart.SymbolType;

public final class PracticeState extends ScreenAdapter {
	private static final FlowchartController FLOWCHART_CONTROLLER = new FlowchartController();
	protected static void initialise() {
		FLOWCHART_CONTROLLER.initialise();
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, 450, 500);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.IO, 450, 400);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, 450, 300);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, 450, 200);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.IO, 450, 100);
		FLOWCHART_CONTROLLER.setVisible(false);
	}
	@Override
	public void show() {
		FLOWCHART_CONTROLLER.setVisible(true);
	}
	public static void updateFlowchartEdges() {
		FLOWCHART_CONTROLLER.updateEdges();
	}
	public static void executeFlowchart() {
		FLOWCHART_CONTROLLER.execute();
	}
	@Override
	public void hide() {
		FLOWCHART_CONTROLLER.setVisible(false);
	}
}