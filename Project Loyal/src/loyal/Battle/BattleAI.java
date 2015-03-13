
package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.Level;

public class BattleAI implements BattleController {

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

<<<<<<< HEAD
	@Override
	public void run() {
=======


	@Override
	public void setCharacterValues() {
>>>>>>> origin/master
		// TODO Auto-generated method stub
		
	}

	@Override
<<<<<<< HEAD
	public void setMenu() {
=======
	public void tick() {
>>>>>>> origin/master
		// TODO Auto-generated method stub
		
	}

	@Override
<<<<<<< HEAD
	public void updateBattleState() {
=======
	public void updateBattleState(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers) {
>>>>>>> origin/master
		// TODO Auto-generated method stub
		
	}

	@Override
<<<<<<< HEAD
	public void setCharacterValues() {
=======
	public void setMenu(ArrayList<PlayingCharacter> activeEnemies,
			ArrayList<PlayingCharacter> activePlayers) {
>>>>>>> origin/master
		// TODO Auto-generated method stub
		
	}

}

