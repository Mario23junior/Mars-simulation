package com.project.mars;



import com.project.mars.utils.PrepareAnimation;
import com.project.mars.utils.SmartGroup;
import com.project.mars.utils.intMouseControl;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class MainMars extends Application{

	private static final Integer WIDTH = 1400;
	private static final Integer HEIGHT = 800;
	private final Sphere sphere = new Sphere(258);
	public static final String IMAGE = "/texture/mars.jpg";
	public static final String IMAGE_BACKGROUND = "/texture/back.jpg";

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Camera camera = new PerspectiveCamera(true); 
		camera.setNearClip(1);
		camera.setFarClip(10000);
		camera.translateZProperty().set(-1000);

		SmartGroup world = new SmartGroup();
		world.getChildren().add(prepareMars());
		world.getChildren().add(prepareImageView());
		
		Scene scene = new Scene(world,WIDTH,HEIGHT,true);
		scene.setFill(Color.SILVER);
		scene.setCamera(camera);
		
		intMouseControl mouseContro = new intMouseControl();
		mouseContro.intMouseControls(world, scene, primaryStage);
		
		primaryStage.setTitle("Planeta Mars");
		primaryStage.setScene(scene);
		primaryStage.show();	
		
	    PrepareAnimation prepareAnimation = new PrepareAnimation();
	    prepareAnimation.PrepareAnimationSphere(sphere);
		
	    
	   
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
	
	private Node prepareMars() {
		PhongMaterial marsMateria = new PhongMaterial();
		marsMateria.setDiffuseMap(new Image(getClass().getResourceAsStream(IMAGE)));
 
		sphere.setRotationAxis(Rotate.Y_AXIS);
 		sphere.setMaterial(marsMateria);
   		return sphere;
	}

	private ImageView prepareImageView() {
		Image image = new Image(MainMars.class.getResourceAsStream(IMAGE_BACKGROUND));
		ImageView imageView = new ImageView(image);
		imageView.setPreserveRatio(true);
		return imageView;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

} 
