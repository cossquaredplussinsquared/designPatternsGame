package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class MagicShieldDefensiveSingleTargetAbility extends SingleTargetDefensiveAbility
{

	public MagicShieldDefensiveSingleTargetAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WIZZARD;
		checkCompability();
		name = "Magic shield";
		description = "Summon a protective aura around the player that reduces damage.";
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
		
		ArrayList<PlayingCharacter> arrayOftargets = playingCharacter.getTargets();
		
		for(int i = 0; i < arrayOftargets.size(); i++)
		{
			if(arrayOftargets.get(i).isDead())
				continue;
			else
			{
				double currentDefense = arrayOftargets.get(i).getState().getStat(Stat.DEFENSE);
				currentDefense = currentDefense + upgrade;
				arrayOftargets.get(i).getState().setStat(Stat.DEFENSE, currentDefense);
			}
		}
		
	}

}
