package loyal.level;

import loyal.InputHandler;
import loyal.Loyal;
import loyal.Graphics.Colors;
import loyal.entities.BattleCharacters;
import loyal.entities.Pointer;

public class EnterBattle implements Decision
{
	private Loyal game;
	private Level levelWatched;
	private InputHandler input;
	Pointer pointer;
	BattleCharacters battleCharacter;
	int color = Colors.get(111,222,333,444);

	@Override
	public void update()
	{
		game.level.music.stop();		
		game.level = Loyal.BATTLE;
		addBattleParticipants();
		
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
		pointer = new Pointer(game.level, "pointer", 64, 16, game.input, 16, 64, 16, game);
		game.level.addEntity(pointer);
		
		battleCharacter = new BattleCharacters(game.level, 150, 16, new int[] {color});
		game.level.addEntity(battleCharacter);
	}
}
