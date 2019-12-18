package pokemon;

public class Gyarados extends Pokemon {
	
	public Gyarados() {
		super("Gyarados",Element.WATER, 999, 999, 999, 999);
		addSkill();
	}
	
	public Gyarados(String name) {
		super(name,Element.WATER, 999, 999, 999, 999);
		addSkill();
	}
	
	private void addSkill() {
		skillList.add(new Skill("Dragon Breath", Element.DRAGON, 100));
		skillList.add(new Skill("Water Beam", Element.WATER, 100));
		skillList.add(new Skill("Hyper Beam", Element.NORMAL, 100));
		skillList.add(new Skill("Hydro Pump", Element.WATER, 100));
	}
	
}
