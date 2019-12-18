package main;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import control.GameManager;
import createchar.CreateCharScene;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class HomePage extends StackPane {
	
	private Image backgroundImage;
	private Button startButton;
	private Image buttonImage;
	private Canvas canvas;
	private GraphicsContext gc;
	private GameManager manager;
	private Stage primaryStage;
	
	public HomePage(GameManager manager) {
		this.manager = manager;
		primaryStage = manager.getStage();
		canvas = new Canvas(500,800);
		gc = canvas.getGraphicsContext2D();
		startButton = new Button();
		startButton.setPadding(new Insets(10));
		startButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
					CornerRadii.EMPTY, BorderWidths.EMPTY)));
		startButton.setStyle("-fx-background-color: transparent;");
		backgroundImage = new Image(ClassLoader.getSystemResource("startbg.png").toString(), 500, 800, false, false);
		buttonImage = new Image(ClassLoader.getSystemResource("bfpressed.png").toString(), 320, 100, false, false);
		startButton.setGraphic(new ImageView(buttonImage));
		setAlignment(startButton, Pos.BOTTOM_CENTER);
		setButtonAction(startButton);
		getChildren().addAll(canvas,startButton);
		gc.drawImage(backgroundImage, 0, 0);
	}
	public void setButtonAction(Button button) {
		 button.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("pressed.png").toString(), 320, 100, false, false)));
			}
		 });
		 button.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("bfpressed.png").toString(), 320, 100, false, false)));
			}
		});
		 button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					CreateCharScene nextScene = new CreateCharScene(manager);
					nextScene.setAlignment(Pos.CENTER);
					primaryStage.setScene(new Scene(nextScene, 500, 800));
				}			
			});
	 }
}
