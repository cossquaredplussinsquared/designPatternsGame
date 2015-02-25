package loyal.entities;

import java.util.ArrayList;

public abstract class SingleTargetDefensiveAbility extends DefensiveAbility
{

	public SingleTargetDefensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		
	}

	@Override
	protected ArrayList<PlayingCharacter> getTargets(PlayingCharacter target)
	{
		ArrayList<PlayingCharacter> targets = new ArrayList<PlayingCharacter>();
		targets.add(target);
		return targets;
	}
	
}
