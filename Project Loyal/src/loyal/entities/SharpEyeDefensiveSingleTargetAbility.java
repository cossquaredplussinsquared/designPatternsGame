package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

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
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{	
		PlayingCharacter[] arrayOftargets = playingCharacter.getTargets();
		
		for(int i = 0; i < arrayOftargets.length; i++)
		{
			if(arrayOftargets[i].isDead())
				continue;
			else
			{
				double currentDex = arrayOftargets[i].getState().getStat(Stat.DEXTERITY);
				currentDex = 4 * currentDex;
				arrayOftargets[i].getState().setStat(Stat.DEFENSE, currentDex);
			}
		}
		
	}

}
