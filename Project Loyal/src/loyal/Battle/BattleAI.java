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

			if (attack.getAbilityType() == AbilityType.OFFENSIVE)
				target.add(activeEnemies.get(index));
	
			else
				target.add(activePlayers.get(index));				
		}
		
		player.setTargets(target);
		updateBattleView(activePlayers);
	}

	//checks to remove any dead sprites	
	@Override
	public void updateBattleView(ArrayList<PlayingCharacter> passedIn) {

		for (PlayingCharacter e: passedIn)
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
}