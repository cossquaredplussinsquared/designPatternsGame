package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class SootingSunlightDefensiveSingleTargetAbility extends MultiTargetDefensiveAbility
{

	public SootingSunlightDefensiveSingleTargetAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.CLERIC;
		checkCompability();
		name = "Sooting Sunlight";
		description = "Heals caster and nearby allies.";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		double upgrade = playingCharacter.getState().getStat(Stat.MAGICPOWER) * scaling;
		upgrade += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			upgrade = 3 * upgrade;
		}
		
		ArrayList<PlayingCharacter> arrayOftargets = playingCharacter.getTargets();
		
		for(int i = 0; i < arrayOftargets.size(); i++)
		{
			if(arrayOftargets.get(i).isDead())
				continue;
			else
			{
				double currentHealth = arrayOftargets.get(i).getState().getStat(Stat.HEALTH);
				currentHealth = currentHealth + upgrade;
				arrayOftargets.get(i).getState().setStat(Stat.HEALTH, currentHealth);
			}
		}
		
	}

}
