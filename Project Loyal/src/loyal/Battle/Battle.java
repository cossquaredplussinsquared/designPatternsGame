package loyal.Battle;

import java.lang.reflect.Array;
import java.util.ArrayList;

import loyal.Battle.Actions.AbilityType;
import loyal.Battle.Actions.CharacterAction;
import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.PlayingCharacter;

public class Battle {
	private int playerWin = 1, playerEscape = 2, computerWin = 3;
	private boolean playersTurn = false;

	private ArrayList<PlayingCharacter> activePlayers, activeEnemies;
	private ArrayList<PlayingCharacterCounter> inactivePlayers,
			inactiveEnemies;
	private PlayingCharacter attacker;
	private CharacterAction action;
	private ArrayList<PlayingCharacter> targets;

	private Battle(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {
		this.activeEnemies = activeEnemies;
		this.activePlayers = activePlayers;
	}

	public int startBattle() {
		int winner = checkWinner();
		playersTurn = startingTurnDecision();
		return winner;
	}

	public void setActivePlayer(int index) {
		this.attacker = activePlayers.get(index);
	}

	public ArrayList<String> getTargets() {
		if(action.getTargetType() == AbilityType.MULTI){
			ArrayList<String> multi = new ArrayList<String>();
			multi.add("ALL OF 'EM");
			return multi;
		}
		return getPlayerNames(activeEnemies);
	}

	public void setTargetAndTriggerAction(int index) {
		playersTurn = !playersTurn;
		if (action.getTargetType() == AbilityType.MULTI) {
			action.applyAbility(targets);
			return;
		}
		ArrayList<PlayingCharacter> target = new ArrayList<PlayingCharacter>();
		target.add(targets.get(index));
		action.applyAbility(target);
		
	}

	private ArrayList<String> getPlayerNames(
			ArrayList<PlayingCharacter> passedIn) {
		ArrayList<String> temp = new ArrayList<String>();
		for (PlayingCharacter p : passedIn)
			temp.add(p.getName());
		return temp;
	}

	private ArrayList<String> getActionNames(ArrayList<CharacterAction> passedIn) {
		ArrayList<String> temp = new ArrayList<String>();
		for (CharacterAction p : passedIn)
			temp.add(p.getName());
		return temp;
	}

	private boolean startingTurnDecision() {
		return Math.random() > .005;
	}

	protected int checkWinner() {
		int winner = 0;
		winner = isAlive(activePlayers);
		if (winner == 1) {
			return computerWin;
		}
		winner = isAlive(activeEnemies);
		if (winner == 1) {
			return playerWin;
		}
		return 0;
	}

	private int isAlive(ArrayList<PlayingCharacter> characterGroup) {
		for (PlayingCharacter p : characterGroup) {
			if (!(p.getState().getStat(Stat.HEALTH) <= 0))
				return 0;
		}
		return 1;
	}

	// can you create/print out a list of the names/health for both

	// public void setMenu(ArrayList<PlayingCharacter> activePlayers,
	// ArrayList<PlayingCharacter> activeEnemies) {
	//
	// ArrayList<String> players = new ArrayList<String>();
	// ArrayList<String> enemies = new ArrayList<String>();
	//
	// for (PlayingCharacter c: activePlayers)
	// players.add(c.getName());
	// //health
	// for (PlayingCharacter e: activeEnemies)
	// enemies.add(e.getName());
	// //health
	//
	// //create a menu entity to print them out
	// }

	private void checkAliveParty() {
		for (PlayingCharacter p : activePlayers)
			if (p.isDead())
				activePlayers.remove(p);

		for (PlayingCharacter e : activeEnemies)
			if (e.isDead())
				activeEnemies.remove(e);
	}

	protected ArrayList<String> getAttacks() {
		return getActionNames(attacker.getActions());
	}

	protected void setAction(int index) {
		this.action = attacker.getActions().get(index);
		if (action.getAbilityType() == AbilityType.DEFENSIVE)
			swapTargets();
	}

	private void swapTargets() {
		if (targets == activeEnemies)
			targets = activePlayers;
		else
			targets = activeEnemies;
	}

	public ArrayList<String> getActivePlayers() {
		return getPlayerNames(activePlayers);
	}

	public ArrayList<String> getActiveEnemies() {
		return getPlayerNames(activeEnemies);
	}

	public boolean isPlayerTurn() {
		return playersTurn;
	}
}
