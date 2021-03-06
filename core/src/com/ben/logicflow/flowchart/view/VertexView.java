package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ben.logicflow.Application;
import com.ben.logicflow.Assets;

public class VertexView {
	private Image image;
	private final Vector2 IN_POINT = new Vector2();
	private final Image ARROW_HEAD = new Image(Assets.getArrowHead());
	private boolean arrowHeadVisible;
	public VertexView(TextureRegion textureRegion) {
		image = new Image(textureRegion);
		image.setColor(image.getColor().r, image.getColor().g, image.getColor().b, 0.85f);
		Application.addActor(image);
		Application.addActor(ARROW_HEAD);
	}
	public void moved() {
		IN_POINT.set(getX() + (getWidth() / 2), getY() + getHeight());
		ARROW_HEAD.setPosition(IN_POINT.x - (ARROW_HEAD.getWidth() / 2), IN_POINT.y + ARROW_HEAD.getHeight());
	}
	public Image getImage() {
	return image;
}
	protected float getWidth() {
		return image.getWidth();
	}
	protected float getHeight() {
		return image.getHeight();
	}
	public float getX() {
		return image.getX();
	}
	public float getY() {
		return image.getY();
	}
	public Vector2 getInPoint() {
		return IN_POINT;
	}
	public Image getArrowHead() {
		return ARROW_HEAD;
	}
	public void setPosition(float x, float y) {
		image.setPosition(x, y);
	}
	public void setVisible(boolean visible) {
		image.setVisible(visible);
		if (! visible) {
			ARROW_HEAD.setVisible(false);
		} else if (arrowHeadVisible) {
			ARROW_HEAD.setVisible(true);
		}
	}
	public void setArrowHeadVisible(boolean arrowHeadVisible) {
		this.arrowHeadVisible = arrowHeadVisible;
	}
}