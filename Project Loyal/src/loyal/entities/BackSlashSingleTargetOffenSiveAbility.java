package loyal.entities;

import java.util.ArrayList;

public class BackSlashSingleTargetOffenSiveAbility extends SingleTargetOffensiveAbility
{
	
	public BackSlashSingleTargetOffenSiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WARRIOR;
		checkCompability();
		name = "Back Slash";
		description = "Powerfull physical attack";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		// i need a good character class to be able to finish this. and also an efficient state class.
		// i will make one later if i have the time.
		
	}
}
