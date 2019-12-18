package pokemon;

import pokemon.Element;

public class Skill {
	private String skillName;
	private Element element, effectiveElement, nEffectiveElement;
	private int power;
	
	public Skill(String skillName, Element element, int power) {
		this.skillName = skillName;
		this.element = element;
		this.power = power;
		switch (element) {
		case FIRE:
			effectiveElement = Element.GRASS;
			nEffectiveElement = Element.WATER;
			break;
		case WATER:
			effectiveElement = Element.FIRE;
			nEffectiveElement = Element.GRASS;
			break;
		case GRASS:
			effectiveElement = Element.WATER;
			nEffectiveElement = Element.FIRE;
			break;
		default:
			break;
		}
	}

	public String getSkillName() {
		return skillName;
	}

	public Element getElement() {
		return element;
	}

	public int getPower() {
		return power;
	}
	
	public Element getEffectiveElement() {
		return effectiveElement;
	}
	
	public Element getNEffectiveElement() {
		return nEffectiveElement;
	}
}
