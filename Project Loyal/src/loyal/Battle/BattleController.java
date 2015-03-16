
package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.BattleLevel;

public interface BattleController {
	
	public void setMenu(BattleLevel menu);
	
	public void tick();
			
	public void updateBattleView();

	void setBattle(Battle currentBattle);
	
	void advanceState();
	Battle getBattle();
	
// needs to be more
	
}

