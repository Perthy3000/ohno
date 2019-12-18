package createchar;

import java.util.ArrayList;
import java.util.List;

import button.GenderButton;
import exception.CreateCharException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class NameInput extends GridPane {
	
	private List<GenderButton> genderButtons;
	private TextField nameField;
	private Button enterButton;
	private GenderButton maleButton;
	private GenderButton femaleButton;
	private GenderButton selectedButton;
	
	public NameInput(CreateCharScene ccs) {
		genderButtons = new ArrayList<GenderButton>();
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		nameField = new TextField();
		Label nameLabel = new Label("Name :");
		nameLabel.setStyle("-fx-font-size: 20");
		Label genderLabel = new Label("Gender :");
		genderLabel.setStyle("-fx-font-size: 20");
		enterButton = new Button("Enter");
		enterButton.setPrefSize(70, 40);
		maleButton = new GenderButton("Male");
		femaleButton = new GenderButton("Female");
		selectedButton = null;
		genderButtons.add(maleButton);
		genderButtons.add(femaleButton);
		addRow(2,nameLabel, nameField);
		addRow(2,genderLabel, maleButton,femaleButton);
		for(GenderButton all : genderButtons) {
			setButtonAction(all, ccs);
		}
	}

	private void chooseGender(CreateCharScene ccs) {
		String gender = selectedButton.getGender();
		ccs.updateChar(gender);
	}
	
	private void setButtonAction(GenderButton button, CreateCharScene ccs) {
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setSelected(button, ccs);
			}
		});
	}
	
	private void setSelected(GenderButton button, CreateCharScene ccs) {
		selectedButton = button;
		selectedButton.setSelected();
		for(GenderButton buttonn : genderButtons) {
			if(buttonn != selectedButton) {
				buttonn.setUnselected();
			}
		}
		chooseGender(ccs);
	}
	
	public String getSelectedGender() throws CreateCharException {
		if(selectedButton == null) throw new CreateCharException("Choose your gender");
		return selectedButton.getGender();
	}
	
	public String getText() throws CreateCharException {
		if(nameField.getText().trim().isBlank()) throw new CreateCharException("Enter your name!");
		if(nameField.getText().trim().length() > 9) throw new CreateCharException("Name must be between 1-9 charaters");
		return nameField.getText().trim();
	}
	 
}
