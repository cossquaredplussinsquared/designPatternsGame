package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

public class AirSlashSingleTargetOffenSiveAbility extends SingleTargetOffensiveAbility
{
	
	public AirSlashSingleTargetOffenSiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WARRIOR;
		checkCompability();
		name = "Air Slash";
		description = "Powerfull physical attack in the air";
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
		
		ArrayList<PlayingCharacter> arrayOftargets = playingCharacter.getTargets();
		
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
}
