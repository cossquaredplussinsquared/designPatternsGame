package loyal.entities;

import java.util.ArrayList;

public abstract class MultiTargetOffensiveAbility extends OffensiveAbility
{

	public MultiTargetOffensiveAbility(PlayingCharacter playingCharacter)
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
