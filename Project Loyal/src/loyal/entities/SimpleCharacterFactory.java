package loyal.entities;

import javax.print.attribute.standard.Chromaticity;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class SimpleCharacterFactory {

	public PlayingCharacter createCharacter(String name,CharacterType type)
	{
		PlayingCharacter character = null;
		if(type.equals(CharacterType.WIZARD))
		{
			character = new Wizard(name, type);
		}
		
		else if (type.equals(CharacterType.WARRIOR))
		{
			character = new Warrior(name, type);
		}
		
		else if(type.equals(CharacterType.HUNTER))
		{
			character = new Hunter(name, type);
		}
		
		else if(type.equals(CharacterType.CLERIC))
		{
			character = new Cleric(name, type);
		}
		
		
		return character;
	}

}
