package loyal.entities;

import java.util.ArrayList;

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
		
		
	}

}
