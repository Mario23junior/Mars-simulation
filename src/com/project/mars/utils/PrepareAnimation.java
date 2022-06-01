package com.project.mars.utils;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Sphere;

public class PrepareAnimation {
  
	public void PrepareAnimationSphere(Sphere sphere) {
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
 				sphere.rotateProperty().set(sphere.getRotate() + 0.3);
 			}
		};
		timer.start();
 	}
}
