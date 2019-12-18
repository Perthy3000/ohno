package main;

import control.GameManager;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application  {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox();
		GameManager gameManager = new GameManager(primaryStage);
		HomePage homePage = new HomePage(gameManager);
		root.setAlignment(Pos.TOP_CENTER);
		root.getChildren().add(homePage);
		primaryStage.setTitle("Pokemon game");
		Scene scene = new Scene(root,500,800);
 		primaryStage.setScene(scene);
 		primaryStage.setResizable(false);
 		primaryStage.show();
	}

}
