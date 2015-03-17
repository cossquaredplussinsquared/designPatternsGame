

package loyal.Battle.Actions;

import java.util.ArrayList;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.entities.CharacterStore;
import loyal.entities.GeneratorOfParties;
import loyal.entities.SimpleCharacterFactory;
import loyal.entities.Warrior;
import loyal.entities.Wizard;

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
		
		WarriorAbilityFactory warriorFactory = new WarriorAbilityFactory();
		
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
		
		System.out.println("the health of the warrior after performing desperate move is: " +
				WorrierCharacter.getState().getStat(Stat.HEALTH));
		
		PlayingCharacter ClericCharacter = store.orderCharacter("Warrior", CharacterType.CLERIC);
		
		ClericAbilityFactory clericAbilityFactory = new ClericAbilityFactory();
		
		Ability lightningSpear = clericAbilityFactory.createCharacterAction("lightning spear", ClericCharacter);
		
		ClericCharacter.addAction(lightningSpear);
		
		ArrayList<PlayingCharacter> ClericTargets = new ArrayList<PlayingCharacter>();
		
		ClericTargets.add(WorrierCharacter);
		
		System.out.println("Warrior health before lightning attack: " + WorrierCharacter.getState().getStat(Stat.HEALTH));
		
		ClericCharacter.getActions().get(0).applyAbility(ClericTargets);
		
		System.out.println("Warrior health after lightning attack: " + WorrierCharacter.getState().getStat(Stat.HEALTH));
		
		GeneratorOfParties partyGenerator = new GeneratorOfParties();
		
		ArrayList<PlayingCharacter> party = partyGenerator.generateParty();
		
		PlayingCharacter warriorCharacter = store.orderCharacter("TestCharacterWarrior", CharacterType.WARRIOR);
		
		
		System.out.println("before desperate move");
		
		for(int i = 0; i < party.size(); i++)
		{
			System.out.println(party.get(i).getName() + " health is: "+ party.get(i).getState().getStat(Stat.HEALTH));
		}
		
		desperateMove.applyAbility(party);
		
		System.out.println("after desperate move");
		
		for(int i = 0; i < party.size(); i++)
		{
			System.out.println(party.get(i).getName() + " health is: "+ party.get(i).getState().getStat(Stat.HEALTH));
		}
		
		System.out.println();
		
		ArrayList<PlayingCharacter> partyThatHasAbilities = partyGenerator.generateParty();
		
		ArrayList<PlayingCharacter> partyThatHasAbilitiesTarget = partyGenerator.generateParty();
		
		for(int i = 0; i < partyThatHasAbilitiesTarget.size(); i++)
		{
			System.out.println(partyThatHasAbilities.get(i).getName() + " health is: "+ partyThatHasAbilitiesTarget.get(i).getState().getStat(Stat.HEALTH));
		}
		
		CharacterAction ability = partyThatHasAbilities.get(0).getActions().get(3);
		ability.applyAbility(partyThatHasAbilitiesTarget);
		
		System.out.println();
		
		for(int i = 0; i < partyThatHasAbilitiesTarget.size(); i++)
		{
			System.out.println(partyThatHasAbilitiesTarget.get(i).getName() + " health is: "+ partyThatHasAbilitiesTarget.get(i).getState().getStat(Stat.HEALTH));
		}
		
		ArrayList<PlayingCharacter> enemyParty = partyGenerator.generateEnemyParty();
		
		CharacterAction ability2 = partyThatHasAbilities.get(1).getActions().get(2);
		
		for(int i = 0; i < enemyParty.size(); i++)
		{
			System.out.println(enemyParty.get(i).getName() + " health is: "+ enemyParty.get(i).getState().getStat(Stat.HEALTH));
		}
		
		ability2.applyAbility(enemyParty);
		
		for(int i = 0; i < enemyParty.size(); i++)
		{
			System.out.println(enemyParty.get(i).getName() + " health is: "+ enemyParty.get(i).getState().getStat(Stat.HEALTH));
		}
		
	}

}

