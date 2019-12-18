package control;

import java.util.ArrayList;
import java.util.List;

import pokemon.Status;
import pokemon.Pokemon;

public class Player{
	
	private String name;
	private List<Pokemon> playerpokken;
	private final int maxpokken = 6;
	private int money;
	private Pokeball pokeball;
	private String gender;
	
	public Player(String name, String gender) {
		this.name = name;
		playerpokken = new ArrayList<Pokemon>();
		money = 5000;
		pokeball = new Pokeball();
		this.gender = gender;
	}
	
	public void setPokeball(Pokemon pokemon) {
		pokeball.addPokemon(pokemon);
	}
	
	public void addPokemon(Pokemon pokemon) {
		if(playerpokken.size() < maxpokken) {
			playerpokken.add(pokemon);
			System.out.println(pokemon.getName() + " is added!");
		} else {
			System.out.println("full!");
		}
	}
	
	public int getAvailablePokken() {
		int availablePokemon = 0;
		for(Pokemon pokken : playerpokken) {
			if(pokken.getStatus() != Status.FAINTED) {
				availablePokemon++;
			}
		}
		return availablePokemon;
	}
	
	public List<Pokemon> getpokenList() {
		return playerpokken;
	}
	public int removepokenList(int index) {
		playerpokken.remove(index);
		return getpokenList().size();
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		if(money < 0) {
			money = 0;
		}
		this.money = money;
	}

	public String getName() {
		return name;
	}
	
	public Pokeball getPokeBall() {
		return pokeball;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
}
