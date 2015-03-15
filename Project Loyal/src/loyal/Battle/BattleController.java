
package loyal.Battle;

import java.util.ArrayList;

import loyal.level.*;
import loyal.Battle.Characters.PlayingCharacter;

public interface BattleController {
	
	public void setMenu(Level menu);
	
	public void tick(ArrayList<PlayingCharacter> activePlayers, ArrayList<PlayingCharacter> activeEnemies);
			
	public void updateBattleView(ArrayList<PlayingCharacter> passedIn);
	
// needs to be more
	
}

