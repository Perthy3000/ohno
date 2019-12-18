package mainmenu;

import exception.NoPokemonException;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import market.Blackmarket;
import pokeball.Pokeball;
import battle.Battle;
import control.GameManager;
import control.Player;

public class MainMenu extends VBox {
	
	private Button shopButton;
	private Button randomBattleButton;
	private Button PokeballButton;
	private Player player;
	private GameManager manager;

	public MainMenu(GameManager manager) {
		this.manager = manager;
		Stage primaryStage = manager.getStage();
		setAlignment(Pos.CENTER);
		setSpacing(20);
		shopButton = new Button();
		randomBattleButton = new Button();
		PokeballButton = new Button();
		shopButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		shopButton.setStyle("-fx-background-color: transparent;");
		shopButton.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("shopbf.png").toString(), 430, 180, false, false)));
		
		randomBattleButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		randomBattleButton.setStyle("-fx-background-color: transparent;");
		randomBattleButton.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("battlebf.png").toString(), 430, 180, false, false)));
		
		PokeballButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		PokeballButton.setStyle("-fx-background-color: transparent;");
		PokeballButton.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("pokeaf.png").toString(), 430, 180, false, false)));
		setButtonAction(PokeballButton,primaryStage);
		setButtonAction(randomBattleButton,primaryStage);
		setButtonAction(shopButton,primaryStage);
		setAction(PokeballButton);
		setAction(randomBattleButton);
		setAction(shopButton);
		player = manager.getPlayer();
		setButtonAction(randomBattleButton, primaryStage);
		setButtonAction(shopButton, primaryStage);
		//getChildren().addAll( new Label(player.getName()), nameLabel, moneyLabel);
		getChildren().addAll(shopButton, randomBattleButton, PokeballButton);
	}
	
	private void setButtonAction(Button button, Stage primaryStage) {
		if(button==randomBattleButton) {
			button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					try {
						new Battle(manager);
					} catch (NoPokemonException e) {
						e.showAlertBox();
					}						
				}			
			});
		}
	
		else if(button == shopButton) {
			button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					Blackmarket rootNode = new Blackmarket(manager);
					Scene nextScene = new Scene(rootNode, 590, 800);
					primaryStage.setScene(nextScene);
				}			
			});
		}
		else {
			button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					Pokeball pokeball = new Pokeball(manager);
					Scene nextScene = new Scene(pokeball, 500, 800);
					primaryStage.setScene(nextScene);
				}
			});
		}
		
	}
	public void setAction(Button button) {
		 button.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(button == shopButton)
				button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("shopaf.png").toString(), 430, 180, false, false)));
				else if(button == PokeballButton)
					button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("pokebf.png").toString(), 430, 180, false, false)));
				else 
					button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("battleaf.png").toString(), 430, 180, false, false)));
			}
		 });
		 button.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(button == shopButton)
					button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("shopbf.png").toString(), 430, 180, false, false)));
					else if(button == PokeballButton)
						button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("pokeaf.png").toString(), 430, 180, false, false)));
					else 
						button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("battlebf.png").toString(), 430, 180, false, false)));
			}
		});
	
	 }
	
}
