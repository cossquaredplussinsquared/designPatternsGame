

package loyal.level;

import java.util.ArrayList;

import loyal.LevelInitializer;
import loyal.Loyal;
import loyal.Battle.Battle;
import loyal.Battle.BattleMenu;
import loyal.Graphics.Colors;
import loyal.entities.BattleCharacters;
import loyal.entities.GeneratorOfParties;
import loyal.entities.MenuItems;
import loyal.entities.Pointer;

public class EnterBattle implements Decision
{
	private Loyal game;
	Pointer pointer;
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
		GeneratorOfParties gen = new GeneratorOfParties();
		Battle bat = new Battle(gen.generateParty(), gen.generateEnemyParty());
		game.currentBattle = new BattleMenu();

		game.currentBattle.setBattle(bat);
		game.currentBattle.setMenu(LevelInitializer.BATTLE);
		pointer = new Pointer(game.level, "pointer", 16, 240, 16, 240, 296, game);
		game.level.addEntity(0, pointer);
		game.level.addEntity(new MenuItems(game.level, new ArrayList<String>(), 0, 0));
		game.level.addEntity(new MenuItems(game.level, new ArrayList<String>(), 0, 0));
		game.level.addEntity(new MenuItems(game.level, new ArrayList<String>(), 0, 0));
		
		BattleCharacters battleCharacter = new BattleCharacters(game.level, 16, 180, new int[] {color}, false);
		BattleCharacters battleCharacter1 = new BattleCharacters(game.level, 16, 130, new int[] {color}, false);
		BattleCharacters battleCharacter2 = new BattleCharacters(game.level, 16, 80, new int[] {color}, false);
		BattleCharacters battleCharacter3 = new BattleCharacters(game.level, 16, 30, new int[] {color}, false);
		
		BattleCharacters battleCharacter4 = new BattleCharacters(game.level, 440, 180, new int[] {color}, true);
		BattleCharacters battleCharacter5 = new BattleCharacters(game.level, 440, 130, new int[] {color}, true);
		BattleCharacters battleCharacter6 = new BattleCharacters(game.level, 440, 80, new int[] {color}, true);
		BattleCharacters battleCharacter7 = new BattleCharacters(game.level, 440, 30, new int[] {color}, true);
		
		game.level.addEntity(battleCharacter);
		game.level.addEntity(battleCharacter1);
		game.level.addEntity(battleCharacter2);
		game.level.addEntity(battleCharacter3);
		game.level.addEntity(battleCharacter4);
		game.level.addEntity(battleCharacter5);
		game.level.addEntity(battleCharacter6);
		game.level.addEntity(battleCharacter7);
		
		
	}

	@Override
	public void gameValue(int value) {
		// TODO Auto-generated method stub
		
	}
}
