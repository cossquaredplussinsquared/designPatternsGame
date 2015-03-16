package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;

public abstract class SingleTargetOffensiveAbility extends OffensiveAbility
{

	public SingleTargetOffensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		super.targetType = AbilityType.SINGLE;
	}

	@Override
	protected ArrayList<PlayingCharacter> getTargets(PlayingCharacter target)
	{
		ArrayList<PlayingCharacter> targets = new ArrayList<PlayingCharacter>();
		targets.add(target);
		return targets;
	}
	
}
