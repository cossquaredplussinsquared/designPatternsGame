package loyal.entities;

import java.util.ArrayList;

public class SoulArrowOffensiveSingleTarget extends SingleTargetOffensiveAbility
{

	public SoulArrowOffensiveSingleTarget(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WIZZARD;
		checkCompability();
		name = "Soul Arrow";
		description = "An elementary sorcery. Fires a soul arrow straight ahead.";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		// i need a good character class to be able to finish this. and also an efficient state class.
		// i will make one later if i have the time.
		
	}
	
}