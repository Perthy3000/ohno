package market;

import control.GameManager;
import control.Player;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mainmenu.MainMenuScene;
import pokemon.Pokemon;

public class Blackmarket extends VBox {
	
	private PokemonShop shop;
	private Buyinglog shoplog;
	private guiPokeball pokelog;
	private Image buttonImage;
	
	public Blackmarket(GameManager manager) {
		Player player = manager.getPlayer();
		Stage primaryStage = manager.getStage();
		Image image = new Image ("marketbg.png");
	    setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
	                                                                  BackgroundRepeat.REPEAT,
	                                                                  BackgroundPosition.DEFAULT,
	                                                                  BackgroundSize.DEFAULT)));
		pokelog = new guiPokeball(this,player);
		shoplog = new Buyinglog();
		setPadding(new Insets(10));
		setAlignment(Pos.TOP_CENTER);
		setSpacing(20);
		shop = new PokemonShop(player, primaryStage, this);
		int loop=0;
		for(Pokemon i : player.getpokenList()) {
			this.pokelog.addData(i);
			System.out.println(i.getName());
		}
		this.getChildren().add(shoplog);
		VBox pokeball = new VBox();
		pokeball.setSpacing(10);
		Label PokeballZone = new Label("Poke Balls");
		PokeballZone.setFont(new Font(18));
		PokeballZone.setStyle("-fx-text-fill: white");
		pokeball.getChildren().addAll(PokeballZone,pokelog);
		
		this.getChildren().add(pokeball);
		Button exitButton = new Button();

		exitButton.setPrefSize(70, 50);
		exitButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		exitButton.setStyle("-fx-background-color: transparent;");
		buttonImage = new Image(ClassLoader.getSystemResource("exitbf.png").toString(), 70, 42, false, false);
		exitButton.setGraphic(new ImageView(buttonImage));
		HBox exit =  new HBox();
		exit.setAlignment(Pos.BOTTOM_CENTER);
		exit.getChildren().add(exitButton);
		exit.setPrefHeight(230);
		exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				primaryStage.setScene(new Scene(new MainMenuScene(manager), 500, 800));
				primaryStage.setTitle("Main Menu");
			}
		});
		exitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				exitButton.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exitaf.png").toString(), 70, 42, false, false)));
			}
		 });
		exitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				exitButton.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exitbf.png").toString(), 70, 42, false, false)));
			}
		});
		this.getChildren().add(exit);
	}
	
	public Buyinglog getBuyLog() {
		return this.shoplog;
	}
	public guiPokeball getPokeLog() {
		return this.pokelog;
	}
	public PokemonShop getShop() {
		return this.shop;
	}
}



