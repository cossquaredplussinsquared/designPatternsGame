package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class Tester {

	public static void main(String[] args)
	{
		PlayingCharacter testCharacter = new PlayingCharacter("Test HeroCharacter", CharacterType.WIZZARD);
		
		PlayingCharacter targetCharacter = new PlayingCharacter("Test targetCharacter", CharacterType.WARRIOR);
		
		WizzardAbilityFactory wizzardAbilityFactory = new WizzardAbilityFactory();
		
		Ability darkOrb = wizzardAbilityFactory.createCharacterAction("dark orb", testCharacter);
		
		testCharacter.addAction(darkOrb);
		
		ArrayList<PlayingCharacter> arrayListOfTargets = new ArrayList<PlayingCharacter>();
		arrayListOfTargets.add(targetCharacter);
		
		testCharacter.setTargets(arrayListOfTargets);
		
		System.out.println("the target Character Health before the attak is : " + 
							testCharacter.getState().getStat(Stat.HEALTH));
		
		darkOrb.applyAbility(arrayListOfTargets);
		
		System.out.println("the target Character Health after the attak is : " + 
				testCharacter.getState().getStat(Stat.HEALTH));
		
		
		
	}

}
