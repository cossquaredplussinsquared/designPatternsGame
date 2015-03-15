
package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.entities.CharacterStore;
import loyal.entities.SimpleCharacterFactory;
import loyal.entities.Warrior;
import loyal.entities.Wizzard;

public class Tester
{

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
		
		
		PlayingCharacter hunterCharacter = store.orderCharacter("TestCharacterHunter", CharacterType.HUNTER);
		
		HunterAbilityFactory hunterAbilityFactory = new HunterAbilityFactory();
		
		Ability sharpEye = hunterAbilityFactory.createCharacterAction("sharp eye", hunterCharacter);
		
		hunterCharacter.addAction(sharpEye);
		
		ArrayList<PlayingCharacter> arrayListOfTargets2 = new ArrayList<PlayingCharacter>();
		arrayListOfTargets2.add(hunterCharacter);
		
		sharpEye.applyAbility(arrayListOfTargets2);
		
		
		
		PlayingCharacter WorrierCharacter = store.orderCharacter("Warrior", CharacterType.WARRIOR);
		
		WorrierAbilityFactory warriorFactory = new WorrierAbilityFactory();
		
		PlayingCharacter clericCharacter = store.orderCharacter("cleric", CharacterType.CLERIC);
		
		ArrayList<PlayingCharacter> warriorTargets = new ArrayList<PlayingCharacter>();
		
		warriorTargets.add(clericCharacter);
		warriorTargets.add(testCharacter);
		
		Ability desperateMove = warriorFactory.createCharacterAction("desperate move", WorrierCharacter);
		WorrierCharacter.addAction(desperateMove);
		
		System.out.println("the health of the cleric before attak is:" +
		clericCharacter.getState().getStat(Stat.HEALTH));
		
		System.out.println("the health of the cleric before attak is:" +
				testCharacter.getState().getStat(Stat.HEALTH));
		
		desperateMove.applyAbility(warriorTargets);
		
		System.out.println("the health of the cleric after attak is:" +
				clericCharacter.getState().getStat(Stat.HEALTH));
				
				System.out.println("the health of the cleric after attak is:" +
						testCharacter.getState().getStat(Stat.HEALTH));
		
		
	}

}
