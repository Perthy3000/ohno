package createchar;

import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.PieChart;
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
import control.GameManager;
import exception.CreateCharException;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class CreateCharScene extends StackPane {
	
	private ImageView PokeImage;
	private Image buttonImage;
	private CreateChar createChar;
	private PieChart piechart;
	private Button nextButton;
	
	public CreateCharScene(GameManager manager) {
		nextButton = new Button();
		nextButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		nextButton.setStyle("-fx-background-color: transparent;");
		buttonImage = new Image(ClassLoader.getSystemResource("nextButtonaf.png").toString(), 320, 100, false, false);
		nextButton.setGraphic(new ImageView(buttonImage));
		setButtonAction(nextButton);
		setBackground();
		PokeImage = new ImageView(new Image(ClassLoader.getSystemResource("blank.png").toString(), 280, 185.6, false, false));
		createChar = new CreateChar(manager, this);
		piechart = new PieChart();
		piechart.setMaxSize(320, 320);
		setAlignment(createChar, Pos.CENTER);
		setAlignment(PokeImage,Pos.BOTTOM_CENTER);
		setAlignment(piechart,Pos.CENTER);
		setAlignment(nextButton,Pos.BOTTOM_RIGHT);
		getChildren().addAll(createChar, PokeImage, nextButton);		
	}
	
	private void setBackground() {
		Canvas canvas = new Canvas(500,800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image backgroundImage = new Image(ClassLoader.getSystemResource("createcharbg.png").toString(), 500, 800, false, false);
		getChildren().add(canvas);
		gc.drawImage(backgroundImage, 0, 0);
	}
	
	public void updatePokemon(Pokemon pokemon) {
		Pokemon chosenPokemon;
		try {
			chosenPokemon = createChar.getChoosePokemon().getselectedPokken();
		} catch (CreateCharException e) {
			e.showAlertBox();
			return;
		}
		getChildren().remove(piechart);
		switch(chosenPokemon.getName()) {
	 	case "Charmander":
		 	piechart = chosenPokemon.getPieChart(); 
		 	piechart.setMaxSize(320, 320);
		 	PokeImage.setImage(new Image(ClassLoader.getSystemResource("tenor.gif").toString(), 280, 185.6, false, false)); 
		 	break;
	 	case "Squirtle": 
	 		//createChar.setImage(new Image(ClassLoader.getSystemResource("male.png").toString(), 100, 100, false, false));
		 	piechart = chosenPokemon.getPieChart(); 
		 	piechart.setMaxSize(320, 320);
	 		PokeImage.setImage(new Image(ClassLoader.getSystemResource("squirtleg.gif").toString(), 160,152, false, false)); 
	 		break;
	 	case "Bulbasaur":
	 		//createChar.setImage(new Image(ClassLoader.getSystemResource("female.png").toString(), 100, 100, false, false));
		 	piechart = chosenPokemon.getPieChart();
		 	piechart.setMaxSize(320, 320);
	 		PokeImage.setImage(new Image(ClassLoader.getSystemResource("Bulbasaurg.gif").toString(), 160, 175, false, false)); 
	 		break;
		default: 
		}
		getChildren().add(piechart);
	}
	public void updateChar(String gender) {
		
		switch(gender) {
		case "Female" : createChar.setImage(new Image(ClassLoader.getSystemResource("female.png").toString(), 100, 100, false, false)); break;
		case "Male" : createChar.setImage(new Image(ClassLoader.getSystemResource("male.png").toString(), 100, 100, false, false)); break;
		default:
		}
	}
	
	public Button getNextButton() {
		return nextButton;
	}
	
	public void setButtonAction(Button button) {
		 button.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("nextButtonbf.png").toString(), 320, 100, false, false)));
			}
		 });
		 button.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				button.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("nextButtonaf.png").toString(), 320, 100, false, false)));
			}
		});
	
	 }
}

