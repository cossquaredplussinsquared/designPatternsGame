package loyal.entities;

import java.util.ArrayList;

public class DarkOrbOffensiveSingleTargetAbility extends SingleTargetOffensiveAbility
{
	public DarkOrbOffensiveSingleTargetAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WIZZARD;
		checkCompability();
		name = "Dark Orb";
		description = "Abyss sorcery, very effective against enemies with high physical deffense";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		// i need a good character class to be able to finish this. and also an efficient state class.
		// i will make one later if i have the time.
		
	}
	
}
