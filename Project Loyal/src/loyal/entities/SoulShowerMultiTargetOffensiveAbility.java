package loyal.entities;

import java.util.ArrayList;

public class SoulShowerMultiTargetOffensiveAbility extends MultiTargetOffensiveAbility
{

	public SoulShowerMultiTargetOffensiveAbility(PlayingCharacter playingCharacter)
	{
		super(playingCharacter);
		type = CharacterType.WIZZARD;
		checkCompability();
		name = "Soul Shower";
		description = "Hurls a huge soul mass which splits into smaller souls that rain from above.";
	}

	@Override
	protected void applyAbility(ArrayList<PlayingCharacter> targets) {
		// TODO Auto-generated method stub
		
	}
	
}
