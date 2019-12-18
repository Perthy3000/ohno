package pokeball;

import java.util.ArrayList;
import java.util.List;

import button.FeedButton;
import control.GameManager;
import control.Player;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import mainmenu.MainMenuScene;
import pokemon.Charmander;
import pokemon.Gyarados;
import pokemon.Magikarp;
import pokemon.Pokemon;

public class InfoArea extends VBox {

	private Pokemon pokemon;
	private Player player;
	private TextField nameField;
	private List<FeedButton> feedingButton;
	private Label expLabel;
	private Label moneyLabel;
	private LevelUp levelUp;
	private Image buttonImage;
	private Button exitButton;
	private int index;
	
	public InfoArea(int index, GameManager manager, StatArea statArea,LevelUp levelUp) {
		this.player = manager.getPlayer();
		pokemon = player.getpokenList().get(index);
		this.index = index;
		this.levelUp = levelUp;
		Label nameLabel = new Label("");
		getChildren().add(nameLabel);
		setNameField();
		expLabel = new Label("           "+pokemon.getExp()+"/"+pokemon.getMaxExp());
		moneyLabel = new Label("                     "+Integer.toString(player.getMoney()));
		expLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
		moneyLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
		feedingButton = new ArrayList<FeedButton>();
		getChildren().addAll(moneyLabel, expLabel);
		setFeedingButton(statArea);	//set all feeding button
		setPadding(new Insets(10));
		setSpacing(20);
		exitButton = new Button();
		exitButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		exitButton.setStyle("-fx-background-color: transparent;");
		buttonImage = new Image(ClassLoader.getSystemResource("exitbf.png").toString(), 70, 42, false, false);
		exitButton.setGraphic(new ImageView(buttonImage));
		//set exit button
				exitButton.setOnAction(new EventHandler<ActionEvent>() {	
					@Override
					public void handle(ActionEvent arg0) {
						MainMenuScene nextMainMenuScene = new MainMenuScene(manager);
						Scene nextScene = new Scene(nextMainMenuScene, 500, 800);
						levelUp.setPrimaryStage(nextScene);
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

				getChildren().add(exitButton);
	}
	
	private void setFeedingButton(StatArea statArea) {
		VBox feedBox = new VBox();
		feedBox.setSpacing(10);
		feedBox.setAlignment(Pos.CENTER_LEFT);
		int exp = 10;
		for(int i = 0; i < 3; i++) {
			final int x=i+1;
			FeedButton feedButton = new FeedButton(exp+i*5,x);
			feedButton.setOnAction(new EventHandler<ActionEvent>() {
				//when press will add exp and reduce money
				@Override
				public void handle(ActionEvent arg0) {
					if(player.getMoney() >= feedButton.getCost()) {
						pokemon.addExp(feedButton.getExp());
						player.setMoney(player.getMoney()-feedButton.getCost());
						expLabel.setText("           "+pokemon.getExp()+"/"+pokemon.getMaxExp());
						moneyLabel.setText("                     "+Integer.toString(player.getMoney()));
						//check for gyarados
						if(pokemon instanceof Magikarp && pokemon.getLevel() > 5) {
							if(!pokemon.getName().equals("Magikarp")) {
								player.getpokenList().set(index, new Gyarados(pokemon.getName()));
							} else {
								player.getpokenList().set(index, new Gyarados());
							}
							pokemon = player.getpokenList().get(index);
							levelUp.setPokemonImage(pokemon);
							levelUp.setNameLabel(pokemon.getName());
						}
						statArea.update();
					} else {
						//add exception
					}
				}
			});
			feedButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					feedButton.setGrapicAf(x);
				}
			 });
			feedButton.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					feedButton.setGrapicBf(x);
				}
			});
			feedingButton.add(feedButton);
			feedBox.getChildren().add(feedButton);
		}
		getChildren().add(feedBox);
	}
	
	//setting up nameField and change button
	private void setNameField() {
		HBox nameBox = new HBox();
		nameField = new TextField();
		Button changeButton = new Button("Confirm");
		nameBox.setSpacing(5);
		//when pressing confirm will change pokemon name
		changeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				pokemon.setName(nameField.getText());
				levelUp.setNameLabel(nameField.getText());
			}
		});
		
		nameBox.getChildren().addAll(nameField, changeButton);
		getChildren().add(nameBox);
	}
	
}
