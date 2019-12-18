package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class Bulbasaur extends Pokemon{

	public Bulbasaur() {
		super("Bulbasaur", Element.GRASS, 50, 5, 3, 5);
		skillList.add(new Skill("Grass Shot", Element.GRASS, 2));
		skillList.add(new Skill("Tackle", Element.NORMAL, 3));
		skillList.add(new Skill("Giga Drain", Element.GRASS, 5));
		skillList.add(new Skill("Magical Leaf", Element.GRASS, 4));       
    	   }
}
