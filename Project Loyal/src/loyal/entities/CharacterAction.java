package loyal.entities;

import loyal.Battle.Actions.AbilityType;
import loyal.Battle.Characters.PlayingCharacter;

public interface CharacterAction
{
	public void castCharacterAction(PlayingCharacter target);
	public String getName();
	public String toString();
	public AbilityType getAbilityType();

}