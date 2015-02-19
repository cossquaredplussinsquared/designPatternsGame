package loyal.entities;
import java.util.ArrayList;

public abstract class OffensiveAbility extends Ability
{
	public OffensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		abilityType = AbilityType.OFFENSIVE;
	}
	
	protected boolean canCastOn(PlayingCharacter target)
	{
		ArrayList<PlayingCharacter> allies = playingCharacter.getAllies();
		
		for(int i = 0; i < allies.size(); i++)
		{
			if(target.compareTo(allies.get(i)) == 0)
				return false;
		}
		return true;
	}
}
