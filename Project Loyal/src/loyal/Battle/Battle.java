
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

	public Battle(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {
		this.activeEnemies = activeEnemies;
		this.activePlayers = activePlayers;
	}

	public int startBattle() {
		int winner = checkWinner();
		playersTurn = startingTurnDecision();
		if (playersTurn)
			targets = activeEnemies;
		else
			targets = activePlayers;
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
		} else{
		ArrayList<PlayingCharacter> target = new ArrayList<PlayingCharacter>();
		target.add(targets.get(index));
		action.applyAbility(target);
		}
		if (playersTurn)
			targets = activeEnemies;
		else
			targets = activePlayers;
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

	synchronized protected int checkWinner() {
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
	public ArrayList<PlayingCharacter> getActivePlayers(String temp){
		return activePlayers;
	}

	public ArrayList<String> getActiveEnemies() {
		return getPlayerNames(activeEnemies);
	}

	public boolean isPlayerTurn() {
		return playersTurn;
	}

	public ArrayList<PlayingCharacter> getActiveEnemies(String string) {
		// TODO Auto-generated method stub
		return activeEnemies;
	}
}