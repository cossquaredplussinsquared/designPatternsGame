package loyal.Battle.Actions;

import loyal.Battle.Characters.PlayingCharacter;

public class WizzardAbilityFactory implements AbilityFactory
{

	protected DarkOrbOffensiveSingleTargetAbility darkOrb;
	protected PlayingCharacter playingCharacter;
	
	@Override
	public CharacterAction createCharacterAction(String name, PlayingCharacter playingCharacter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] displayAbilitiesBasedOnType()
	{
		String listOfAbilities [] = {"Dark Orb"};
		return listOfAbilities;
	}
	
}
