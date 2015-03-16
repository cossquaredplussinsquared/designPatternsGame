
package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class SharpEyeDefensiveSingleTargetAbility extends SingleTargetDefensiveAbility
{

	public SharpEyeDefensiveSingleTargetAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.HUNTER;
		checkCompability();
		name = "SharpEye";
		description = "Increases the hunter Dexterity.";
	}

	@Override
	public void applyAbility(ArrayList<PlayingCharacter> arrayOfTargets)
	{	
		
		for(int i = 0; i < arrayOfTargets.size(); i++)
		{
			if(arrayOfTargets.get(i).isDead())
				continue;
			else
			{
				double currentDex = arrayOfTargets.get(i).getState().getStat(Stat.DEXTERITY);
				currentDex = 4 * currentDex;
				arrayOfTargets.get(i).getState().setStat(Stat.DEFENSE, currentDex);
			}
		}
		
	}
	@Override
	public AbilityType getTargetType() {
		// TODO Auto-generated method stub
		return super.targetType;
	}
}
