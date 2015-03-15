
package loyal.level;

import loyal.InputHandler;
import loyal.LevelInitializer;
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
	int color = Colors.get(-1,222,333,444);

	@Override
	public void update()
	{
		game.level.music.stop();		
		game.level = LevelInitializer.BATTLE;
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
		battleCharacter = new BattleCharacters(game.level, 16, 150, new int[] {color});
		game.level.addEntity(battleCharacter);
		
		pointer = new Pointer(game.level, "pointer", 16, 240, 16, 240, 296, game);
		game.level.addEntity(pointer);
	}
}
