package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class SacredOathMultiTargetDefensiveAbility extends MultiTargetDefensiveAbility
{

	public SacredOathMultiTargetDefensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.CLERIC;
		checkCompability();
		name = "Sacred Oath";
		description = "Forms a sacred bond with your party. Boosts the stats of your party";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		double damage = playingCharacter.getState().getStat(Stat.STRENGTH) * scaling;
		damage += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			damage = 2* damage;
		}
		
		PlayingCharacter[] arrayOftargets = playingCharacter.getTargets();
		
		for(int i = 0; i < arrayOftargets.length; i++)
		{
			if(arrayOftargets[i].isDead())
				continue;
			else
			{
				double currentDefense = arrayOftargets[i].getState().getStat(Stat.DEFENSE);
				currentDefense = currentDefense + 5;
				arrayOftargets[i].getState().setStat(Stat.DEFENSE, currentDefense);
				
				double currentStrength = arrayOftargets[i].getState().getStat(Stat.STRENGTH);
				currentStrength = currentStrength + 3;
				arrayOftargets[i].getState().setStat(Stat.STRENGTH, currentStrength);
				
				double currentSpeed = arrayOftargets[i].getState().getStat(Stat.SPEED);
				currentSpeed = currentSpeed + 4;
				arrayOftargets[i].getState().setStat(Stat.SPEED, currentSpeed);
				
				double currentDex = arrayOftargets[i].getState().getStat(Stat.DEXTERITY);
				currentDex = currentDex + 2;
				arrayOftargets[i].getState().setStat(Stat.DEXTERITY, currentDex);
			}
		}
		
	}
	
}
