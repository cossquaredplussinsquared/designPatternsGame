
package loyal.Battle;

import java.util.ArrayList;

import loyal.level.*;
import loyal.Battle.Characters.PlayingCharacter;

public interface BattleController {

	public void setActivePlayers(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies);
	
	public void setInterface(Level menu);
	
	public void tick(ArrayList<Object> activePlayers, ArrayList<Object> activeEnemies);
			
	public void updateBattleView(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies);
	
// needs to be more
	
}

