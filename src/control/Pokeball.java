package control;

import java.util.ArrayList;
import java.util.List;

import pokemon.Pokemon;

public class Pokeball {
	private List<Pokemon> Pokemon_List;
	
	public Pokeball() {
		Pokemon_List = new ArrayList<Pokemon>();
	}
	
	public void addPokemon(Pokemon Poken) {
		this.Pokemon_List.add(Poken);
	}
	public List<Pokemon> getPokemonList(){
		return this.Pokemon_List;
	}
	public void showAllPokeball() {
		int index = 1;
		for(Pokemon i : this.Pokemon_List) {
			System.out.println("["+index+"] : "+i.getName());
			index++;
		}
	}
	
}
