
package loyal.entities;

import java.lang.Thread.State;

import loyal.Battle.Actions.DarkOrbOffensiveSingleTargetAbility;
import loyal.Battle.Actions.MagicShieldDefensiveSingleTargetAbility;
import loyal.Battle.Actions.SoulArrowOffensiveSingleTarget;
import loyal.Battle.Actions.SoulShowerMultiTargetOffensiveAbility;
import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class Wizzard extends PlayingCharacter
{
	
	DarkOrbOffensiveSingleTargetAbility darkOrb;
	SoulArrowOffensiveSingleTarget soulArrow;
	SoulShowerMultiTargetOffensiveAbility soulShower;
	MagicShieldDefensiveSingleTargetAbility magicShield;
	
	
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
		darkOrb = new DarkOrbOffensiveSingleTargetAbility(this);
		darkOrb.setValues(100, 10, 2);
		soulArrow = new SoulArrowOffensiveSingleTarget(this);
		soulArrow.setValues(75, 9, 3);
		soulShower = new SoulShowerMultiTargetOffensiveAbility(this);
		soulShower.setValues(80, 8, 3);
		magicShield = new MagicShieldDefensiveSingleTargetAbility(this);
		magicShield.setValues(100, 10, 2);
		this.addAction(darkOrb);
		this.addAction(soulArrow);
		this.addAction(soulShower);
		this.addAction(magicShield);
	}
}