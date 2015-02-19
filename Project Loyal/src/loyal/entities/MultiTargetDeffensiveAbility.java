package loyal.entities;

import java.util.ArrayList;

public abstract class MultiTargetDeffensiveAbility extends OffensiveAbility
{

	public MultiTargetDeffensiveAbility(PlayingCharacter playingCharacter)
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
