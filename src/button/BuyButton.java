package button;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pokemon.*;

public class BuyButton extends Button {
	 private Pokemon pokemon;
	 private int cost;
	 private boolean isSelected = false;
	 public BuyButton(Pokemon pokemon) {
			this.pokemon = pokemon;
			this.setPadding(new Insets(5));
		//	setText(arg0);
			setText("Buy");
			setPrefSize(90, 5);
			setButtonCost();
			setAction();
		}
	 private void setButtonCost() {
		 if(pokemon instanceof Squirtle) {
			cost = 100;
		 }
		 else if(pokemon instanceof Bulbasaur) {
			 cost = 100;
		 }
		 else if(pokemon instanceof Charmander) {
			  cost = 100;
		 }
		 else if(pokemon instanceof Pikachu) {
			  cost = 800;
		 }
		 else if(pokemon instanceof Gyarados) {
			 cost = 10000;
		 }
		 else {
			 cost = 4000;
		 }
		// setGraphic(new ImageView(new Image(ClassLoader.getSystemResource(url).toString())));
	 }
	 
	 private void setAction() {
		 String style, defaultstyle = "";
		 if(pokemon instanceof Charmander) style = "-fx-background-color : #FF9933";
		 else if(pokemon instanceof Bulbasaur) style = "-fx-background-color : #99CC33";
		 else if(pokemon instanceof Squirtle) style = "-fx-background-color : #00CCCC";
		 else if(pokemon instanceof Pikachu) style = "-fx-background-color : #FFCC33";
		 else if(pokemon instanceof Magikarp) style = "-fx-background-color : #00CCCC";
		 else if(pokemon instanceof Gyarados)style = "-fx-background-color : #00CCCC";
		 else style = defaultstyle;
		 
		 setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(!isSelected) setStyle(style);					
			}
		 });
		 setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(!isSelected) setStyle(defaultstyle);
			}
		});
	 }
	 
	 public void setSelected() {
		 isSelected = true;
		 setAction();
	 }
	 
	 public void setUnselected() {
		 isSelected = false;
		 setStyle("");
	 }
	 
	 public String getPokkenName() {
		 return pokemon.getName();
	 }
	 
	 public int getCost() {
		 return cost;
	 }
	 public Pokemon getPokemon() {
		 return this.pokemon;
	 }
}
