package battle;

import java.util.List;

import button.SkillButton;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class SkillBar extends HBox {
	
	private List<SkillButton> skillButtonList;
	
	public SkillBar(List<SkillButton> skillButtonList) {
		this.skillButtonList = skillButtonList;
		setSpacing(10);
		setAlignment(Pos.BOTTOM_CENTER);
		for(SkillButton Skill : skillButtonList) {
			getChildren().add(Skill);
		}
		setBorder();
	}
	
	private void setBorder() {
		String url = ClassLoader.getSystemResource("border5.png").toString();
		setStyle("-fx-padding: 15;" + 
                "-fx-background-width: 3;" +
                "-fx-background-insets: 5;" + 
                "-fx-background-image: url(" + url + ");" +
                "-fx-background-size: 460 72;" +
                "-fx-background-position: top center;" +
                "-fx-background-repeat: no-repeat;");
	}

	public List<SkillButton> getSkillButtons() {
		return skillButtonList;
	}
}
