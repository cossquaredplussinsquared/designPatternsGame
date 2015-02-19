package loyal.entities;

public interface CharacterAction
{
	public void castCharacterAction(PlayingCharacter target);
	public String getName();
	public String toString();
	public AbilityType getAbilityType();

}
