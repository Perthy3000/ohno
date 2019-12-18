package createchar;

import control.GameManager;
import exception.CreateCharException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import mainmenu.MainMenuScene;
import pokemon.Pokemon;
import control.Player;

public class CreateChar extends VBox {
	
	private NameInput nameInput;
	private ChoosePokemon ChoosePokemon;
	private ImageView charImage;
	private CreateCharScene ccs;
	
	public CreateChar(GameManager manager, CreateCharScene createCharScene) {
		ccs = createCharScene;
		nameInput = new NameInput(this.ccs);
		ChoosePokemon = new ChoosePokemon(this.ccs);
		charImage = new ImageView(new Image(ClassLoader.getSystemResource("blank.png").toString(), 100, 100, false, false));
		setAlignment(Pos.TOP_CENTER);
		getChildren().addAll(charImage,nameInput,ChoosePokemon);
		setNextButton(manager);
	}

	public ChoosePokemon getChoosePokemon() {
		return this.ChoosePokemon;
	}
	
	public NameInput getNameInput() {
		return this.nameInput;
	}
	
	public void setImage(Image image) {
		charImage.setImage(image);
	}
	
	private void setNextButton(GameManager manager) {
		ccs.getNextButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String name, gender;
				try {
					name = nameInput.getText();
				} catch (CreateCharException e) {
					e.showAlertBox();
					return;
				}
				try {
					gender = getNameInput().getSelectedGender();
				} catch (CreateCharException e) {
					e.showAlertBox();
					return;
				}
				manager.createPlayer(name, gender);
				Player player = manager.getPlayer();	//call player from gameManager
				Pokemon pokemon;
				try {
					pokemon = ChoosePokemon.getselectedPokken();
				} catch (CreateCharException e) {
					e.showAlertBox();
					return;
				}
				player.addPokemon(pokemon);
				MainMenuScene nextBox = new MainMenuScene(manager);
				nextBox.setAlignment(Pos.CENTER);
				Scene nextScene = new Scene(nextBox, 500, 800);	//create next scene
				manager.getStage().setScene(nextScene);
			}
		});
	}
}
