package loyal.Battle.Actions;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.entities.Hunter;

public class HunterAbilityFactory implements AbilityFactory
{

	protected ArrowRainMultiTargetOffensiveAbility arrowRain;
	protected SharpShotOffensiveSingleTargetAbility sharpShot;
	protected SharpEyeDefensiveSingleTargetAbility sharpEye;
	protected PoisonousStabMultiTargetOffensiveAbility poisonousStab;
	protected PlayingCharacter playingCharacter;
	
	public HunterAbilityFactory()
	{
		this.playingCharacter = new Hunter("", CharacterType.HUNTER);
		arrowRain = new ArrowRainMultiTargetOffensiveAbility(playingCharacter);
		sharpShot = new SharpShotOffensiveSingleTargetAbility(playingCharacter);
		sharpEye = new SharpEyeDefensiveSingleTargetAbility(playingCharacter);
		poisonousStab = new PoisonousStabMultiTargetOffensiveAbility(playingCharacter);
	}
	

	@Override
	public Ability createCharacterAction(String name, PlayingCharacter playingCharacter)
	{
		 
		Ability ability;
		
		switch(name.toLowerCase())
		{
			case "sharp shot":
				ability = new SharpShotOffensiveSingleTargetAbility(playingCharacter);
				ability.setValues(100, 14, 3);
				break;
				
			case "arrow rain":
				ability = new ArrowRainMultiTargetOffensiveAbility(playingCharacter);
				ability.setValues(120, 9, 5);
				break;
			
			case "taunt":
				ability = new SharpEyeDefensiveSingleTargetAbility(playingCharacter);
				ability.setValues(80, 8, 2);
				break;
				
			case "poisonous stab":
				ability = new PoisonousStabMultiTargetOffensiveAbility(playingCharacter);
				ability.setValues(150, 16, 6);
				break;
				
			default:
				ability = null;
		}
		
		return ability;
		
	}

	@Override
	public String[] displayAbilitiesBasedOnType()
	{
		String listOfAbilities [] = {sharpShot.getName(), arrowRain.getName(), sharpEye.getName(), poisonousStab.getName()};
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
