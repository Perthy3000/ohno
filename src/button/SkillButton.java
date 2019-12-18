package button;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class SkillButton extends Button {
	
	private int skillnum;
	
	public SkillButton(int skillnum, String skillname) {
		setPadding(new Insets(5));
		setPrefHeight(40);
		setPrefWidth(100);
		this.skillnum = skillnum;
		setText(skillname);
	}
	
	public int getSkillNum() {
		return skillnum;
	}
	
	public void setSkillName(String skillName) {
		setText(skillName);
	}
}
