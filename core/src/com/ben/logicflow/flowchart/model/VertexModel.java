package com.ben.logicflow.flowchart.model;

import com.badlogic.gdx.math.Vector2;

public abstract class VertexModel {
	private VertexModel nextVertexModel;
	private final Vector2 POSITION = new Vector2();
	public VertexModel getNextVertex() {
		return nextVertexModel;
	}
	public void setNextVertex(VertexModel vertexModel) {
		nextVertexModel = vertexModel;
	}
	public void setPosition(float x, float y) {
		POSITION.set(x, y);
	}
}