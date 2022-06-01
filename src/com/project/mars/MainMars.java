package com.project.mars;



import com.project.mars.utils.PrepareAnimation;
import com.project.mars.utils.SmartGroup;
import com.project.mars.utils.intMouseControl;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class MainMars extends Application{

	private static final Integer WIDTH = 1400;
	private static final Integer HEIGHT = 800;
	private final Sphere sphere = new Sphere(198);
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
		
		Slider slider = prepareSlider();
		world.translateZProperty().bind(slider.valueProperty());
		
		Group root = new Group();
		root.getChildren().add(world);
		root.getChildren().add(prepareImageView());
		root.getChildren().add(slider);
 		
		Scene scene = new Scene(root,WIDTH,HEIGHT,true);
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
	
	private Slider prepareSlider() {
		Slider slider = new Slider();
		slider.setMax(200);
		slider.setMin(-900);
		slider.setPrefWidth(300d);
		slider.setPrefHeight(87);
		slider.setLayoutX(-150);
		slider.setLayoutY(200);
		slider.setShowTickLabels(true);
		slider.setTranslateZ(2);
		slider.setStyle("-fx-base: black");
		return slider;
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
		imageView.getTransforms().add(new Translate(-image.getWidth() / 2, -image.getHeight() / 2, 100));
		return imageView;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

} 
