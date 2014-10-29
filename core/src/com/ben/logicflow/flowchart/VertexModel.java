package com.ben.logicflow.flowchart;

import com.badlogic.gdx.math.Vector2;

public abstract class VertexModel {
	private VertexModel nextVertexModel;
	private final Vector2 POSITION = new Vector2();
	public VertexModel getNextVertexModel() {
		return nextVertexModel;
	}
	public void setPosition(float x, float y) {
		POSITION.set(x, y);
	}
	public void setNextVertexModel(VertexModel vertexModel) {
		nextVertexModel = vertexModel;
	}
}