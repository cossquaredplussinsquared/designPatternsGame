
package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.Level;

public class BattleMenu implements BattleController { 
	
	private Level temp;
	
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

	@Override
	public void setInterface(Level menu) {
		this.temp = menu;		
	}

	@Override
	public void tick() {
		
		int index = getIndex();
		
		if (index != -1)
		{
			
		}		
		
	}

	//checks to remove any dead sprites	
	@Override
	public void updateBattleState(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {

		for (PlayingCharacter c: activePlayers)
			if(c.isDead())
			{
				//remove sprite from screen
			}
		for (PlayingCharacter e: activeEnemies)
			if(e.isDead())
			{
				//remove sprite from screen
			}
	}

	public int getIndex()
	{
		int i = -1;
		
		/*	if (inputHandler is pressed for 1)
				i = 1;
			else if (inputHandler is pressed for 2)
				i = 2;
			else if (inputHandler is pressed for 3)
				i = 3;
			else if (inputHandler is pressed for 4)
				i = 4;
				
			this can also be arrow based, as long as it knows position of certain output text objects
		*/
		
		return i;
	}

}

