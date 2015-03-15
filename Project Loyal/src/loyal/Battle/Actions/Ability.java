package loyal.Battle.Actions;

import java.util.ArrayList;
import java.util.Random;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public abstract class Ability implements CharacterAction
{

	protected String name;
	protected String description;
	protected PlayingCharacter playingCharacter;
	protected CharacterType type;
	protected int level;
	protected int baseValue;
	protected double scaling;
	protected int perLevel;
	protected Random gen;
	protected AbilityType abilityType;
	
	public Ability(PlayingCharacter playingCharacter)
	{
		this.playingCharacter = playingCharacter;
		int level = 1;
		gen = new Random();
	}
	
	public void setValues(int baseValue, int perLevel, double scaling)
	{
		this.baseValue = baseValue;
		this.perLevel = perLevel;
		this.scaling = scaling;
	}
	
	public void checkCompability()
	{
		if(playingCharacter.getType() != this.type)
			throw new IllegalArgumentException("Incopatible ability type for this class of charaters");
	}
	
	public void castCharacterAction(PlayingCharacter target)
	{
		if(!canCastOn(target))
		{
			System.out.println("Invalid Target");
		}
		else
		{
			ArrayList<PlayingCharacter> targets = getTargets(target);
			applyAbility(targets);
		}
	}

	protected abstract void applyAbility(ArrayList<PlayingCharacter> targets);

	protected abstract ArrayList<PlayingCharacter> getTargets(PlayingCharacter target);

	protected abstract boolean canCastOn(PlayingCharacter target);

	@Override
	public String getName()
	{
		
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public int getLevel()
	{
		return this.level;
	}
	
	public void levelUp()
	{
		this.level++;
	}
	
	public void setPlayingCharacter(PlayingCharacter playingCharacter)
	{
		this.playingCharacter = playingCharacter;
	}

	public int getBaseValue()
	{
		return this.baseValue;
	}
	
	public double getScalling()
	{
		return this.scaling;
	}
	
	public int getPerLevel()
	{
		return this.perLevel;
	}
	
	public String getValues()
	{
		return "[" + this.baseValue + "," + this.scaling + "," + this.perLevel + "]";
	}
	
	@Override
	public AbilityType getAbilityType()
	{
		return this.abilityType;
	}
	
	
}