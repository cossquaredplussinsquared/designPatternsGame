package loyal.entities;

public interface AbilityFactory
{
	public CharacterAction createCharacterAction(String name, PlayingCharacter playingCharacter);
	public String[] displayAbilitiesBasedOnType();
}
