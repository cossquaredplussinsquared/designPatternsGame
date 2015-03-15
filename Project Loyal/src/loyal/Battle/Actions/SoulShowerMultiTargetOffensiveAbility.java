
package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

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
	protected void applyAbility(ArrayList<PlayingCharacter> arrayOftargets)
	{
		double damage = playingCharacter.getState().getStat(Stat.STRENGTH) * scaling;
		damage += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			damage = damage + damage * (.5);
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
}