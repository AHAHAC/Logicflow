/*
package com.ben.logicflow.flowchart;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.ben.logicflow.Assets;

public final class Decision extends Vertex implements ISymbol {
	private FlowchartModel flowchartModel;
	private Vertex nextFalseVertex;
	private final SelectBox<String> VARIABLES = new SelectBox<String>(Assets.getSkin());
	private final SelectBox<Comparison> OPERATIONS = new SelectBox<Comparison>(Assets.getSkin());
	private final TextField VALUE = new TextField("", Assets.getSkin());
	public Decision(FlowchartModel flowchartModel) {
		super(Assets.getProcess());
		this.flowchartModel = flowchartModel;
		VARIABLES.setItems("X", "Y", "Z");
		getTable().add(VARIABLES).space(10);
		OPERATIONS.setItems(new Comparison(ComparisonOperation.EQ), new Comparison(ComparisonOperation.NE), new Comparison(ComparisonOperation.GT), new Comparison(ComparisonOperation.GE), new Comparison(ComparisonOperation.LT), new Comparison(ComparisonOperation.LE));
		getTable().add(OPERATIONS).space(10);
		VALUE.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
		VALUE.setMaxLength(5);
		getTable().add(VALUE).width(51).space(10);
	}
	@Override
	public Vertex execute() {
		try {
			Variable variable;
			if (VARIABLES.getSelected().equals("X")) {
				variable = Variable.X;
			} else if (VARIABLES.getSelected().equals("Y")) {
				variable = Variable.Y;
			} else {
				variable = Variable.Z;
			}
			int value = Integer.parseInt(VALUE.getText());
			switch (OPERATIONS.getSelected().getOperation()) {
				case EQ:
					if (flowchartModel.getVariable(variable) == value) {
						return getNextVertex();
					} else {
						return nextFalseVertex;
					}
				case NE:
					if (flowchartModel.getVariable(variable) != value) {
						return getNextVertex();
					} else {
						return nextFalseVertex;
					}
				case GT:
					if (flowchartModel.getVariable(variable) > value) {
						return getNextVertex();
					} else {
						return nextFalseVertex;
					}
				case GE:
					if (flowchartModel.getVariable(variable) >= value) {
						return getNextVertex();
					} else {
						return nextFalseVertex;
					}
				case LT:
					if (flowchartModel.getVariable(variable) < value) {
						return getNextVertex();
					} else {
						return nextFalseVertex;
					}
				case LE:
					if (flowchartModel.getVariable(variable) <= value) {
						return getNextVertex();
					} else {
						return nextFalseVertex;
					}
			}
		} catch (NumberFormatException ignored) {
		}
		return null;
	}
	public void setNextFalseVertex(Vertex falseVertex) {
		nextFalseVertex = falseVertex;
	}
	private class Comparison {
		private ComparisonOperation operation;
		protected Comparison(ComparisonOperation comparisonOperation) {
			operation = comparisonOperation;
		}
		@Override
		public String toString() {
			switch (operation) {
				case EQ:
					return "=";
				case NE:
					return "!=";
				case GT:
					return ">";
				case GE:
					return ">=";
				case LT:
					return "<";
				case LE:
					return "<=";
				default:
					return "nope";
			}
		}
		public ComparisonOperation getOperation() {
			return operation;
		}
	}
}
*/