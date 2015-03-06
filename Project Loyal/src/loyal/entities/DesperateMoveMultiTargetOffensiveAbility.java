package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class DesperateMoveMultiTargetOffensiveAbility extends MultiTargetOffensiveAbility
{

	
	public DesperateMoveMultiTargetOffensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);	
		type = CharacterType.WARRIOR;
		checkCompability();
		name = "The Worrier Desperate Move";
		description = "Attacks all the enemey at sight";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		
		double damage = playingCharacter.getState().getStat(Stat.STRENGTH) * scaling;
		damage += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			damage = 5 * damage; 
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
				arrayOftargets.get(i).getState().setStat(Stat.HEALTH, currentHealth);
			}
		}
	}

}
