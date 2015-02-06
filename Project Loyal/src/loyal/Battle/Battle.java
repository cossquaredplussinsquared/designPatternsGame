package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;

public class Battle {

	// battle will have two arrays of playing characters.
	// battle will be called and be passed those two arrays of characters. It
	// will flip a coin (random) and decide who goes first. After it decides it
	// will pass the characters to the controlling object (AI, Menu). The
	// controlling object will select a character and tell the Battle who was
	// selected that character will be sent into a queue where it will be
	// removed after a set number of turns. Turns will be decided by the speed
	// stat of the character. The controlling object will iterate through the
	// rest of the characters they have for that turn and decide if they will
	// fight or not.
	
	private ArrayList<PlayingCharacter> activePlayers, activeEnemies;
	private ArrayList<PlayingCharacterCounter> inactivePlayers, inactiveEnemies;
	
	
	public Battle(ArrayList<PlayingCharacter> activePlayers, ArrayList<PlayingCharacter> activeEnemies){
		this.activeEnemies = activeEnemies;
		this.activePlayers = activePlayers;
	}
	
	

}
