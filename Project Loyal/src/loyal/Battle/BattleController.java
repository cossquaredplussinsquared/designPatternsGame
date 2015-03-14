
package loyal.Battle;

import java.util.ArrayList;
import loyal.level.*;

import loyal.Battle.Characters.PlayingCharacter;

public interface BattleController {

	public void setActivePlayers(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers);
	
	public void setInterface(Level menu);
	
	public void tick();
			
	public void updateBattleState(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers);
	
	void setMenu(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers);
	
// needs to be more
	
}

