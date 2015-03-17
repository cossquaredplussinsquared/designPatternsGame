
package loyal.Battle.Actions;


import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;



public class BackSlashSingleTargetOffensiveAbility extends SingleTargetOffensiveAbility
{
	
	public BackSlashSingleTargetOffensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WARRIOR;
		checkCompability();
		name = "Back Slash";
		description = "Powerfull physical attack";
	}

	@Override
	public void applyAbility(ArrayList<PlayingCharacter> arrayOftargets)
	{
		double damage = playingCharacter.getState().getStat(Stat.STRENGTH) * scaling;
		damage += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			damage = damage * 2;
		}
		
		
		for(int i = 0; i < arrayOftargets.size(); i++)
		{
			if(arrayOftargets.get(i).isDead())
				continue;
			else
			{
				double currentHealth = arrayOftargets.get(i).getState().getStat(Stat.HEALTH);
				currentHealth = currentHealth - damage;
				if(currentHealth <= 0)
					arrayOftargets.get(i).getState().setStat(Stat.HEALTH, 0);
				else
					arrayOftargets.get(i).getState().setStat(Stat.HEALTH, currentHealth);
			}
		}
		
		
		
	}

	@Override
	public AbilityType getTargetType()
	{
		return super.targetType;
	}
}

