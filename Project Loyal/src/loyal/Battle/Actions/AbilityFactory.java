
package loyal.Battle.Actions;

import loyal.Battle.Characters.PlayingCharacter;

public interface AbilityFactory
{
	public CharacterAction createCharacterAction(String name, PlayingCharacter playingCharacter);
	public String[] displayAbilitiesBasedOnType();
}



