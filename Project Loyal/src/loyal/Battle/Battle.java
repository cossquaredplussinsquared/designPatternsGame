	package loyal.Battle;

import java.util.ArrayList;

import loyal.Loyal;
import loyal.Battle.Actions.AbilityType;
import loyal.Battle.Actions.CharacterAction;
import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.Level;

public class Battle {
	private static Battle currentBattle;
	private int playerWin = 1, playerEscape = 2, computerWin = 3;
	private boolean playersTurn = false;
	
	private BattleController playerMenu = new BattleMenu();
	private BattleController AI = new BattleAI();

	
	private ArrayList<PlayingCharacter> activePlayers, activeEnemies;
	private ArrayList<PlayingCharacterCounter> inactivePlayers, inactiveEnemies;
	private PlayingCharacter attacker;
	private CharacterAction action;
	
	
	private Battle(ArrayList<PlayingCharacter> activePlayers, ArrayList<PlayingCharacter> activeEnemies){
		this.activeEnemies = activeEnemies;
		this.activePlayers = activePlayers;
	}
		
	public int startBattle(){
		BattleController currentController = null;
		int winner = checkWinner();
		playersTurn = startingTurnDecision();
//		setMenu(activePlayers, activeEnemies);
//		while(winner == 0){
//			if(playersTurn){
//				currentController = playerMenu;
//				checkAliveParty();
////				currentController.setActivePlayers(activePlayers, activeEnemies);
//				playerMenu.tick();
//				playersTurn = false;
//			}
//			else {
//				currentController = AI;
//				checkAliveParty();
////				currentController.setActivePlayers(activeEnemies, activePlayers);
//				AI.tick();
//				playersTurn = true;
//			}
//			winner = checkWinner();
//		}
		return winner;
	}
	
	public void setActivePlayer(int index){
		if(playersTurn)
			this.attacker = activePlayers.get(index);
		else
			this.attacker = activeEnemies.get(index);
	}
	

	public ArrayList<String> getTargets(){
		if(playersTurn){
			return getPlayerNames(activeEnemies);
		}
		return getPlayerNames(activePlayers);
	}
	
	private ArrayList<String> getPlayerNames(ArrayList<PlayingCharacter> passedIn)
	{
		ArrayList<String> temp = new ArrayList<String>();
		for (PlayingCharacter p:passedIn)
			temp.add(p.getName());
		return temp;
	}
	
	private ArrayList<String> getActionNames(ArrayList<CharacterAction> passedIn)
	{
		ArrayList<String> temp = new ArrayList<String>();
		for (CharacterAction p:passedIn)
			temp.add(p.getName());
		return temp;
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

//	public void setMenu(ArrayList<PlayingCharacter> activePlayers,
//			ArrayList<PlayingCharacter> activeEnemies) {
//		
//		ArrayList<String> players = new ArrayList<String>();
//		ArrayList<String> enemies = new ArrayList<String>();
//		
//		for (PlayingCharacter c: activePlayers)
//			players.add(c.getName());
//			//health
//		for (PlayingCharacter e: activeEnemies)
//			enemies.add(e.getName());
//			//health
//		
//		//create a menu entity to print them out
//	}
	
	private void checkAliveParty()
	{
		for (PlayingCharacter p: activePlayers)
			if (p.isDead())
				activePlayers.remove(p);
		
		for (PlayingCharacter e: activeEnemies)
			if (e.isDead())
				activeEnemies.remove(e);
	}

	
	protected ArrayList<String> getAttacks()
	{
		return getActionNames(attacker.getActions());
	}
	
	private void setAction(int index){
		this.action = attacker.getActions().get(index);
	}
	public ArrayList<PlayingCharacter> getActivePlayers() {
		// TODO Auto-generated method stub
		return activePlayers;
	}

	public ArrayList<PlayingCharacter> getActiveEnemies() {
		// TODO Auto-generated method stub
		return activeEnemies;
	}

	public boolean isPlayerTurn() {
		// TODO Auto-generated method stub
		return playersTurn;
	}
}
