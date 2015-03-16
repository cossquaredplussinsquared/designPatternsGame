
package loyal.entities;

import loyal.Battle.Actions.LightningSpearOffensiveSingleTarget;
import loyal.Battle.Actions.MagicBarrierDefensiveSingleTargetAbility;
import loyal.Battle.Actions.SacredOathMultiTargetDefensiveAbility;
import loyal.Battle.Actions.SoothingSunlightDefensiveSingleTargetAbility;
import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class Cleric extends PlayingCharacter
{
	
	LightningSpearOffensiveSingleTarget lightningSpear;
	MagicBarrierDefensiveSingleTargetAbility magicBarrier;
	SacredOathMultiTargetDefensiveAbility sacredOath;
	SoothingSunlightDefensiveSingleTargetAbility sootingSunLight;
	
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
		lightningSpear = new LightningSpearOffensiveSingleTarget(this);
		this.lightningSpear.setValues(100, 14, 3);
		magicBarrier = new MagicBarrierDefensiveSingleTargetAbility(this);
		this.magicBarrier.setValues(120, 9, 5);
		sacredOath = new SacredOathMultiTargetDefensiveAbility(this);
		this.sacredOath.setValues(120, 8, 4);
		sootingSunLight = new SoothingSunlightDefensiveSingleTargetAbility(this);
		this.sootingSunLight.setValues(150, 16, 6);
		this.addAction(lightningSpear);
		this.addAction(magicBarrier);
		this.addAction(sacredOath);
		this.addAction(sootingSunLight);
	}
}

