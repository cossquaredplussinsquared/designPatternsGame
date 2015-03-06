package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class SoulArrowOffensiveSingleTarget extends SingleTargetOffensiveAbility
{

	public SoulArrowOffensiveSingleTarget(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WIZZARD;
		checkCompability();
		name = "Soul Arrow";
		description = "An elementary sorcery. Fires a soul arrow straight ahead.";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		double damage = playingCharacter.getState().getStat(Stat.MAGICPOWER) * scaling;
		damage += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			damage = damage + damage * (.5);
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