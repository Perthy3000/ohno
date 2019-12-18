package battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import button.SkillButton;
import control.GameManager;
import control.Player;
import exception.NoPokemonException;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainmenu.MainMenuScene;
import pokemon.*;

public class Battle {
	
	private Player player;
	private Pokemon currentPokemon;
	private Pokemon enemyPokemon;
	private Stage primaryStage;
	private BattleScene battleScene;
	private BattleGraphics graphics;
	private List<SkillButton> SkillButtonList;
	private Random randomizer = new Random();
	private int turn = 0;
	private GameManager manager;

	public Battle(GameManager manager) throws NoPokemonException {
		this.manager = manager;
		player = manager.getPlayer();
		primaryStage = manager.getStage();
		battleScene = new BattleScene(player, primaryStage);
		player = manager.getPlayer();
		for(Pokemon x : player.getpokenList()) {
			if(x.getStatus() != Status.FAINTED) {
				currentPokemon = x;
				break;
			}
		}
		if(currentPokemon == null) throw new NoPokemonException("No pokemon!");
		List<Skill> SkillList = currentPokemon.getSkillList();
		SkillButtonList = new ArrayList<SkillButton>();
		for(int i = 0; i < 4; i++) {
			SkillButton button = new SkillButton(i, SkillList.get(i).getSkillName());
			setSkillButton(button);
			SkillButtonList.add(button);
		}
		randomEnemy();
		primaryStage = manager.getStage();
		setSkillBar();
		battleScene.getLog().addData("Wild " + enemyPokemon.getName() + " appear!");
		battleScene.getLog().addData(player.getName() + " sent out " + currentPokemon.getName() + "!");
		primaryStage.setScene(new Scene(battleScene, 500, 600));
		graphics = battleScene.getBattleGraphic();
		graphics.drawPartner(currentPokemon);
		graphics.drawEnemyPokemon(enemyPokemon);
	}
	
	private void randomEnemy() {
		int randomEnemy = randomizer.nextInt(5);
		switch (randomEnemy) {
			case 0: enemyPokemon = new Magikarp(); break;
			case 1: enemyPokemon = new Charmander(); break;
			case 2: enemyPokemon = new Bulbasaur(); break;
			case 3: enemyPokemon = new Squirtle(); break;
			case 4: enemyPokemon = new Pikachu(); break;
			default: enemyPokemon = new Magikarp();
		}
	}
	
	public void setSkillBar() {
		battleScene.setSkillBar(new SkillBar(SkillButtonList));
	}
	
	private void setSkillButton(SkillButton button) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				attack(button.getSkillNum());
			}
		});
	}
	
	private void doAttack(Pokemon pokemon, Pokemon pokemon2, int SkillNum, int SkillNum2) {
		//String
		battleScene.getLog().getListView().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if(pokemon2.getStatus() != Status.FAINTED && turn == 1) {
					battleScene.getLog().addData(pokemon2.getName() + " use " + pokemon2.getSkill(SkillNum2).getSkillName()
							+ " for " + pokemon2.doDamage(pokemon, pokemon2.getSkill(SkillNum2)) + " damage");
					if(pokemon2.equals(currentPokemon)) {
						new HitAnimation(battleScene.getBattleGraphic().getGraphicsContext(), 220, 20).start();
					} else {
						new HitAnimation(battleScene.getBattleGraphic().getGraphicsContext(), 50, 100).start();
					}
					turn++;
				}
				else if(turn == 0) {
					battleScene.getLog().addData("-" + pokemon.getName() + " use " + pokemon.getSkill(SkillNum).getSkillName()
							+ " for " + pokemon.doDamage(pokemon2, pokemon.getSkill(SkillNum)) + " damage");
					if(pokemon.equals(currentPokemon)) {
						new HitAnimation(battleScene.getBattleGraphic().getGraphicsContext(), 220, 20).start();
					} else {
						new HitAnimation(battleScene.getBattleGraphic().getGraphicsContext(), 50, 100).start();
					}
					turn++;					
					checkFaint();
				}
				if(turn == 2) {
					battleScene.getLog().getListView().setOnMouseClicked(null);
					battleScene.enableSkillBar();
					turn = 0;
					checkFaint();
				}
			}
		});
	}
	
	public void checkFaint() {
		if(currentPokemon.getStatus() == Status.FAINTED) {
			battleScene.getLog().getListView().setOnMouseClicked(null);
			turn = 0;
			battleScene.getLog().addData(currentPokemon.getName() + " is fainted!");
			if(player.getAvailablePokken() == 0) {
				exit();				
			} else {
				for(Pokemon x : player.getpokenList()) {
					if(x.getStatus() != Status.FAINTED) {
						currentPokemon = x;
						SkillButtonList.clear();
						for(int i = 0; i < 4; i++) {
							SkillButton button = new SkillButton(i, currentPokemon.getSkillList().get(i).getSkillName());
							setSkillButton(button);
							SkillButtonList.add(button);
						}
						setSkillBar();
						battleScene.getLog().addData(player.getName() + " sent out " + currentPokemon.getName() + "!");
						graphics.drawPartner(currentPokemon);
						graphics.drawEnemyPokemon(enemyPokemon);
						break;
					}
				}
			}
		} else if(enemyPokemon.getStatus() == Status.FAINTED) {
			exit();
		}
	}
	
	public void attack(int SkillNum) {
		battleScene.disableSkillBar();
		if(currentPokemon.getSpeed() >= enemyPokemon.getSpeed()) {
			doAttack(currentPokemon, enemyPokemon, SkillNum, randomizer.nextInt(3));
		} else {
			doAttack(enemyPokemon, currentPokemon, randomizer.nextInt(3), SkillNum);
		}
	}
	
	private void exit() {
		battleScene.getLog().getListView().setOnMouseClicked(null);
		battleScene.disableSkillBar();
		if(player.getAvailablePokken() == 0) {
			battleScene.getBattleGraphic().clearPartner();
			battleScene.getLog().addData(player.getName() + " has no pokemon left!");
		} else {
			battleScene.getBattleGraphic().clearEnemyPokemon();
			battleScene.getLog().addData(enemyPokemon.getName() + " is fainted!");
			player.setMoney(player.getMoney()+200);
			battleScene.getLog().addData(player.getName() +" get 200$!");
		}
		for(Pokemon x : player.getpokenList()) {
			x.fullHeal();
		}
		Button exitButton = new Button();
		exitButton.setText("Exit");
		exitButton.setStyle("-fx-font-size: 15");
		exitButton.setPrefSize(70, 50);
		battleScene.getChildren().add(exitButton);
		exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				primaryStage.setScene(new Scene(new MainMenuScene(manager), 500, 800));
				primaryStage.setTitle("Main Menu");
			}
		});
	}
}
