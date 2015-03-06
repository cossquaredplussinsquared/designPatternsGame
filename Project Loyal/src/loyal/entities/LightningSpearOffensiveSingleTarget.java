package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class LightningSpearOffensiveSingleTarget extends SingleTargetOffensiveAbility
{

	public LightningSpearOffensiveSingleTarget(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.CLERIC;
		checkCompability();
		name = "Lightning Spear";
		description = "A miracle that launches a great light spear..";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		double damage = playingCharacter.getState().getStat(Stat.MAGICPOWER) * scaling;
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
				arrayOftargets.get(i).getState().setStat(Stat.HEALTH, currentHealth);
			}
		}
		
	}
	
}