package loyal.level;

import loyal.LevelInitializer;
import loyal.Loyal;

public class EndBattleLose implements Decision {

	private Loyal game;
	
	@Override
	public void update() {
		game.level.music.stop();
		game.level = LevelInitializer.END;
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
