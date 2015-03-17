package loyal.level;

import loyal.LevelInitializer;
import loyal.Loyal;
import loyal.entities.MapPlayer;

public class ExitBattleLoss implements Decision
{

	private Loyal game;

	@Override
	public void update()
	{
		game.level.music.stop();
		
		game.level = LevelInitializer.END;
		MapPlayer player = new MapPlayer(game.level, 252, 220, game.input, game);
		game.level.addEntity(0, player);
		game.level.music.play();

	}

	@Override
	public void sync() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setGame(Loyal game)
	{
		this.game = game;

	}

	@Override
	public void gameValue(int value) {
		// TODO Auto-generated method stub

	}

}
