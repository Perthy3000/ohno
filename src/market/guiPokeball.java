package market;

import button.BuyButton;
import control.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import pokemon.*;

public class guiPokeball extends TilePane {
	private int index;
//	private int diff;
//	private int currentdiff;
	private ObservableList<BuyButton> poke = FXCollections.observableArrayList();
	private Blackmarket blackmarket;
	private Player player;
	
	public guiPokeball (Blackmarket blackmarket,Player player) {
		setPrefColumns(3);
		setHgap(10);
		setVgap(10);
		setPrefWidth(250);
		this.setAlignment(Pos.CENTER_LEFT);
		//logListView = new ListView<PokeButton>(poke);
		this.blackmarket = blackmarket;
		setPrefHeight(150);
		this.player = player;
		//getChildren().add(new Text(""));
	}
	
	public void addData(Pokemon pokemon) {
		BuyButton pokemonButton = new BuyButton(pokemon);
		index = poke.size();
		setPokeButton(pokemonButton, index);
		pokemonButton.setText("Sell");
		System.out.println(index);
		//this.index=((player.getpokenList().size())-currentdiff);
		poke.add(pokemonButton);
		VBox vbox = new VBox();
		Button Button = new Button();
		Button.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		Button.setStyle("-fx-background-color: transparent;");
		String url;
		 if(pokemonButton.getPokemon() instanceof Squirtle) {
				url = "sqt.png";
			 }
			 else if(pokemonButton.getPokemon() instanceof Bulbasaur) {
				 url = "bbs.png";
			 }
			 else if(pokemonButton.getPokemon() instanceof Charmander) {
				 url = "cmd.png";
			 }
			 else if(pokemonButton.getPokemon() instanceof Pikachu) {
				 url = "pkc.png";
			 }
			 else if(pokemonButton.getPokemon() instanceof Gyarados) {
				 url = "qyd.png";
			 }
			 else {
				 url = "mgk.png";
			 }
		Button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource(url).toString(), 85, 100, false, false)));
		Label nameL = new Label(pokemonButton.getPokkenName());
		nameL.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(Button,nameL,pokemonButton);
		getChildren().add(vbox);
	}
	
	private void setPokeButton(BuyButton button, int index) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {

				System.out.println(index);
				removePokeButton(index);
				blackmarket.getBuyLog().addData(button.getPokkenName()+" was sold for " + button.getCost() + "$"); 
				player.setMoney(player.getMoney()+button.getCost());
				blackmarket.getShop().setMoneyLabel(player.getMoney());
				player.getpokenList().remove(index);
			}
		});
	}
	
	private void removePokeButton(int index) {
		poke.remove(index);
		for(int i = 0; i < poke.size(); i++) {
			setPokeButton(poke.get(i), i);
		}
		getChildren().remove(index);
	}
	
}
