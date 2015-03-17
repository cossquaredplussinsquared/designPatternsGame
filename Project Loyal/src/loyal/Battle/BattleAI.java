package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Actions.AbilityType;
import loyal.Battle.Actions.CharacterAction;
import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.entities.BattleCharacters;
import loyal.level.BattleLevel;
import loyal.level.DecisionFactory;
import loyal.level.Level;

public class BattleAI implements BattleController {

	private Battle currentBattle;
	private String[] State = new String[] { "Player", "Attack", "Target" };
	private BattleLevel battleMenu;
	private int i = 0, index = 0, winner;

	@Override
	public void setMenu(BattleLevel menu) {
		this.battleMenu = menu;
	}

	@Override
	public void setBattle(Battle currentBattle) {
		this.currentBattle = currentBattle;
	}

	@Override
	public void tick() {
		if(winner == -1){
			currentBattle.startBattle();
			winner = 0;
		}
		
		updateBattleView();

		// index = battleMenu.checkIndex();
		if (currentBattle.isPlayerTurn()) {
			DecisionFactory.SWITCHBATTLECONTROLLER.update();
			return;
		}

			if (State[i].equals("Waiting")) {
				advanceState();
				}
			if (State[i].equals("Player")) {
				index = (int) (currentBattle.getActivePlayers().size() * Math
						.random());
				currentBattle.setActivePlayer(index);
				i++;
			}
			if (State[i].equals("Attack")) {
				index = (int) (currentBattle.getAttacks().size() * Math
						.random());
				currentBattle.setAction(index);
				i++;
			}
			if (State[i].equals("Target")) {
				index = (int) (currentBattle.getActiveEnemies().size() * Math
						.random());
				currentBattle.setTargetAndTriggerAction(index);
			}

	}

	@Override
	public void updateBattleView() {
		ArrayList<String> playerVal = new ArrayList<String>(), enemyVal = new ArrayList<String>();
		
		for (PlayingCharacter e : currentBattle.getActivePlayers("thing")) {
			playerVal.add(e.getName() + " " + (int)e.getState().getStat(Stat.HEALTH));
		}

		for (PlayingCharacter e : currentBattle.getActiveEnemies("thing")) {
			enemyVal.add(e.getName() + " " + (int)e.getState().getStat(Stat.HEALTH));
		}
		
		battleMenu.setEnemyName(enemyVal);
		battleMenu.setPlayerName(playerVal);
		
		battleMenu.entities.get(4+i).setAttack(true);
	}

	@Override
	public void advanceState() {
		// TODO Auto-generated method stub
	}

	@Override
	public Battle getBattle() {
		// TODO Auto-generated method stub
		return currentBattle;
	}
}
