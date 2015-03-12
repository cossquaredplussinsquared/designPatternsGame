package loyal.Battle;

import java.util.ArrayList;
import loyal.level.*;

import loyal.Battle.Characters.PlayingCharacter;

public interface BattleController {

	public void setActivePlayers(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers);
	
	public void setInterface(Level menu);

}
