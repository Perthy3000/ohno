package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class Pikachu extends Pokemon {

	public Pikachu() {
		super("Pikachu", Element.ElECTRIC, 40, 6, 2, 7);
		skillList.add(new Skill("Electric Shot", Element.ElECTRIC, 2));
		skillList.add(new Skill("Tesla", Element.ElECTRIC, 3));
		skillList.add(new Skill("ThunderBolt", Element.ElECTRIC, 5));
		skillList.add(new Skill("Electric Shock", Element.ElECTRIC, 4));
   	   }

}
