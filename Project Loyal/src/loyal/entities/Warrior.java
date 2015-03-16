package loyal.entities;

import java.lang.Thread.State;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class Warrior extends PlayingCharacter
{
	public Warrior(String name, CharacterType type)
	{
		super(name, type);
		state.setStat(Stat.HEALTH, 1200);
		state.setStat(Stat.MANA, 40);
		state.setStat(Stat.STRENGTH, 120);
		state.setStat(Stat.MAGICPOWER, 40);
		state.setStat(Stat.ARMOR, 75);
		state.setStat(Stat.MAGICRESIST, 30);
		state.setStat(Stat.LEVEL, 1);
		state.setStat(Stat.SPEED, 75);
		state.setStat(Stat.DEXTERITY, 30);
		state.setStat(Stat.DEFENSE, 55);
	}
}
