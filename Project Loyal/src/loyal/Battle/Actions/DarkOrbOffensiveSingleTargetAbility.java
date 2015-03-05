package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

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

	@Override
	protected boolean canCastOn(PlayingCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
