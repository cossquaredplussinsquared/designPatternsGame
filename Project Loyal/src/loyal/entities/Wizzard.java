
package loyal.entities;

import java.lang.Thread.State;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class Wizzard extends PlayingCharacter
{
	public Wizzard(String name, CharacterType type)
	{
		super(name, type);
		state.setStat(Stat.HEALTH, 900);
		state.setStat(Stat.MANA, 20);
		state.setStat(Stat.STRENGTH, 80);
		state.setStat(Stat.MAGICPOWER, 140);
		state.setStat(Stat.ARMOR, 35);
		state.setStat(Stat.MAGICRESIST, 100);
		state.setStat(Stat.LEVEL, 1);
		state.setStat(Stat.SPEED, 60);
		state.setStat(Stat.DEXTERITY, 50);
		state.setStat(Stat.DEFENSE, 35);
	}
}