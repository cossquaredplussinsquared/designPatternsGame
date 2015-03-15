
package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class TauntSingleTargetDefenSiveAbility extends SingleTargetDefensiveAbility
{
	
	public TauntSingleTargetDefenSiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WARRIOR;
		checkCompability();
		name = "Taunt";
		description = "Increases the user stats";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> arrayOftargets)
	{
		
		for(int i = 0; i < arrayOftargets.size(); i++)
		{
			if(arrayOftargets.get(i).isDead())
				continue;
			else
			{
				double currentDefense = arrayOftargets.get(i).getState().getStat(Stat.DEFENSE);
				currentDefense = currentDefense + 5;
				arrayOftargets.get(i).getState().setStat(Stat.DEFENSE, currentDefense);
				
				double currentStrength = arrayOftargets.get(i).getState().getStat(Stat.STRENGTH);
				currentStrength = currentStrength + 3;
				arrayOftargets.get(i).getState().setStat(Stat.STRENGTH, currentStrength);
				
				double currentSpeed = arrayOftargets.get(i).getState().getStat(Stat.SPEED);
				currentSpeed = currentSpeed + 4;
				arrayOftargets.get(i).getState().setStat(Stat.SPEED, currentSpeed);
				
				double currentDex = arrayOftargets.get(i).getState().getStat(Stat.DEXTERITY);
				currentDex = currentDex + 2;
				arrayOftargets.get(i).getState().setStat(Stat.DEXTERITY, currentDex);
			}
		}
		
	}
}