package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.entities.CharacterStore;
import loyal.entities.SimpleCharacterFactory;
import loyal.entities.Warrior;
import loyal.entities.Wizzard;

public class Tester {

	public static void main(String[] args)
	{
		SimpleCharacterFactory factory;
		
		CharacterStore store;
		
		factory = new SimpleCharacterFactory();
		
		store = new CharacterStore(factory);
		
		PlayingCharacter testCharacter = store.orderCharacter("TestCharacterSorcer", CharacterType.WIZZARD);
		
		PlayingCharacter targetCharacter = store.orderCharacter("TestCharacterWarrior", CharacterType.WARRIOR);
		
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
				targetCharacter.getState().getStat(Stat.HEALTH));
		
		//printing the the abilities for the wizzard class
		
		String [] wizzardAbilities = wizzardAbilityFactory.displayAbilitiesBasedOnType();
		
		for(int i = 0; i < wizzardAbilities.length; i++)
		{
			System.out.println(wizzardAbilities[i]);
		}
		
		
		
	}

}
