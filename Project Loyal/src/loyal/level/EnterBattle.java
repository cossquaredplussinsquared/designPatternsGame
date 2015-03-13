package loyal.level;

import loyal.InputHandler;
import loyal.Loyal;
import loyal.entities.MapPlayer;

public class EnterBattle implements Decision
{
	private Loyal game;
	private Level levelWatched;
	private InputHandler input;

	@Override
	public void update()
	{
		game.level.music.stop();		
		game.level = Loyal.BATTLE;
		
		game.level.music.loop();
	}
	
	public void setGame(Loyal game)
	{
		this.game = game;
		sync();
	}

	@Override
	public void sync()
	{
		this.input = game.input;
	}
	
	public void addBattleParticipants()
	{
		
	}
}
