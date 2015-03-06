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
		ArrayList<PlayingCharacter> arrayOftargets = playingCharacter.getTargets();
		
		for(int i = 0; i < arrayOftargets.size(); i++)
		{
			if(arrayOftargets.get(i).isDead())
				continue;
			else
			{
				double currentDex = arrayOftargets.get(i).getState().getStat(Stat.DEXTERITY);
				currentDex = 4 * currentDex;
				arrayOftargets.get(i).getState().setStat(Stat.DEFENSE, currentDex);
			}
		}
		
	}

}
