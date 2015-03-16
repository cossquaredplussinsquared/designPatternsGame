
package loyal.entities;

import java.lang.Thread.State;

import loyal.Battle.Actions.ArrowRainMultiTargetOffensiveAbility;
import loyal.Battle.Actions.PoisonousStabMultiTargetOffensiveAbility;
import loyal.Battle.Actions.SharpEyeDefensiveSingleTargetAbility;
import loyal.Battle.Actions.SharpShotOffensiveSingleTargetAbility;
import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class Hunter extends PlayingCharacter
{
	
	PoisonousStabMultiTargetOffensiveAbility poisonousStab;
	SharpEyeDefensiveSingleTargetAbility sharpEye;
	SharpShotOffensiveSingleTargetAbility sharpShot;
	ArrowRainMultiTargetOffensiveAbility arrowRain;
	
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
		this.poisonousStab = new PoisonousStabMultiTargetOffensiveAbility(this);
		this.poisonousStab.setValues(150, 16, 6);
		this.arrowRain = new ArrowRainMultiTargetOffensiveAbility(this);
		this.arrowRain.setValues(120, 9, 5);
		this.sharpShot = new SharpShotOffensiveSingleTargetAbility(this);
		this.sharpShot.setValues(100, 14, 3);
		this.sharpEye = new SharpEyeDefensiveSingleTargetAbility(this);
		this.sharpEye.setValues(80, 8, 2);
		this.addAction(arrowRain);
		this.addAction(poisonousStab);
		this.addAction(sharpEye);
		this.addAction(sharpShot);
	}
}
