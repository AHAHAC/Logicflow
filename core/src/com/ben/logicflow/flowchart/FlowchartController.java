package com.ben.logicflow.flowchart;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.ben.logicflow.flowchart.model.FlowchartModel;
import com.ben.logicflow.flowchart.model.SymbolModel;
import com.ben.logicflow.flowchart.model.ProcessModel;
import com.ben.logicflow.flowchart.model.VertexModel;
import com.ben.logicflow.flowchart.view.*;

import java.util.HashMap;

public final class FlowchartController {
	private final FlowchartModel MODEL = new FlowchartModel();
	private final HashMap<VertexView, VertexModel> VERTEX_VIEW_HASH_MAP = new HashMap<VertexView, VertexModel>();
	private final HashMap<VertexModel, VertexView> VERTEX_MODEL_HASH_MAP = new HashMap<VertexModel, VertexView>();
	private final ShapeRenderer EDGE_RENDERER = new ShapeRenderer();
	private InputDialog inputDialog;
	private OutputDialog outputDialog;
	public void initialise() {
		addSymbol(SymbolType.PROCESS, 450, 600);
	}
	public void drawEdges() {
		EDGE_RENDERER.begin(ShapeRenderer.ShapeType.Line);
		EDGE_RENDERER.setColor(1, 1, 1, 1);
		VertexModel currentVertex = MODEL.getStartVertex();
		while (currentVertex.getNextVertex() != null) {
			if (currentVertex instanceof SymbolModel) {
				drawEdge(((SymbolView) getView(currentVertex)).getOutPoint(), getView(currentVertex.getNextVertex()).getInPoint());
			}
			currentVertex = currentVertex.getNextVertex();
		}
		EDGE_RENDERER.end();
	}
	private void drawEdge(Vector2 startPoint, Vector2 endPoint) {
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
				((ProcessView) symbolView).getVariableSelectBox().addListener(new SelectBoxStateListener(symbolView, SymbolType.PROCESS));
				((ProcessView) symbolView).getOperationSelectBox().addListener(new SelectBoxStateListener(symbolView, SymbolType.PROCESS));
				((ProcessView) symbolView).getValueTextField().setTextFieldListener(new TextFieldStateListener(symbolView, SymbolType.PROCESS));
				break;
			case IO:
				symbolView = new InputOutputView();
		}
		symbolView.setPosition(x, y);
		symbolView.moved();
		symbolView.getImage().addListener(new DragAndDropListener(symbolView));
		VertexModel vertexModel;
		if (VERTEX_VIEW_HASH_MAP.isEmpty()) {
			vertexModel = MODEL.addStartVertex();
		} else {
			vertexModel = MODEL.addSymbol(symbolType);
		}
		VERTEX_VIEW_HASH_MAP.put(symbolView, vertexModel);
		VERTEX_MODEL_HASH_MAP.put(vertexModel, symbolView);
	}
	public void execute() {
		MODEL.execute();
	}
	public void execute(VertexModel startVertex) {
		MODEL.execute(startVertex);
	}
	public void input(Variable variable, VertexModel nextVertex) {
	}
	public void output(Variable variable, VertexModel nextVertex) {
	}
	private VertexView getView(VertexModel vertexModel) {
		return VERTEX_MODEL_HASH_MAP.get(vertexModel);
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
			setTapSquareSize(0);
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
	private final class SelectBoxStateListener extends ChangeListener {
		private SymbolView symbolView;
		private SymbolType symbolType;
		public SelectBoxStateListener(SymbolView symbolView, SymbolType symbolType) {
			this.symbolView = symbolView;
			this.symbolType = symbolType;
		}
		@Override
		public void changed(ChangeEvent event, Actor actor) {
			switch (symbolType) {
				case PROCESS:
					((ProcessModel) VERTEX_VIEW_HASH_MAP.get(symbolView)).setVariable(((ProcessView) symbolView).getCurrentVariable());
					((ProcessModel) VERTEX_VIEW_HASH_MAP.get(symbolView)).setOperation(((ProcessView) symbolView).getCurrentOperation());
			}
		}
	}
	private final class TextFieldStateListener implements TextFieldListener {
		private SymbolView symbolView;
		private SymbolType symbolType;
		public TextFieldStateListener(SymbolView symbolView, SymbolType symbolType) {
			this.symbolView = symbolView;
			this.symbolType = symbolType;
		}
		@Override
		public void keyTyped(TextField textField, char c) {
			switch (symbolType) {
				case PROCESS:
					try {
						((ProcessModel) VERTEX_VIEW_HASH_MAP.get(symbolView)).setValue(Integer.parseInt(((ProcessView) symbolView).getCurrentValue()));
						((ProcessModel) VERTEX_VIEW_HASH_MAP.get(symbolView)).setActive(true);
					} catch (NumberFormatException e) {
						((ProcessModel) VERTEX_VIEW_HASH_MAP.get(symbolView)).setActive(false);
					}
			}
		}
	}
}