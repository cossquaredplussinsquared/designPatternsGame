package loyal.entities;

import java.lang.Thread.State;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class Cleric extends PlayingCharacter
{
	public Cleric(String name, CharacterType type)
	{
		super(name, type);
		state.setStat(Stat.HEALTH, 950);
		state.setStat(Stat.MANA, 30);
		state.setStat(Stat.STRENGTH, 90);
		state.setStat(Stat.MAGICPOWER, 140);
		state.setStat(Stat.ARMOR, 45);
		state.setStat(Stat.MAGICRESIST, 90);
		state.setStat(Stat.LEVEL, 1);
		state.setStat(Stat.SPEED, 35);
		state.setStat(Stat.DEXTERITY, 45);
		state.setStat(Stat.DEFENSE, 45);
	}
}
