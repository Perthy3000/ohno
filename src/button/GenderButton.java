package button;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GenderButton extends Button {
	private boolean isSelected = false;
	private String gender;
	public GenderButton(String gender) {
		this.gender = gender;
		this.setPadding(new Insets(10));
		setBorder(new Border(new BorderStroke(Color.BEIGE,BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	 setStyle("");
	 switch(gender) {
		case "Female" : setText("Female");  break;
		case "Male" : setText("Male");  break;
	}
	 setButtonAction();
	}

	private void setButtonAction() {
		String style, defaultstyle = "";
		switch(gender) {
		case "Female" :style = "-fx-background-color : #FF99FF";  break;
		case "Male" : style = "-fx-background-color : #66CCFF";  break;
		default: style = defaultstyle;
	}
		 
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
		 setButtonAction();
	 }
	 
	 public void setUnselected() {
		 isSelected = false;
		 setStyle("");
	 }
	 public String getGender() {
		 return this.gender;
	 }
}
