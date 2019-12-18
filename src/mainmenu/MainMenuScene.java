package mainmenu;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import control.GameManager;
import control.Player;

public class MainMenuScene extends StackPane {
	
	private Image backgroundImage;
	private Canvas canvas;
	private GraphicsContext gc;
	private Stage primaryStage;
	private MainMenu mainMenu;
	
	public MainMenuScene(GameManager manager) {
		primaryStage = manager.getStage();
		GridPane grid = new GridPane();
		canvas = new Canvas(500,800);
		gc = canvas.getGraphicsContext2D();
		backgroundImage = new Image(ClassLoader.getSystemResource("menubg.png").toString(), 500, 800, false, false);
		gc.drawImage(backgroundImage, 0, 0);
		getChildren().add(canvas);
		mainMenu = new MainMenu(manager);
		CharStatus charStatus = new CharStatus(manager.getPlayer());
		setAlignment(mainMenu, Pos.CENTER);
		//setAlignment(charStatus, Pos.TOP_LEFT);
		ImageView charImage = charStatus.getImage();
		grid.setVgap(5);
		grid.setHgap(5);
		grid.addRow(0,charImage,charStatus.getNameLabel());
		grid.add(charStatus.getMoneyLabel(),0,2);
		grid.add(charStatus.getCurrentPokeLabel(),1,2);
		setAlignment(grid, Pos.TOP_LEFT);
		getChildren().add(grid);
		getChildren().addAll(charStatus,mainMenu);
		
	}
	
}
