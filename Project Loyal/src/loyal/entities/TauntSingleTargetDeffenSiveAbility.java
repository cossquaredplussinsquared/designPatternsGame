package loyal.entities;

import java.util.ArrayList;

public class TauntSingleTargetDeffenSiveAbility extends SingleTargetOffensiveAbility
{
	
	public TauntSingleTargetDeffenSiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WARRIOR;
		checkCompability();
		name = "Taunt";
		description = "Increases the user stats";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		// i need a good character class to be able to finish this. and also an efficient state class.
		// i will make one later if i have the time.
		
	}
}
