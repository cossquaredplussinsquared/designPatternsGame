package loyal.level;

import loyal.Loyal;

public class SwitchBattleState implements Decision {

	private Loyal game;

	@Override
	public void update() {
		game.currentBattle.advanceState();

	}

	@Override
	public void sync() {
		// TODO Auto-generated method stub

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
