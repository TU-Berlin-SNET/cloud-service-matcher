package de.tub.fokus.sm.cp.model;

import de.tub.fokus.sm.cp.model.specs.QoSSpec;

public interface Evaluator {
	public void evaluate(QoSSpec qoSSpec);
}