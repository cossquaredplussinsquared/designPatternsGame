
package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.BattleLevel;

public interface BattleController {
	
	public void setMenu(BattleLevel menu);
	
	public void tick();
			
	public void updateBattleView(ArrayList<PlayingCharacter> activePlayers, 
			ArrayList<PlayingCharacter> activeEnemies);

	void setBattle(Battle currentBattle);
	
	
// needs to be more
	
}

