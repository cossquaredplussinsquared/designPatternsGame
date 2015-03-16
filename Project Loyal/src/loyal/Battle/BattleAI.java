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

		
		if(currentBattle.isPlayerTurn()){
			DecisionFactory.SWITCHBATTLECONTROLLER.update();
			return;
		}
		
		player.setTargets(target);
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
