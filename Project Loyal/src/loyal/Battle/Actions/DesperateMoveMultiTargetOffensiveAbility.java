package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;

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

	@Override
	protected ArrayList<PlayingCharacter> getTargets(PlayingCharacter target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean canCastOn(PlayingCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

}
