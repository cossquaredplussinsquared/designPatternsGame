package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class SharpShotOffensiveSingleTargetAbility extends SingleTargetOffensiveAbility
{
	public SharpShotOffensiveSingleTargetAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.HUNTER;
		checkCompability();
		name = "Sharp shot";
		description = "Shar shot that almost never misses its target";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		double damage = playingCharacter.getState().getStat(Stat.DEXTERITY) * scaling 
				      + playingCharacter.getState().getStat(Stat.STRENGTH) * scaling;
		
		damage += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			damage = 2 * damage;
		}
		
		PlayingCharacter[] arrayOftargets = playingCharacter.getTargets();
		
		for(int i = 0; i < arrayOftargets.length; i++)
		{
			if(arrayOftargets[i].isDead())
				continue;
			else
			{
				double currentHealth = arrayOftargets[i].getState().getStat(Stat.HEALTH);
				currentHealth = currentHealth - damage;
				arrayOftargets[i].getState().setStat(Stat.HEALTH, currentHealth);
			}
		}
		
	}
	
}
