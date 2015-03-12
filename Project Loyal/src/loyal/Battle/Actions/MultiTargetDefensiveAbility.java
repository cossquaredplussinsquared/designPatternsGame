package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;

public abstract class MultiTargetDefensiveAbility extends DefensiveAbility
{

	public MultiTargetDefensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
	}

	
	protected ArrayList<PlayingCharacter> getTargets(PlayingCharacter target)
	{
		ArrayList<PlayingCharacter> targets = new ArrayList<PlayingCharacter>();
		
		for(int i = 0; i < target.getAllies().size(); i++)
		{
			targets.add(target.getAllies().get(i));
		}
		
		return targets;
	}
	
}
