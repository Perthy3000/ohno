package button;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import pokemon.*;

public class PokemonButton extends Button{
	
	 private Pokemon pokemon;
	 private int cost;
	 private boolean isSelected = false;
	 
	 public PokemonButton(Pokemon pokemon) {
		this.pokemon = pokemon;
		this.setPadding(new Insets(10));
		setBorder(new Border(new BorderStroke(Color.BEIGE,BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setStyle("");
		setPrefSize(5, 5);
 
		setButtonImage();
		setAction();
	}
	 
	 private void setButtonImage() {
		 String url;
		 if(pokemon instanceof Squirtle) {
			 url = "squirtle.png"; cost = 100;
		 }
		 else if(pokemon instanceof Bulbasaur) {
			 url = "Bulbasaur.png"; cost = 100;
		 }
		 else if(pokemon instanceof Charmander) {
			 url = "charmander.png"; cost = 100;
		 }
		 else if(pokemon instanceof Pikachu) {
			 url = "Pikachu.png"; cost = 800;
		 }
		 else {
			 url = "yo.png"; cost = 4000;
		 }
		 setGraphic(new ImageView(new Image(ClassLoader.getSystemResource(url).toString())));
	 }
	 
	 private void setAction() {
		 String style, defaultstyle = "";
		 if(pokemon instanceof Charmander) style = "-fx-background-color : #FF9933";
		 else if(pokemon instanceof Bulbasaur) style = "-fx-background-color : #99CC33";
		 else if(pokemon instanceof Squirtle) style = "-fx-background-color : #00CCCC";
		 else if(pokemon instanceof Pikachu) style = "-fx-background-color : #FFCC33";
		 else if(pokemon instanceof Magikarp) style = "-fx-background-color : #00CCCC";
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
