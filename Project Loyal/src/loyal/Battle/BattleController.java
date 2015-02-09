package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;

public interface BattleController {

	public void setActivePlayers(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers);
	
	

}
