package loyal.level;

import loyal.Loyal;
import loyal.Battle.BattleAI;
import loyal.Battle.BattleController;

public class SwitchBattleController implements Decision {

	private Loyal game;
	private BattleController otherController = new BattleAI();

	@Override
	public void update() {
		BattleController temp = game.currentBattle;
		game.currentBattle = this.otherController ;
		otherController = temp;
	}

	@Override
	public void sync() {

	}

	@Override
	public void setGame(Loyal game) {
		this.game = game; 

	}

	@Override
	public void gameValue(int value) {
		// TODO Auto-generated method stub
		
	}

}
