package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;

public class MagicShieldDefensiveSingleTargetAbility extends MultiTargetDeffensiveAbility
{

	public MagicShieldDefensiveSingleTargetAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		
		
	}

	@Override
	protected ArrayList<PlayingCharacter> getTargets(PlayingCharacter target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean canCastOn(PlayingCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

}
