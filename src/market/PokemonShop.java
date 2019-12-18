package market;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import button.BuyButton;
import control.Player;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pokemon.*;
 

public class PokemonShop {
	
	private Player player;
	private Blackmarket blackmarket;
	private Stage primarystage;
	private TilePane show;
	private TilePane show2;
	private VBox bigshow;
	private List<BuyButton> pokeButtons;
	Label buyingZone = new Label("Black Market");
	private Label moneyLabel;
	public PokemonShop(Player player, Stage primarystage, Blackmarket blackmarket) {
		pokeButtons = new ArrayList<BuyButton>();
		pokeButtons.add(new BuyButton(new Charmander()));
		pokeButtons.add(new BuyButton(new Squirtle()));
		pokeButtons.add(new BuyButton(new Bulbasaur()));
		pokeButtons.add(new BuyButton(new Pikachu()));
		pokeButtons.add(new BuyButton(new Magikarp()));
		this.player = player;
		this.blackmarket = blackmarket;
		this.primarystage = primarystage;
		buyingZone.setFont(new Font(18));
		prompt();
	}
	
	public void prompt() {
		System.out.println("========================");
		System.out.println("Welcome to Black Market Shop");
		System.out.println("Select Pokemon :");
		System.out.println("1: Magikarp");
		System.out.println("2: Choi, The Genius");
		System.out.println("3: Perth3000, The God");
		System.out.println("4: Exit Shop");
		System.out.println("========================");
		this.show = new TilePane();
		show.setAlignment(Pos.CENTER);
		show.setPrefColumns(3);
		for(BuyButton pokeButton : pokeButtons) {
			show.getChildren().add(pokeButton);
			setPokeButton(pokeButton);
		}
		show.setHgap(15); show.setVgap(10);
		
		this.show2 = new TilePane();
		Button Button1 = new Button();
		Button1.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		Button1.setStyle("-fx-background-color: transparent;");
		Button1.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("charmanderbox.png").toString(), 90, 210, false, false)));
		
		Button Button2 = new Button();
		Button2.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		Button2.setStyle("-fx-background-color: transparent;");
		Button2.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("squirtlebox.png").toString(), 90, 210, false, false)));
		Button Button3 = new Button();
		Button3.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		Button3.setStyle("-fx-background-color: transparent;");
		Button3.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("bubasaurbox.png").toString(), 90, 210, false, false)));
		Button Button4 = new Button();
		Button4.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		Button4.setStyle("-fx-background-color: transparent;");
		Button4.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("pikaboxbf.png").toString(), 90, 210, false, false)));
		Button Button5 = new Button();
		Button5.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		Button5.setStyle("-fx-background-color: transparent;");
		Button5.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("magikarpbox.png").toString(), 90, 210, false, false)));
		show2.setAlignment(Pos.CENTER);
		show2.setPrefColumns(1);
		
		show2.getChildren().addAll(Button1,Button2,Button3,Button4,Button5);
	
		show2.setHgap(0); show2.setVgap(0);
		
		moneyLabel = new Label("Money : " + player.getMoney());
		moneyLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
	
		bigshow = new VBox();
		bigshow.setSpacing(10);
		this.blackmarket.getChildren().addAll(moneyLabel,bigshow);
		
		bigshow.getChildren().addAll(show2,show);
	}
	public void setMoneyLabel(int money) {
		String moneyy;
		moneyy = String.valueOf(money);
		moneyLabel.setText("Money : " +moneyy);
	}
	public void run(String name) {
		if(player.getpokenList().size() < 6) {
			switch(name) {
			case "Magikarp" :
				if(player.getMoney() >= 4000) {
					Pokemon Magikarp = new Magikarp();
					this.player.setPokeball(Magikarp);
					this.player.addPokemon(Magikarp);
					blackmarket.getBuyLog().addData("Magikarp is added!");
					blackmarket.getPokeLog().addData(Magikarp);
					System.out.println("Magikarp is added!");
					player.setMoney(player.getMoney()-4000);
					setMoneyLabel(player.getMoney());
				}
			
				else {
				System.out.println("Not Enough Money! Comeback next time!");
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!"); 
				}
				break;
			case "Pikachu" :
				if(player.getMoney() >= 800) {
					Pokemon Choi = new Pikachu();
					this.player.setPokeball(Choi);
					this.player.addPokemon(Choi);
					blackmarket.getBuyLog().addData("Pikachu is added!");
					blackmarket.getPokeLog().addData(Choi);
				System.out.println("Pikachu is added!");
					player.setMoney(player.getMoney()-800);
					setMoneyLabel(player.getMoney());
				}
			
				else {
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!");
				}
				break;
			case "Squirtle" :
				if(player.getMoney() >= 100) {
				Pokemon Perth = new Squirtle();
				this.player.setPokeball(Perth);
				this.player.addPokemon(Perth);
				blackmarket.getBuyLog().addData("Squirtle is added!");
				blackmarket.getPokeLog().addData(Perth);
			System.out.println("Squirtle is added!");
				player.setMoney(player.getMoney()-100);
				setMoneyLabel(player.getMoney());
				}
				else {
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!");
				}
				break;
			case "Charmander" :
				if(player.getMoney() >= 100) {
				Pokemon Perth = new Charmander();
				this.player.setPokeball(Perth);
				this.player.addPokemon(Perth);
				blackmarket.getBuyLog().addData("Charmander is added!");
				blackmarket.getPokeLog().addData(Perth);
			System.out.println("Charmander is added!");
				player.setMoney(player.getMoney()-100);
				setMoneyLabel(player.getMoney());
				}
				else {
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!");
				}
				break;
			case "Bulbasaur" :
				if(player.getMoney() >= 100) {
				Pokemon Perth = new Bulbasaur();
				this.player.setPokeball(Perth);
				this.player.addPokemon(Perth);
				blackmarket.getBuyLog().addData("Bulbasaur is added!");
				blackmarket.getPokeLog().addData(Perth);
			System.out.println("Bulbasaur is added!");
				player.setMoney(player.getMoney()-100);
				setMoneyLabel(player.getMoney());
				}
				else {
					blackmarket.getBuyLog().addData("Not Enough Money! Comeback next time!");
				}
				break;
			default:
				System.out.println("Wrong Input u edok!!!");
			}
		}
		else {
			System.out.println("Full!");
			blackmarket.getBuyLog().addData("Full!");
		}
		
	}
	private void setPokeButton(BuyButton button) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				run(button.getPokkenName());
			}
		});
	}
}
