package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Actions.AbilityType;
import loyal.Battle.Actions.CharacterAction;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.BattleLevel;
import loyal.level.DecisionFactory;
import loyal.level.Level;

public class BattleAI implements BattleController {

	private Battle currentBattle;
	private String[] State = new String[] { "Player", "Waiting", "Attack",
			"Waiting", "Target" };
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
			if (State[i].equals("Waiting")) {
			}
			if (State[i].equals("Player")) {
				index = (int) (currentBattle.getActivePlayers().size() * Math
						.random());
				currentBattle.setActivePlayer(index);
			}
			if (State[i].equals("Attack")) {
				index = (int) (currentBattle.getAttacks().size() * Math
						.random());
				currentBattle.setAction(index);
			}
			if (State[i].equals("Target")) {
				index = (int) (currentBattle.getActiveEnemies().size() * Math
						.random());
				currentBattle.setTargetAndTriggerAction(index);
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
		// TODO Auto-generated method stub
	}
}
