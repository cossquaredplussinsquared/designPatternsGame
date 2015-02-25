package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class BackSlashSingleTargetOffenSiveAbility extends SingleTargetOffensiveAbility
{
	
	public BackSlashSingleTargetOffenSiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WARRIOR;
		checkCompability();
		name = "Back Slash";
		description = "Powerfull physical attack";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		double damage = playingCharacter.getState().getStat(Stat.STRENGTH) * scaling;
		damage += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			damage = damage * 2;
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
