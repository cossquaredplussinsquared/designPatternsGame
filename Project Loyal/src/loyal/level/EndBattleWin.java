package loyal.level;

import loyal.LevelInitializer;
import loyal.Loyal;

public class EndBattleWin implements Decision {

	private Loyal game;

	@Override
	public void update() {
		game.level.music.stop();
		game.level = LevelInitializer.OVERWORLD;
		game.level.music.loop();
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

	}

}
