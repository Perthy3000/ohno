package createchar;

import java.util.ArrayList;
import java.util.List;

import button.PokemonButton;
import exception.CreateCharException;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import pokemon.*;

public class ChoosePokemon extends GridPane {
	
	private List<PokemonButton> PokemonButtons;	//contains all PokemonButton
	private PokemonButton selectedButton = null;	//current button that is selected
	private Pokemon selectedPokken;	//current pokemon that is selected
	
	public ChoosePokemon(CreateCharScene ccs) {
		PokemonButtons = new ArrayList<PokemonButton>();
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		Label label = new Label("Pokemon: ");
		label.setStyle("-fx-font-size: 20");
		PokemonButton yo3 = new PokemonButton(new Charmander());
		PokemonButton yo4 = new PokemonButton(new Squirtle());
		PokemonButton yo5 = new PokemonButton(new Bulbasaur());
		PokemonButtons.add(yo3);
		PokemonButtons.add(yo4);
		PokemonButtons.add(yo5);
		addRow(1,label);
		addRow(1, yo3, yo4,yo5);
		//addRow(2,nextButton);
		//addRow(1,label);
		for(PokemonButton all : PokemonButtons) {
			setPokemonButtonAction(all, ccs);
		}
	}
	
	//change selected pokemon depends on currently selected button
	private void chooseStarter() {
		String pokkenname = selectedButton.getPokkenName();
		switch (pokkenname) {
		 	case "Magikarp": selectedPokken = new Magikarp(); break;
		 	case "Pikachu": selectedPokken = new Pikachu(); break;
		 	case "Charmander": selectedPokken = new Charmander(); break;
		 	case "Squirtle": selectedPokken = new Squirtle(); break;
		 	case "Bulbasaur": selectedPokken = new Bulbasaur(); break;
		}
	}

	//set action on PokemonButton to select current pokemon
	private void setPokemonButtonAction(PokemonButton PokemonButton, CreateCharScene ccs) {
		PokemonButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setSelected(PokemonButton, ccs);	//call setSelected function
			}
		});
	}
	
	//set the current selected PokemonButton
	private void setSelected(PokemonButton PokemonButton, CreateCharScene ccs) {
		selectedButton = PokemonButton;
		selectedButton.setSelected();
		for(PokemonButton button : PokemonButtons) {
			if(button != selectedButton) {
				button.setUnselected();
			}
		}
		chooseStarter();	//call to select pokemon
		ccs.updatePokemon(selectedPokken);		
	}
	
	public Pokemon getselectedPokken() throws CreateCharException {
		if(selectedPokken == null) throw new CreateCharException("Choose your pokemon!");
		return selectedPokken;
	}
		
}
