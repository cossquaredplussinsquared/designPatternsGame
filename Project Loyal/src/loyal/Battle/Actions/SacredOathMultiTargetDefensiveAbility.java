
package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;


public class SacredOathMultiTargetDefensiveAbility extends MultiTargetDefensiveAbility
{

	public SacredOathMultiTargetDefensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.CLERIC;
		checkCompability();
		name = "Sacred Oath";
		description = "Forms a sacred bond with your party. Boosts the stats of your party";
	}

	@Override
	public void applyAbility(ArrayList<PlayingCharacter> arrayOftargets)
	{
		double damage = playingCharacter.getState().getStat(Stat.STRENGTH) * scaling;
		damage += baseValue + perLevel + level;
		
		if(gen.nextInt(100) <= playingCharacter.getState().getStat(Stat.DEXTERITY))
		{
			damage = 2* damage;
		}
		
		
		for(int i = 0; i < arrayOftargets.size(); i++)
		{
			if(arrayOftargets.get(i).isDead())
				continue;
			else
			{
				double currentDefense = arrayOftargets.get(i).getState().getStat(Stat.DEFENSE);
				currentDefense = currentDefense + 5;
				arrayOftargets.get(i).getState().setStat(Stat.DEFENSE, currentDefense);
				
				double currentStrength = arrayOftargets.get(i).getState().getStat(Stat.STRENGTH);
				currentStrength = currentStrength + 3;
				arrayOftargets.get(i).getState().setStat(Stat.STRENGTH, currentStrength);
				
				double currentSpeed = arrayOftargets.get(i).getState().getStat(Stat.SPEED);
				currentSpeed = currentSpeed + 4;
				arrayOftargets.get(i).getState().setStat(Stat.SPEED, currentSpeed);
				
				double currentDex = arrayOftargets.get(i).getState().getStat(Stat.DEXTERITY);
				currentDex = currentDex + 2;
				arrayOftargets.get(i).getState().setStat(Stat.DEXTERITY, currentDex);
			}
		}
		
	}
	
}

