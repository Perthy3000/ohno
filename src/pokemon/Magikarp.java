package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class Magikarp extends Pokemon {

	public Magikarp() {
		super("Magikarp", Element.WATER, 200, 1, 1, 50);
		skillList.add(new Skill("Struggle", Element.NORMAL, 0));
		skillList.add(new Skill("Struggle", Element.NORMAL, 0));
		skillList.add(new Skill("Struggle", Element.NORMAL, 0));
		skillList.add(new Skill("Tackle", Element.NORMAL, 1));
		
   	   }

}
