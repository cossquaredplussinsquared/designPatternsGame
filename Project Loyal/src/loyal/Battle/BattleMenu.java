package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Actions.CharacterAction;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.BattleLevel;
import loyal.level.DecisionFactory;

public class BattleMenu implements BattleController {

	private Battle currentBattle;
	private String[] State = new String[] { "Starting", "Waiting", "Player",
			"Waiting", "Attack", "Waiting", "Target" };
	private BattleLevel battleMenu;
	private int i = 0;

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
		int index = -1;
		// index = battleMenu.checkIndex();
		if (!currentBattle.isPlayerTurn()) {
			DecisionFactory.SWITCHBATTLECONTROLLER.update();
			return;
		}
		while (State.length > i) {
			if (State[i].equals("Starting")) {
				battleMenu.setMenu(currentBattle.getActivePlayers());
			}
			if (State[i].equals("Waiting")) {
			}
			if (State[i].equals("Player")) {
				if (index < currentBattle.getActivePlayers().size()) {
					currentBattle.setActivePlayer(index);
					battleMenu.setMenu(currentBattle.getAttacks());
				} else
					i = 0;
			}
			if (State[i].equals("Attack")) {
				if (index < currentBattle.getAttacks().size()) {
					currentBattle.setAction(index);
					battleMenu.setMenu(currentBattle.getActiveEnemies());
				} else
					i = 2;
			}
			if (State[i].equals("Target")) {
				if (index < currentBattle.getActiveEnemies().size())
					currentBattle.setTargetAndTriggerAction(index);
				else
					i = 4;
			}
		}
	}

	// checks to remove any dead sprites
	@Override
	public void updateBattleView(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {
		for (PlayingCharacter e : activePlayers) {
			if (e.isDead()) {

				// remove sprite from screen
			} else {
				// output names/health of those alive
			}
		}

		for (PlayingCharacter e : activeEnemies) {
			if (e.isDead()) {

				// remove sprite from screen
			} else {
				// output names/health of those alive
			}
		}
	}

	@Override
	public void advanceState() {
		i++;
	}
}