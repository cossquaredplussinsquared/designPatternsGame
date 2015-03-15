
package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.Level;

public class BattleMenu implements BattleController { 
	
	private Level temp;
	private PlayingCharacter player = null, enemy = null;
	
	
	@Override
	public void setActivePlayers(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {
		for (PlayingCharacter p: activePlayers)
			if (p.isDead())
				activePlayers.remove(p);
		
		for (PlayingCharacter e: activeEnemies)
			if (e.isDead())
				activeEnemies.remove(e);
	}
	
	/*
	 * 
	 * 
	 */

	@Override
	public void setInterface(Level menu) {
		this.temp = menu;		
	}

	@Override
	public void tick(ArrayList<Object> activePlayers, ArrayList<Object> activeEnemies) {
		
		int index = getIndex(activeEnemies);
		
		if (player == null)
		{
			while (index == -1)
				index = getIndex(activePlayers);
			index = -1;
		}

		if (enemy == null)
		{
			while (index == -1)
				index = getIndex(activeEnemies);
			index = -1;
		}
		
		//updateBattleView(activePlayers, activeEnemies);
	}

	//checks to remove any dead sprites	
	@Override
	public void updateBattleView(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {

		for (PlayingCharacter e: activeEnemies)
		{
			if (e.isDead())
			{
				//remove sprite from screen
			}
			else
			{
				// output names/health of those alive
			}
		}
	}

	public int getIndex(ArrayList<Object> display)
	{
		int i = -1;
		
		if (display.size() <= 3)
		{
			//print a single list with three objects
		}
		else
		{
			//print three elements per list with a fourth object for a new page of new objects
		}
		 		
		//	this can be number or arrow based, as long as it knows position of certain output text objects
		
		return i;
	}
}