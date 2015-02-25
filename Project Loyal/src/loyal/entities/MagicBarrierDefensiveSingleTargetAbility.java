package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class MagicBarrierDefensiveSingleTargetAbility extends SingleTargetDefensiveAbility
{

	public MagicBarrierDefensiveSingleTargetAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.CLERIC;
		checkCompability();
		name = "Magic Barrier";
		description = "Reduces damage taken by magical and physical attacks.";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		double upgrade = playingCharacter.getState().getStat(Stat.MAGICPOWER) * scaling;
		upgrade += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			upgrade = 5 * upgrade;
		}
		
		PlayingCharacter[] arrayOftargets = playingCharacter.getTargets();
		
		for(int i = 0; i < arrayOftargets.length; i++)
		{
			if(arrayOftargets[i].isDead())
				continue;
			else
			{
				double currentDefense = arrayOftargets[i].getState().getStat(Stat.DEFENSE);
				currentDefense = currentDefense + upgrade;
				arrayOftargets[i].getState().setStat(Stat.DEFENSE, currentDefense);
			}
		}
		
	}

}
