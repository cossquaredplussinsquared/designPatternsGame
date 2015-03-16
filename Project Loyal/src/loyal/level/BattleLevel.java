
package loyal.level;

import java.awt.Font;
import java.util.ArrayList;

import loyal.Sound;
import loyal.entities.Entity;
import loyal.entities.MenuItems;


public class BattleLevel extends Level
{
	final int PLAYERNAMES = 40;
	final int MENUSTART = 240;
	
	
	public BattleLevel(int id, String imagePath, Sound music)
	{
		super(id, imagePath, music);
	}
	
	public void setPlayerName(ArrayList<String> playerNames)
	{
		Entity Names = new MenuItems(this, playerNames, PLAYERNAMES);
		
		entities.remove(0);
		entities.add(0, Names);
	}
	
	public void setEnemyName(ArrayList<String> monsterNames)
	{
		Entity Names = new MenuItems(this, monsterNames, PLAYERNAMES);
		
		entities.remove(1);
		entities.add(1, Names);
	}
	
	public void setMenu(ArrayList<String> menuOptions)
	{
		Entity options = new MenuItems(this, menuOptions, PLAYERNAMES);
		
		entities.remove(2);
		entities.add(2, options);
	}

}

