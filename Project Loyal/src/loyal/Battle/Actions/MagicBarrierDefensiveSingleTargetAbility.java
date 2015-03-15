
package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

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
	protected void applyAbility(ArrayList<PlayingCharacter> arrayOftargets)
	{
		double upgrade = playingCharacter.getState().getStat(Stat.MAGICPOWER) * scaling;
		upgrade += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			upgrade = 5 * upgrade;
		}
		
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
