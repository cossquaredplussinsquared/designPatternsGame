package loyal.entities;

import java.util.ArrayList;

public class AirSlashSingleTargetOffenSiveAbility extends SingleTargetOffensiveAbility
{
	
	public AirSlashSingleTargetOffenSiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WARRIOR;
		checkCompability();
		name = "Air Slash";
		description = "Powerfull physical attack in the air";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		// i need a good character class to be able to finish this. and also an efficient state class.
		// i will make one later if i have the time.
		
	}
}
