package loyal.Battle;

import java.util.ArrayList;

import loyal.Loyal;
import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.Level;

public class Battle {
	private static Battle currentBattle;
	private int playerWin = 1, playerEscape = 2, computerWin = 3;
	private boolean playersTurn = false;
	
	private BattleController playerMenu = new BattleMenu();
	private BattleController AI = new BattleAI();

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
	
	
	private Battle(ArrayList<PlayingCharacter> activePlayers, ArrayList<PlayingCharacter> activeEnemies){
		this.activeEnemies = activeEnemies;
		this.activePlayers = activePlayers;
	}
		
	public int startBattle(){
		BattleController currentController = null;
		int winner = checkWinner();
		playersTurn = startingTurnDecision();
		setMenu(activePlayers, activeEnemies);
		while(winner == 0){
			if(playersTurn){
				currentController = playerMenu;
				currentController.setActivePlayers(activePlayers, activeEnemies);
				playersTurn = false;
			}
			else {
				currentController = AI;
				currentController.setActivePlayers(activeEnemies, activePlayers);
				playersTurn = true;
			}
			winner = checkWinner();
		}
		return winner;
	}

	private boolean startingTurnDecision() {
		return Math.random() > .005 ;
	}

	protected int checkWinner() {
		int winner = 0;
		winner = isAlive(activePlayers);
		if(winner == 1){
			return computerWin;
		}
		winner = isAlive(activeEnemies);
		if(winner == 1){
			return playerWin;
		}
		return 0;
	}

	private int isAlive(ArrayList<PlayingCharacter> characterGroup) {
		for(PlayingCharacter p: characterGroup){
			if(!(p.getState().getStat(Stat.HEALTH)<=0))
				return 0;
		}
		return 1;
		
	}
	
	//can you create/print out a list of the names/health for both

	public void setMenu(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {
		
		ArrayList<String> players = new ArrayList<String>();
		ArrayList<String> enemies = new ArrayList<String>();
		
		for (PlayingCharacter c: activePlayers)
			players.add(c.getName());
		for (PlayingCharacter e: activeEnemies)
			enemies.add(e.getName());
		
		//create a menu entity to print them out
	}
}
