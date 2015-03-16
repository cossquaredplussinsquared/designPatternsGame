package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;


public interface CharacterAction
{
	public void castCharacterAction(PlayingCharacter target);
	public String getName();
	public String toString();
	public AbilityType getAbilityType();
	public void applyAbility(ArrayList<PlayingCharacter> arrayOftargets);

}
