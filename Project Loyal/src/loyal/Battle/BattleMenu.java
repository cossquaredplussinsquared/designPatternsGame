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
			// do battle shit
		}
		
		
	}

	@Override
	public void updateBattleState(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterValues() {
			
		
	}
	 
	
	public int getIndex()
	{
		int i = -1;
		
		// MenuItem(	
		
		return i;
	}

	@Override
	public void setMenu(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers) {
		// TODO Auto-generated method stub
		
	}
}
