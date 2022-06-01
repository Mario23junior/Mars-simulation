package com.project.mars;



import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class MainMars extends Application{

	private static final Integer WIDTH = 1400;
	private static final Integer HEIGHT = 1000;

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Camera camera = new PerspectiveCamera(true);
		camera.translateXProperty().set(0);
		camera.translateYProperty().set(0);
		camera.translateZProperty().set(-500);
		camera.setNearClip(1);
		camera.setFarClip(1000);

		SmartGroup world = new SmartGroup();
		
		
		Scene scene = new Scene(group,WIDTH,HEIGHT);
		scene.setFill(Color.SILVER);
		scene.setCamera(camera);
		
		primaryStage.setTitle("Planeta Mars");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			switch (event.getCode()) {
				
			case A:
				camera.translateZProperty().set(camera.getTranslateZ() + 10);
				 break;
				 
			case S:
				camera.translateZProperty().set(camera.getTranslateZ() - 10);
				 break;
				default:
					break;
	    	}
		});
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

} 
