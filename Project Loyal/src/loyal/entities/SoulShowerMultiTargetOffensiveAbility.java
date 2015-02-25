package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class SoulShowerMultiTargetOffensiveAbility extends MultiTargetOffensiveAbility
{

	public SoulShowerMultiTargetOffensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WIZZARD;
		checkCompability();
		name = "Soul Shower";
		description = "Hurls a huge soul mass which splits into smaller souls that rain from above.";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		double damage = playingCharacter.getState().getStat(Stat.STRENGTH) * scaling;
		damage += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			damage = damage + damage * (.5);
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
