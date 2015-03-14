
package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.Level;

public class BattleMenu implements BattleController { 
	
	public boolean running = false;
	
	@Override
	public void setActivePlayers(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers) {
		for (PlayingCharacter p: activePlayers)
			if (p.isDead())
				activePlayers.remove(p);
		
		for (PlayingCharacter e: activeEnemies)
			if (e.isDead())
				activeEnemies.remove(e);
	}

	@Override
	public void setInterface(Level menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		
		int index = getIndex();
		
		if (index != -1)
		{
			
		}		
		
	}

	@Override
	public void updateBattleState(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers) {

		for (PlayingCharacter c: activePlayers)
		{
			//print out players
		}
		for (PlayingCharacter e: activeEnemies)
		{
			//print out enemies
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

	@Override
	public void setMenu(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers) {
		// TODO Auto-generated method stub
		
	}
}

