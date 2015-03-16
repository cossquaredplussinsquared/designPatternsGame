
package loyal.entities;

import java.lang.Thread.State;

import loyal.Battle.Actions.AirSlashSingleTargetOffenSiveAbility;
import loyal.Battle.Actions.BackSlashSingleTargetOffenSiveAbility;
import loyal.Battle.Actions.DesperateMoveMultiTargetOffensiveAbility;
import loyal.Battle.Actions.TauntSingleTargetDefenSiveAbility;
import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class Warrior extends PlayingCharacter
{
	
	AirSlashSingleTargetOffenSiveAbility airSlash;
	BackSlashSingleTargetOffenSiveAbility backSlash;
	DesperateMoveMultiTargetOffensiveAbility desperateMove;
	TauntSingleTargetDefenSiveAbility taunt;
	
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
		airSlash = new AirSlashSingleTargetOffenSiveAbility(this);
		backSlash = new BackSlashSingleTargetOffenSiveAbility(this);
		desperateMove = new DesperateMoveMultiTargetOffensiveAbility(this);
		taunt = new TauntSingleTargetDefenSiveAbility(this);
		this.addAction(airSlash);
		airSlash.setValues(100, 14, 3);
		this.addAction(backSlash);
		this.backSlash.setValues(120, 9, 5);
		this.addAction(desperateMove);
		this.desperateMove.setValues(150, 13, 6);
		this.addAction(taunt);
		this.taunt.setValues(80, 8, 2);
		
	}
}
