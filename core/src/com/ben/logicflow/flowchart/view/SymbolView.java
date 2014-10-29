package com.ben.logicflow.flowchart.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.ben.logicflow.Assets;
import com.ben.logicflow.flowchart.FlowchartController;

public abstract class SymbolView extends VertexView {
	private final Table TABLE = new Table(Assets.getSkin());
	private final Vector2 OUT_POINT = new Vector2();
	public SymbolView(TextureRegion textureRegion, FlowchartController controller) {
		super(textureRegion, true, controller);
	}
	@Override
	public void update() {
		super.update();
		TABLE.setPosition(getImage().getX() + (getImage().getWidth() / 2), getImage().getY() + (getImage().getHeight() / 2));
		OUT_POINT.set(getImage().getX() + (getImage().getWidth() / 2), getImage().getY());
	}
	public Table getTable() {
		return TABLE;
	}
	public Vector2 getOutPoint() {
		return OUT_POINT;
	}
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		TABLE.setVisible(visible);
	}
}