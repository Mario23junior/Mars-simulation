package com.project.mars.utils;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public class SmartGroup extends Group {

	Rotate r;
	Transform t = new Rotate();

	void rotateByX(int angu) {
		r = new Rotate(angu, Rotate.X_AXIS);
		t = t.createConcatenation(r);
		this.getTransforms().clear();
		this.getTransforms().addAll(t);
	}

	void rotateByY(int angu) {
		r = new Rotate(angu, Rotate.Y_AXIS);
		t = t.createConcatenation(r);
		this.getTransforms().clear();
		this.getTransforms().addAll(t);
	}
}
