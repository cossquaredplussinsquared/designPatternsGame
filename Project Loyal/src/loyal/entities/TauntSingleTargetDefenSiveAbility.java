package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class TauntSingleTargetDefenSiveAbility extends SingleTargetDefensiveAbility
{
	
	public TauntSingleTargetDefenSiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WARRIOR;
		checkCompability();
		name = "Taunt";
		description = "Increases the user stats";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets)
	{
		PlayingCharacter[] arrayOftargets = playingCharacter.getTargets();
		
		for(int i = 0; i < arrayOftargets.length; i++)
		{
			if(arrayOftargets[i].isDead())
				continue;
			else
			{
				double currentDefense = arrayOftargets[i].getState().getStat(Stat.DEFENSE);
				currentDefense = currentDefense + 5;
				arrayOftargets[i].getState().setStat(Stat.DEFENSE, currentDefense);
				
				double currentStrength = arrayOftargets[i].getState().getStat(Stat.STRENGTH);
				currentStrength = currentStrength + 3;
				arrayOftargets[i].getState().setStat(Stat.STRENGTH, currentStrength);
				
				double currentSpeed = arrayOftargets[i].getState().getStat(Stat.SPEED);
				currentSpeed = currentSpeed + 4;
				arrayOftargets[i].getState().setStat(Stat.SPEED, currentSpeed);
				
				double currentDex = arrayOftargets[i].getState().getStat(Stat.DEXTERITY);
				currentDex = currentDex + 2;
				arrayOftargets[i].getState().setStat(Stat.DEXTERITY, currentDex);
			}
		}
		
	}
}
