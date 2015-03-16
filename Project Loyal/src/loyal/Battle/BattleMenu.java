
package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Actions.CharacterAction;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.level.BattleLevel;
import loyal.level.DecisionFactory;
import loyal.level.Level;

public class BattleMenu implements BattleController { 
	
	private BattleLevel battleMenu;
	private Battle currentBattle;
	private PlayingCharacter player = null;
	private ArrayList<String> attacks = null;
	private ArrayList<PlayingCharacter> target = null;
	private CharacterAction attack = null;
	private String State = "Starting";
	
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
		
		if(!currentBattle.isPlayerTurn()){
			DecisionFactory.SWITCHBATTLECONTROLLER.update();
			return;
		}
		
		if(State.equals("Starting")){
			
		}
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

	public int getIndex(ArrayList<PlayingCharacter> display)
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