package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class Squirtle extends Pokemon {
	
	public Squirtle() {
		super("Squirtle", Element.WATER, 40, 5, 6, 5);
		skillList.add(new Skill("Water Shot", Element.WATER, 2));
		skillList.add(new Skill("Tackle", Element.NORMAL, 3));
		skillList.add(new Skill("Aqua Jet", Element.WATER, 5));
		skillList.add(new Skill("Water Burst", Element.WATER, 4));
		
   	   }
	
}
