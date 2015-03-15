package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Actions.AbilityType;
import loyal.Battle.Actions.CharacterAction;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.Level;

public class BattleAI implements BattleController {
	
	private Level temp;
	private PlayingCharacter player = null;
	private ArrayList<CharacterAction> attacks = null;
	private ArrayList<PlayingCharacter> target = null;
	private CharacterAction attack = null;

	@Override
	public void setMenu(Level menu) {
		this.temp = menu;		
	}

	@Override
	public void tick(ArrayList<PlayingCharacter> activePlayers, ArrayList<PlayingCharacter> activeEnemies) {
		int index;
		
		if (player == null)
		{
			index = (int) Math.random() * 10;
			player = activePlayers.get(index);
		}
		
		attacks = Battle.getAttack(player);
		
		if (attack == null)
			attack = attacks.get((int) Math.random() * 10);

		if (target == null)
		{
			index = (int) Math.random() * 10;

<<<<<<< HEAD
	@Override

	public void tick(ArrayList<Object> activePlayers, ArrayList<Object> activeEnemies) {
		// TODO Auto-generated method stub
=======
			if (attack.getAbilityType() == AbilityType.OFFENSIVE)
				target.add(activeEnemies.get(index));
	
			else
				target.add(activePlayers.get(index));				
		}
>>>>>>> origin/jeffworkspace
		
		player.setTargets(target);
		updateBattleView(activePlayers);
	}

	//checks to remove any dead sprites	
	@Override
<<<<<<< HEAD
	public void updateBattleView(ArrayList<PlayingCharacter> activePlayers,
			ArrayList<PlayingCharacter> activeEnemies) {

		for (PlayingCharacter c: activePlayers)
		{
			if (c.isDead())
=======
	public void updateBattleView(ArrayList<PlayingCharacter> passedIn) {

		for (PlayingCharacter e: passedIn)
		{
			if (e.isDead())
>>>>>>> origin/jeffworkspace
			{
				
			//remove sprite from screen
			}
			else
			{
				// output names/health of those alive
			}
		}
	}
}
