package exception;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NoPokemonException extends Exception implements Alertable {

	private static final long serialVersionUID = 1L;

	private String string;
	
	public NoPokemonException(String string) {
		this.string = string;
	}
	
	@Override
	public void showAlertBox() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(string);
		alert.show();
	}

}
