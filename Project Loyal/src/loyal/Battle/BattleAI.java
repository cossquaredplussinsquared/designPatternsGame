package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.Level;

public class BattleAI implements BattleController {
	
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

	public void tick(ArrayList<Object> activePlayers, ArrayList<Object> activeEnemies) {
		// TODO Auto-generated method stub
		
	}

	//checks to remove any dead sprites	
	@Override
	public void updateBattleView(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {

		for (PlayingCharacter c: activePlayers)
		{
			if (c.isDead())
			{
				
			//remove sprite from screen
			}
			else
			{
				// output names/health of those alive
			}
		}
	}
}

