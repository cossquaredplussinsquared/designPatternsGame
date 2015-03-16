

package loyal.Battle.Actions;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.entities.Warrior;

public class WarriorAbilityFactory implements AbilityFactory
{

	protected AirSlashSingleTargetOffensiveAbility airSlash;
	protected BackSlashSingleTargetOffensiveAbility backSlash;
	protected TauntSingleTargetDefenSiveAbility taunt;
	protected DesperateMoveMultiTargetOffensiveAbility desperateMove;
	protected PlayingCharacter playingCharacter;
	
	public WarriorAbilityFactory()
	{
		this.playingCharacter = new Warrior("", CharacterType.WARRIOR);
		airSlash = new AirSlashSingleTargetOffensiveAbility(playingCharacter);
		backSlash = new BackSlashSingleTargetOffensiveAbility(playingCharacter);
		taunt = new TauntSingleTargetDefenSiveAbility(playingCharacter);
		desperateMove = new DesperateMoveMultiTargetOffensiveAbility(playingCharacter);
	}
	

	@Override
	public Ability createCharacterAction(String abilityName, PlayingCharacter playingCharacter)
	{
		 
		Ability ability;
		
		switch(abilityName.toLowerCase())
		{
			case "air slash":
				ability = new AirSlashSingleTargetOffensiveAbility(playingCharacter);
				ability.setValues(100, 14, 3);
				break;
				
			case "back slash":
				ability = new BackSlashSingleTargetOffensiveAbility(playingCharacter);
				ability.setValues(120, 9, 5);
				break;
			
			case "taunt":
				ability = new TauntSingleTargetDefenSiveAbility(playingCharacter);
				ability.setValues(80, 8, 2);
				break;
				
			case "desperate move":
				ability = new DesperateMoveMultiTargetOffensiveAbility(playingCharacter);
				ability.setValues(150, 13, 6);
				break;
				
			default:
				ability = null;
		}
		
		return ability;
		
	}

	@Override
	public String[] displayAbilitiesBasedOnType()
	{
		String listOfAbilities [] = {airSlash.getName(), backSlash.getName(), taunt.getName(), desperateMove.getName()};
		return listOfAbilities;
	}
	
	public void printListOfAbilities()
	{
		String [] listOfAbilities = displayAbilitiesBasedOnType();
		for(int i = 0; i < listOfAbilities.length; i++)
		{
			System.out.println(listOfAbilities[i]);
		}
	}
	
}
