package com.ben.logicflow.states;

import com.badlogic.gdx.Gdx;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.FlowchartController;
import com.ben.logicflow.flowchart.SymbolType;

public final class PracticeState extends FlowchartState {
	private static final FlowchartController FLOWCHART_CONTROLLER = new FlowchartController();
	protected static void initialise() {
		FLOWCHART_CONTROLLER.initialise();
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, (Gdx.graphics.getWidth() / 2) - (Assets.getProcess().getRegionWidth() / 2), 575);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.IO, (Gdx.graphics.getWidth() / 2) - (Assets.getIO().getRegionWidth() / 2), 475);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, (Gdx.graphics.getWidth() / 2) - (Assets.getProcess().getRegionWidth() / 2), 375);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.PROCESS, (Gdx.graphics.getWidth() / 2) - (Assets.getProcess().getRegionWidth() / 2), 275);
		FLOWCHART_CONTROLLER.addSymbol(SymbolType.IO, (Gdx.graphics.getWidth() / 2) - (Assets.getIO().getRegionWidth() / 2), 175);
		FLOWCHART_CONTROLLER.setVisible(false);
	}
	@Override
	public void show() {
		FLOWCHART_CONTROLLER.setVisible(true);
	}
	public static void checkFlowchartStatus() {
		FLOWCHART_CONTROLLER.checkStatus();
	}
	public static void drawFlowchartEdges() {
		FLOWCHART_CONTROLLER.drawEdges();
	}
	public static void executeFlowchart() {
		FLOWCHART_CONTROLLER.execute();
	}
	@Override
	public void hide() {
		FLOWCHART_CONTROLLER.setVisible(false);
	}
}