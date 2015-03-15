
package loyal.Battle;

import java.util.ArrayList;

import loyal.level.*;
import loyal.Battle.Characters.PlayingCharacter;

public interface BattleController {
	
	public void setMenu(Level menu);
	
<<<<<<< HEAD
	public void tick(ArrayList<Object> activePlayers, ArrayList<Object> activeEnemies);
			
	public void updateBattleView(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies);
=======
	public void tick(ArrayList<PlayingCharacter> activePlayers, ArrayList<PlayingCharacter> activeEnemies);
			
	public void updateBattleView(ArrayList<PlayingCharacter> passedIn);
>>>>>>> origin/jeffworkspace
	
// needs to be more
	
}

