package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.BattleLevel;
import loyal.level.DecisionFactory;

public class BattleMenu implements BattleController {

	private Battle currentBattle;
	private String[] State = new String[] { "Starting", "Waiting", "Player",
			"Waiting", "Attack", "Waiting", "Target" };
	private BattleLevel battleMenu;
	private int i = 0, index = 0;

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
		int winner = currentBattle.startBattle();

		updateBattleView();

		// index = battleMenu.checkIndex();
		if (!currentBattle.isPlayerTurn()) {
			DecisionFactory.SWITCHBATTLECONTROLLER.update();
			return;
		}

		if (State[i].equals("Starting")) {
			battleMenu.setMenu(currentBattle.getActivePlayers());
			i++;
		}
		if (State[i].equals("Waiting")) {
			advanceState();
		}
		if (State[i].equals("Player")) {
			if (index < currentBattle.getActivePlayers().size()) {
				currentBattle.setActivePlayer(index);
				battleMenu.setMenu(currentBattle.getAttacks());
				index = 0;
				i++;
			} else
				i = 0;
		}
		if (State[i].equals("Attack")) {
			if (index < currentBattle.getAttacks().size()) {
				currentBattle.setAction(index);
				battleMenu.setMenu(currentBattle.getActiveEnemies());
				index = 0;
				i++;
			} else
				i = 2;
		}
		if (State[i].equals("Target")) {
			if (index < currentBattle.getActiveEnemies().size()) {
				currentBattle.setTargetAndTriggerAction(index);
				index = 0;
			} else
				i = 4;
		}
		if (winner == 1) {

		}
	}

	@Override
	public void updateBattleView() {
		ArrayList<String> playerVal = new ArrayList<String>(), enemyVal = new ArrayList<String>();

		for (PlayingCharacter e : currentBattle.getActivePlayers("thing")) {
			playerVal.add(e.getName() + " "
					+ (int) e.getState().getStat(Stat.HEALTH));
		}

		for (PlayingCharacter e : currentBattle.getActiveEnemies("thing")) {
			enemyVal.add(e.getName() + " "
					+ (int) e.getState().getStat(Stat.HEALTH));
		}

		battleMenu.setEnemyName(enemyVal);
		battleMenu.setPlayerName(playerVal);
	}

	@Override
	public void advanceState() {
		index = battleMenu.getIndex();
		long lastTime = System.nanoTime(), currentTime = System.nanoTime(), delay = 500;
		if ((currentTime - delay) > lastTime || index != 0) {
			i++;
		}
	}

	@Override
	public Battle getBattle() {
		return currentBattle;
	}
}