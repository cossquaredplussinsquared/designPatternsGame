
package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.Level;
import loyal.Battle.Actions.*;

public class BattleMenu implements BattleController { 
	
	private Level temp;
<<<<<<< HEAD
	private PlayingCharacter player = null, enemy = null;
	
	
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
	
	/*
	 * 
	 * 
	 */

=======
	private PlayingCharacter player = null;
	private ArrayList<CharacterAction> attacks = null;
	private ArrayList<PlayingCharacter> target = null;
	private CharacterAction attack = null;
	
>>>>>>> origin/jeffworkspace
	@Override
	public void setMenu(Level menu) {
		this.temp = menu;		
	}

	@Override
<<<<<<< HEAD
	public void tick(ArrayList<Object> activePlayers, ArrayList<Object> activeEnemies) {
		
		int index = getIndex(activeEnemies);
=======
	public void tick(ArrayList<PlayingCharacter> activePlayers, ArrayList<PlayingCharacter> activeEnemies) {
		int index = -1;
>>>>>>> origin/jeffworkspace
		
		if (player == null)
		{
			while (index == -1)
				index = getIndex(activePlayers);
<<<<<<< HEAD
			index = -1;
		}

		if (enemy == null)
		{
			while (index == -1)
				index = getIndex(activeEnemies);
			index = -1;
		}
		
		//updateBattleView(activePlayers, activeEnemies);
=======
			
			player = activePlayers.get(index);
			index = -1;
		}
		
		attacks = Battle.getAttack(player);
		
		if (attack == null)
		{
			while (attack == null)
				attack = getAttack(attacks);
		}

		if (target == null)
		{
			if (attack.getAbilityType() == AbilityType.OFFENSIVE)
			{
				while (index == -1)
				index = getIndex(activeEnemies);
			
				target.add(activeEnemies.get(index));
			}
			
			else
			{
				while (index == -1)
					index = getIndex(activePlayers);
				
				target.add(activePlayers.get(index));
				index = -1;
			}
				
			index = -1;
		}
		
		player.setTargets(target);
		updateBattleView(activeEnemies);
>>>>>>> origin/jeffworkspace
	}

	private CharacterAction getAttack(ArrayList<CharacterAction> attacks) {
		CharacterAction choice = null;
		
		if (attacks.size() <= 3)
		{
			//print a single list with three objects
		}
		else
		{
			//print three elements per list with a fourth object for a new page of new objects
		}
		 		
		//	this can be number or arrow based, as long as it knows position of certain output text objects
		
		return choice;
	}

	//checks to remove any dead sprites	
	@Override
<<<<<<< HEAD
	public void updateBattleView(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {

		for (PlayingCharacter e: activeEnemies)
=======
	public void updateBattleView(ArrayList<PlayingCharacter> passedIn) {

		for (PlayingCharacter e: passedIn)
>>>>>>> origin/jeffworkspace
		{
			if (e.isDead())
			{
				//remove sprite from screen
			}
			else
			{
				// output names/health of those alive
			}
		}
	}

<<<<<<< HEAD
	public int getIndex(ArrayList<Object> display)
=======
	public int getIndex(ArrayList<PlayingCharacter> display)
>>>>>>> origin/jeffworkspace
	{
		int i = -1;
		
		if (display.size() <= 3)
		{
			//print a single list with three objects
		}
		else
		{
			//print three elements per list with a fourth object for a new page of new objects
		}
		 		
		//	this can be number or arrow based, as long as it knows position of certain output text objects
		
		return i;
	}
}