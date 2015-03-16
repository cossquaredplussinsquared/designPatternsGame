package loyal.level;

import loyal.LevelInitializer;
import loyal.Loyal;
import loyal.Battle.BattleMenu;
import loyal.Graphics.Colors;
import loyal.entities.BattleCharacters;
import loyal.entities.Pointer;

public class EnterBattle implements Decision
{
	private Loyal game;
	Pointer pointer;
	BattleCharacters battleCharacter;
	int color = Colors.get(-1,222,333,444);

	@Override
	public void update()
	{
		game.level.music.stop();		
		game.level = LevelInitializer.BATTLE;
		cleanBattle();	
		addBattleParticipants();
		game.level.music.loop();
	}

	private void cleanBattle() {
		while(game.level.getEntitySize()>0){
			game.level.removeEntity(0);
		}
	}
	
	public void setGame(Loyal game)
	{
		this.game = game;
		sync();
	}

	@Override
	public void sync()
	{
	}
	
	public void addBattleParticipants()
	{
		game.currentBattle = new BattleMenu();
		
		pointer = new Pointer(game.level, "pointer", 16, 240, 16, 240, 296, game);
		game.level.addEntity(pointer);
		
		battleCharacter = new BattleCharacters(game.level, 16, 150, new int[] {color});
		game.level.addEntity(battleCharacter);
		
		
	}
}
