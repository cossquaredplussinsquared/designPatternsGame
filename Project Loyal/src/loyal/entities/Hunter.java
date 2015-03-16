
package loyal.entities;

import java.lang.Thread.State;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class Hunter extends PlayingCharacter
{
	public Hunter(String name, CharacterType type)
	{
		super(name, type);
		state.setStat(Stat.HEALTH, 1000);
		state.setStat(Stat.MANA, 70);
		state.setStat(Stat.STRENGTH, 110);
		state.setStat(Stat.MAGICPOWER, 30);
		state.setStat(Stat.ARMOR, 70);
		state.setStat(Stat.MAGICRESIST, 55);
		state.setStat(Stat.LEVEL, 1);
		state.setStat(Stat.SPEED, 120);
		state.setStat(Stat.DEXTERITY, 160);
		state.setStat(Stat.DEFENSE, 50);
	}
}
