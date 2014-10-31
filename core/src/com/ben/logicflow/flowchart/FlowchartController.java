package com.ben.logicflow.flowchart;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.ben.logicflow.flowchart.model.FlowchartModel;
import com.ben.logicflow.flowchart.model.ISymbol;
import com.ben.logicflow.flowchart.model.VertexModel;
import com.ben.logicflow.flowchart.view.*;

import java.util.HashMap;

//TODO refactoring
public final class FlowchartController {
	private final FlowchartModel MODEL = new FlowchartModel();
	private final ShapeRenderer EDGE_RENDERER = new ShapeRenderer();
	private final HashMap<VertexView, VertexModel> VERTEX_VIEW_HASH_MAP = new HashMap<VertexView, VertexModel>();
	private final HashMap<VertexModel, VertexView> VERTEX_MODEL_HASH_MAP = new HashMap<VertexModel, VertexView>();
	private InputDialog inputDialog;
	private OutputDialog outputDialog;
	public void initialise() {
		addSymbol(SymbolType.PROCESS, 450, 600);
	}
	public void updateEdges() {
		VertexModel currentVertexModel = MODEL.getStartVertex();
		EDGE_RENDERER.begin(ShapeRenderer.ShapeType.Line);
		EDGE_RENDERER.setColor(1, 1, 1, 1);
		while (currentVertexModel.getNextVertex() != null) {
			if (currentVertexModel instanceof ISymbol) {
				updateEdge(((SymbolView) getView(currentVertexModel)).getOutPoint(), getView(currentVertexModel.getNextVertex()).getInPoint());
			}
			currentVertexModel = currentVertexModel.getNextVertex();
		}
		EDGE_RENDERER.end();
	}
	private VertexView getView(VertexModel vertexModel) {
		return VERTEX_MODEL_HASH_MAP.get(vertexModel);
	}
	private void updateEdge(Vector2 startPoint, Vector2 endPoint) {
		/*
		SymbolView currentSymbolView = (SymbolView) currentVertexModel.getView();
		VertexView nextVertexView = currentVertexModel.getNextVertex().getView();
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
		symbolView.getImage().addListener(new DragAndDropListener(symbolView));
		symbolView.setPosition(x, y);
		symbolView.moved();
		VertexModel vertexModel;
		if (VERTEX_VIEW_HASH_MAP.isEmpty()) {
			vertexModel = MODEL.addStartVertex();
		} else {
			vertexModel = MODEL.addSymbol(symbolType);
		}
		VERTEX_VIEW_HASH_MAP.put(symbolView, vertexModel);
		VERTEX_MODEL_HASH_MAP.put(vertexModel, symbolView);
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
	}
	private final class DragAndDropListener extends DragListener {
		private VertexView vertexView;
		private Image image;
		private float dX;
		private float dY;
		public DragAndDropListener(VertexView vertexView) {
			this.vertexView = vertexView;
			image = vertexView.getImage();
		}
		@Override
		public void dragStart(InputEvent event, float x, float y, int pointer) {
			dX = Gdx.input.getX() - image.getX();
			dY = -Gdx.input.getY() + Gdx.graphics.getHeight() - image.getY();
		}
		@Override
		public void drag(InputEvent event, float x, float y, int pointer) {
			image.setPosition(image.getX() + x - dX, image.getY() + y - dY);
			if (image.getX() < 0) {
				image.setX(0);
			} else if (image.getX() > Gdx.graphics.getWidth() - image.getWidth()) {
				image.setX(Gdx.graphics.getWidth() - image.getWidth());
			}
			if (image.getY() < 0) {
				image.setY(0);
			} else if (image.getY() > Gdx.graphics.getHeight() - image.getHeight()) {
				image.setY(Gdx.graphics.getHeight() - image.getHeight());
			}
			vertexView.moved();
			VERTEX_VIEW_HASH_MAP.get(vertexView).setPosition(vertexView.getX(), vertexView.getY());
		}
	}
}