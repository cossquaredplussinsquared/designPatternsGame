package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Actions.AbilityType;
import loyal.Battle.Actions.CharacterAction;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.BattleLevel;
import loyal.level.DecisionFactory;
import loyal.level.Level;

public class BattleAI implements BattleController {
	
	private BattleLevel battleMenu;
	private PlayingCharacter player = null;
	private ArrayList<CharacterAction> attacks = null;
	private ArrayList<PlayingCharacter> target = null;
	private CharacterAction attack = null;
	private Battle currentBattle;

	@Override
	public void setMenu(BattleLevel menu) {
		this.battleMenu = menu;		
	}
	
	@Override
	public void setBattle(Battle currentBattle){
		this.currentBattle = currentBattle;
	}
	
	
	@Override
	public void tick() {
		int index = -1;
		ArrayList<PlayingCharacter> activePlayers = currentBattle.getActivePlayers();
		ArrayList<PlayingCharacter> activeEnemies = currentBattle.getActiveEnemies();
		
		if(currentBattle.isPlayerTurn()){
			DecisionFactory.SWITCHBATTLECONTROLLER.update();
			return;
		}
	
		if (player == null)
		{
			do
			{
				index = (int) Math.random() * 10;
			} while (index > activePlayers.size());
			player = activePlayers.get(index);
			index = -1;
		}
		
		//attacks = Battle.getAttack(player);
		
		if (attack == null)
		{
			do
			{
				index = (int) Math.random() * 10;
			} while (index > attacks.size());
			attack = attacks.get(index);
		}

		if (target == null)
		{
			if (attack.getAbilityType() == AbilityType.OFFENSIVE)
			{
				do
				{
					index = (int) Math.random() * 10;
				} while (index > activeEnemies.size() + 1);
				//for group attacks
				if (index == activeEnemies.size() + 1)
					for(PlayingCharacter e: activeEnemies)
						target.add(e);
				//for single attacks
				else
					target.add(activePlayers.get(index));
				index = -1;
			}
			
			else
			{
				do
				{
					index = (int) Math.random() * 10;
				} while (index > activePlayers.size());
				//for group defense
				if (index == activeEnemies.size() + 1)
					for(PlayingCharacter e: activeEnemies)
						target.add(e);
				//for single defense
				else
					target.add(activePlayers.get(index));
				index = -1;
			}
				
			index = -1;
		}
		
		player.setTargets(target);
		updateBattleView(activePlayers, activeEnemies);
	}

	//checks to remove any dead sprites	
	@Override
	public void updateBattleView(ArrayList<PlayingCharacter> activePlayers, 
			ArrayList<PlayingCharacter> activeEnemies) {
		for (PlayingCharacter e: activePlayers)
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
		
		for (PlayingCharacter e: activeEnemies)
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
