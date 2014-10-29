package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class VertexView {
	private Image image;
	private final Vector2 IN_POINT = new Vector2();
	public VertexView(TextureRegion textureRegion) {
		image = new Image(textureRegion);
		image.setColor(image.getColor().r, image.getColor().g, image.getColor().b, 0.85f);
	}
	public Image getImage() {
	return image;
}
	public Vector2 getInPoint() {
		return IN_POINT;
	}
	public void setPosition(float x, float y) {
		image.setPosition(x, y);
	}
	public void setVisible(boolean visible) {
		image.setVisible(visible);
	}
}