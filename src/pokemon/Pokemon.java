package pokemon;

import java.util.ArrayList;
import java.util.List;

import battle.BattleScene;
//import gui.HitAnimation;
//import gui.LevelUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public abstract class Pokemon {
	
	private String name;
	private Element element;
	private int attack ,defense, maxHp, speed, exp, level, maxExp;
	private int currentHp;
	private Status status;
	protected List<Skill> skillList;
	private PieChart pieChart;
	
	public Pokemon(String name, Element element, int maxHp, int attack, int defense, int speed) {
		this.name = name;
		this.element = element;
		this.maxHp = maxHp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		exp = 0;
		level = 1;
		maxExp = 10;
		currentHp = maxHp;
		status = Status.READY;
		skillList = new ArrayList<Skill>();
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
   	         new PieChart.Data("HP", this.maxHp), 
   	         new PieChart.Data("Attack", this.attack), 
   	         new PieChart.Data("Defense",this.defense), 
   	         new PieChart.Data("Speed", this.speed)); 
   	       
   	      //Creating a Pie chart 
   	      pieChart = new PieChart(pieChartData); 
   	              
   	      //Setting the title of the Pie chart 
   	      pieChart.setTitle(""); 
   	       
   	      //setting the direction to arrange the data 
   	      pieChart.setClockwise(true); 
   	       
   	      //Setting the length of the label line 
   	      pieChart.setLabelLineLength(50); 

   	      //Setting the labels of the pie chart visible  
   	      pieChart.setLabelsVisible(true); 
   	       
   	      //Setting the start angle of the pie chart  
   	      pieChart.setStartAngle(180);
	}
	
	public PieChart getPieChart() {
		return this.pieChart;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int doDamage(Pokemon sandbag, Skill move) {
		float multiplier = 1;
		if(sandbag.getElement() == move.getEffectiveElement()) {
			multiplier *= 2;
		} else if(sandbag.getElement() == move.getNEffectiveElement()) {
			multiplier /= 2;
		}
		int calDamage = (int) (((getAttack()+move.getPower())*multiplier)-sandbag.getDefense());
		if(calDamage <= 0) calDamage = 1;
		if(calDamage > sandbag.getCurrentHp()) calDamage = sandbag.getCurrentHp();
		sandbag.setCurrentHp(sandbag.getCurrentHp()-calDamage);
		return calDamage;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Element getElement() {
		return element;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getmaxHp() {
		return maxHp;
	}
	
	public void setCurrentHp(int currentHp) {
		if(currentHp <= 0) {
			currentHp = 0;
			status = Status.FAINTED;
		}
		this.currentHp = currentHp;
	}
	
	public int getCurrentHp() {
		return currentHp;
	}

	public void fullHeal() {
		currentHp = maxHp;
		status = Status.READY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setEvasion(int speed) {
		this.speed = speed;
	}
	
	public List<Skill> getSkillList() {
		return skillList;
	}
	
	public Skill getSkill(int num) {
		return skillList.get(num);
	}
	
	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void addExp(int exp) {
		this.exp += exp;
		if(this.exp >= maxExp) {
			level++;
			this.exp -= maxExp;
			maxExp *= 2;
			levelUp();
		}
	}
	
	private void levelUp() {
		maxHp += 3;
		defense += 2;
		attack += 2;
		speed += 1;
		fullHeal();
	}
	
	public int getMaxExp() {
		return maxExp;
	}
}
