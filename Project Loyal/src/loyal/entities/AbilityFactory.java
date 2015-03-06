package loyal.entities;

public interface AbilityFactory
{
	public CharacterAction createCharacterAction(String abilityName, PlayingCharacter playingCharacter);
	public String[] displayAbilitiesBasedOnType();
}
