package mainmenu;

import control.Player;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CharStatus extends GridPane {
	
	private Player player;
	private ImageView image;
	private Label currentPokeLabel;
	private Label moneyLabel ;
	private Label nameLabel;
	
	public CharStatus(Player player) {
		System.out.println("ddddd");
		currentPokeLabel = new Label("Available pokemon : " + player.getAvailablePokken());
		moneyLabel = new Label("Money : " + player.getMoney());
		nameLabel = new Label(player.getName());
		moneyLabel.setStyle("-fx-text-fill: black;-fx-background-color: #FFEC8B;-fx-font-size: 20;-fx-font-family:'Georgia';-fx-border-color: white;-fx-padding: 5 5 5 5;");
		currentPokeLabel.setStyle("-fx-text-fill: #FFEC8B;-fx-background-color: #1874CD;-fx-font-size: 20;"
				+ "-fx-font-family:'Georgia';-fx-border-color: white;-fx-padding: 5 5 5 5;");
		nameLabel.setStyle("-fx-text-fill: red;-fx-background-color: transparent; -fx-font-size: 60;"
				+ "-fx-font-family:'Georgia';-fx-font-style: oblique; -fx-font-weight: bold ;"
				+ "-fx-padding: 1 1 2 2;");
		image = new ImageView(new Image(ClassLoader.getSystemResource("blank.png").toString(), 100, 100, false, false));
		switch(player.getGender()) {
			case "Female" : image.setImage(new Image(ClassLoader.getSystemResource("female.png").toString(), 100, 100, false, false)); break;
			case "Male" : image.setImage(new Image(ClassLoader.getSystemResource("male.png").toString(), 100, 100, false, false)); break;
			default:
		}
	}
	
	public ImageView getImage() {
		return this.image;
	}
	public Label getCurrentPokeLabel() {
		return this.currentPokeLabel;
	}
	public Label getMoneyLabel() {
		return this.moneyLabel;
	}
	public Label getNameLabel() {
		return this.nameLabel;
	}
}
