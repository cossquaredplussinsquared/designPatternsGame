package loyal.entities;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class CharacterStore
{
	private SimpleCharacterFactory factory;
	
	public CharacterStore(SimpleCharacterFactory factory)
	{
		this.factory = factory;
	}
	
	public PlayingCharacter orderCharacter(String name, CharacterType type)
	{
		PlayingCharacter character;
		character = factory.createCharacter(name, type);
		return character;
	}
	
}
