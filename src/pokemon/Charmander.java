package pokemon;

import javafx.application.Application; 
import javafx.collections.FXCollections;  
import javafx.collections.ObservableList;

public class Charmander extends Pokemon {
	
	public Charmander() {
		super("Charmander", Element.FIRE, 40, 6, 2, 5);
		skillList.add(new Skill("Flame Shot", Element.FIRE, 2));
		skillList.add(new Skill("Tackle", Element.NORMAL, 3));
		skillList.add(new Skill("Fireball", Element.FIRE, 5));
		skillList.add(new Skill("Flame Burst", Element.FIRE, 4));    
	}
	
}
