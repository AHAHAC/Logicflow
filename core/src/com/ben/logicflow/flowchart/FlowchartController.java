package com.ben.logicflow.flowchart;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.ben.logicflow.Application;
import com.ben.logicflow.flowchart.view.*;

import java.util.HashMap;

public final class FlowchartController {
	private final FlowchartModel MODEL = new FlowchartModel();
	private final ShapeRenderer EDGE_RENDERER = new ShapeRenderer();
	private final HashMap<VertexView, VertexModel> VERTEX_VIEW_HASH_MAP = new HashMap<VertexView, VertexModel>();
	private final HashMap<VertexModel, VertexView> VERTEX_MODEL_HASH_MAP = new HashMap<VertexModel, VertexView>();
	private InputDialog inputDialog;
	private OutputDialog outputDialog;
	public void initialise() {
		/*
		Application.addActor(MODEL.getStartVertex().getView().getImage());
		Application.addActor(((SymbolView) MODEL.getStartVertex().getView()).getTable());
		*/
	}
	public void updateEdges() {
		VertexModel currentVertexModel = MODEL.getStartVertex();
		EDGE_RENDERER.begin(ShapeRenderer.ShapeType.Line);
		EDGE_RENDERER.setColor(1, 1, 1, 1);
		while (currentVertexModel.getNextVertexModel() != null) {
			if (currentVertexModel instanceof ISymbol) {
				updateEdge(((SymbolView) getView(currentVertexModel)).getOutPoint(), getView(currentVertexModel.getNextVertexModel()).getInPoint());
			}
			currentVertexModel = currentVertexModel.getNextVertexModel();
		}
		EDGE_RENDERER.end();
	}
	private VertexView getView(VertexModel vertexModel) {
		return VERTEX_MODEL_HASH_MAP.get(vertexModel);
	}
	private void updateEdge(Vector2 startPoint, Vector2 endPoint) {
		/*
		SymbolView currentSymbolView = (SymbolView) currentVertexModel.getView();
		VertexView nextVertexView = currentVertexModel.getNextVertexModel().getView();
		final int MINIMUM_DISTANCE = 12;
		if (currentSymbolView.getOutPoint().y - nextVertexView.getInPoint().y < 2 * MINIMUM_DISTANCE) {
			EDGE_RENDERER.line(currentSymbolView.getOutPoint().x, currentSymbolView.getOutPoint().y, currentSymbolView.getOutPoint().x, currentSymbolView.getOutPoint().y - MINIMUM_DISTANCE);
			EDGE_RENDERER.line(currentSymbolView.getOutPoint().x, currentSymbolView.getOutPoint().y - MINIMUM_DISTANCE, (currentSymbolView.getOutPoint().x + nextVertexView.getInPoint().x) / 2, currentSymbolView.getOutPoint().y - MINIMUM_DISTANCE);
			EDGE_RENDERER.line((currentSymbolView.getOutPoint().x + nextVertexView.getInPoint().x) / 2, currentSymbolView.getOutPoint().y - MINIMUM_DISTANCE, (currentSymbolView.getOutPoint().x + nextVertexView.getInPoint().x) / 2, nextVertexView.getInPoint().y + MINIMUM_DISTANCE);
			EDGE_RENDERER.line((currentSymbolView.getOutPoint().x + nextVertexView.getInPoint().x) / 2, nextVertexView.getInPoint().y + MINIMUM_DISTANCE, nextVertexView.getInPoint().x, nextVertexView.getInPoint().y + MINIMUM_DISTANCE);
			EDGE_RENDERER.line(nextVertexView.getInPoint().x, nextVertexView.getInPoint().y + MINIMUM_DISTANCE, nextVertexView.getInPoint().x, nextVertexView.getInPoint().y);
		} else {
			EDGE_RENDERER.line(currentSymbolView.getOutPoint().x, currentSymbolView.getOutPoint().y, currentSymbolView.getOutPoint().x, (currentSymbolView.getOutPoint().y + nextVertexView.getInPoint().y) / 2);
			EDGE_RENDERER.line(currentSymbolView.getOutPoint().x, (currentSymbolView.getOutPoint().y + nextVertexView.getInPoint().y) / 2, nextVertexView.getInPoint().x, (currentSymbolView.getOutPoint().y + nextVertexView.getInPoint().y) / 2);
			EDGE_RENDERER.line(nextVertexView.getInPoint().x, (currentSymbolView.getOutPoint().y + nextVertexView.getInPoint().y) / 2, nextVertexView.getInPoint().x, nextVertexView.getInPoint().y);
		}
		*/
	}
	public void addSymbol(SymbolType symbolType, float x, float y) {
		SymbolView symbolView = null;
		switch (symbolType) {
			case PROCESS:
				symbolView = new ProcessView();
				break;
			case IO:
				symbolView = new InputOutputView();
		}
		final SymbolView SYMBOL_VIEW_TEMP = symbolView;
		SYMBOL_VIEW_TEMP.getImage().addListener(new DragListener() {
			private float dX;
			private float dY;
			private final Image IMAGE = SYMBOL_VIEW_TEMP.getImage();
			private final Table TABLE = SYMBOL_VIEW_TEMP.getTable();
			private final Vector2 IN_POINT = SYMBOL_VIEW_TEMP.getInPoint();
			private final Vector2 OUT_POINT = SYMBOL_VIEW_TEMP.getOutPoint();
			@Override
			public void dragStart(InputEvent event, float x, float y, int pointer) {
				dX = Gdx.input.getX() - IMAGE.getX();
				dY = -Gdx.input.getY() + Gdx.graphics.getHeight() - IMAGE.getY();
			}
			@Override
			public void drag(InputEvent event, float x, float y, int pointer) {
				IMAGE.setPosition(IMAGE.getX() + x - dX, IMAGE.getY() + y - dY);
				if (IMAGE.getX() < 0) {
					IMAGE.setX(0);
				} else if (IMAGE.getX() > Gdx.graphics.getWidth() - IMAGE.getWidth()) {
					IMAGE.setX(Gdx.graphics.getWidth() - IMAGE.getWidth());
				}
				if (IMAGE.getY() < 0) {
					IMAGE.setY(0);
				} else if (IMAGE.getY() > Gdx.graphics.getHeight() - IMAGE.getHeight()) {
					IMAGE.setY(Gdx.graphics.getHeight() - IMAGE.getHeight());
				}
				IN_POINT.set(IMAGE.getX() + (IMAGE.getWidth() / 2), IMAGE.getY() + IMAGE.getHeight());
				TABLE.setPosition(IMAGE.getX() + (IMAGE.getWidth() / 2), IMAGE.getY() + (IMAGE.getHeight() / 2));
				OUT_POINT.set(IMAGE.getX() + (IMAGE.getWidth() / 2), IMAGE.getY());
				VERTEX_VIEW_HASH_MAP.get(SYMBOL_VIEW_TEMP).setPosition(IMAGE.getX(), IMAGE.getY());
			}
		});
		symbolView.setPosition(x, y);
		VERTEX_VIEW_HASH_MAP.put(symbolView, MODEL.addSymbol(symbolType, symbolView));
		VERTEX_MODEL_HASH_MAP.put(MODEL.addSymbol(symbolType, symbolView), symbolView);
		Application.addActor(symbolView.getImage());
		Application.addActor(symbolView.getTable());
	}
	private void vertexMoved(VertexView view, float x, float y) {
	}
	public void execute() {
		/*
		variableX = 0;
		variableY = 0;
		variableZ = 0;
		execute(START_VERTEX);
		*/
		/*
		Vertex currentVertex = startVertex;
		while (currentVertex != null) {
			if ((outputDialog != null && outputDialog.isActive()) || (inputDialog != null && inputDialog.isActive())) {
				break;
			}
			if (currentVertex instanceof Symbol) {
				currentVertex = ((Symbol) currentVertex).execute();
			} else {
				currentVertex = currentVertex.getNextVertex();
			}
		}
		*/
	}
	public void execute(VertexModel startVertexModel) {
	}
	public void input(Variable variable, VertexModel nextVertexModel) {
		/*
		inputDialog = new InputDialog(this);
		inputDialog.input(variable, nextVertex);
		*/
	}
	public void output(Variable variable, VertexModel nextVertexModel) {
		/*
		outputDialog = new OutputDialog(this);
		outputDialog.output(variable, nextVertex);
		*/
	}
	public void setVisible(boolean visible) {
		for (VertexView vertexView : VERTEX_VIEW_HASH_MAP.keySet()) {
			vertexView.setVisible(visible);
		}
		/*
		if (! visible) {
			if (outputDialog != null) {
				outputDialog.hide(null);
				outputDialog.setActive(false);
			}
			if (inputDialog != null) {
				inputDialog.hide(null);
				inputDialog.setActive(false);
			}
		}
		*/
	}
}