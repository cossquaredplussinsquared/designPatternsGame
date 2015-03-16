package loyal.entities;

import java.lang.Thread.State;
import java.util.ArrayList;

import loyal.Battle.Actions.Ability;
import loyal.Battle.Actions.HunterAbilityFactory;
import loyal.Battle.Actions.WarriorAbilityFactory;
import loyal.Battle.Actions.WizardAbilityFactory;
import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.Battle.Characters.CharacterState.Stat;

public class GeneratorOfParties {
	private ArrayList<PlayingCharacter> party, enemy;
	PlayingCharacter hunter;
	PlayingCharacter warrior;
	PlayingCharacter cleric;
	PlayingCharacter wizard;


	public GeneratorOfParties() {
		this.party = new ArrayList<PlayingCharacter>();
		this.enemy = new ArrayList<PlayingCharacter>();
	}

	public ArrayList<PlayingCharacter> generateParty() {
		
		
		
		if (party.isEmpty())
		{
			party.add(new Hunter("Hunt", CharacterType.HUNTER));
			party.add(new Warrior("War", CharacterType.WARRIOR));
			party.add(new Cleric("Cler", CharacterType.CLERIC));
			party.add(new Wizard("Wiz", CharacterType.WIZZARD));
		}

		return this.party;
	}
	
	public ArrayList<PlayingCharacter> generateEnemyParty(){
		if (enemy.isEmpty())
		{
			enemy.add( genPlayer("enemy hunter", CharacterType.HUNTER));
			enemy.add( genPlayer("enemy warrior", CharacterType.WARRIOR));
			enemy.add( genPlayer("enemy cleric", CharacterType.CLERIC));
			enemy.add( genPlayer("enemy wizard", CharacterType.WIZZARD));
		}
		return this.enemy;
		
		
	}
	
	private PlayingCharacter genPlayer(String name, CharacterType charT){
		SimpleCharacterFactory factory;
		
		CharacterStore store;
		
		factory = new SimpleCharacterFactory();
		
		store = new CharacterStore(factory);
		
		PlayingCharacter play = store.orderCharacter(name, charT);
		
//		switch(charT){
//		case HUNTER:
//			HunterAbilityFactory huntFact = new HunterAbilityFactory();
//			Ability hunt1 = huntFact.createCharacterAction("sharp shot", play);
//			Ability hunt2 = huntFact.createCharacterAction("arrow rain", play);
//			Ability hunt3 = huntFact.createCharacterAction("sharp eye", play);
//			Ability hunt4 = huntFact.createCharacterAction("poisonous stab", play);
//			play.addAction(hunt1);
//			play.addAction(hunt2);
//			play.addAction(hunt3);
//			play.addAction(hunt4);
//			break;
//		case WARRIOR:
//			WarriorAbilityFactory warFact = new WarriorAbilityFactory();
//			Ability war1 = warFact.createCharacterAction("air slash", play);
//			Ability war2 = warFact.createCharacterAction("back slash", play);
//			Ability war3 = warFact.createCharacterAction("taunt", play);
//			Ability war4 = warFact.createCharacterAction("desperate move", play);
//			play.addAction(war1);
//			play.addAction(war2);
//			play.addAction(war3);
//			play.addAction(war4);
//			break;
//		case CLERIC:
//		case WIZZARD:
//			WizardAbilityFactory wizzardAbilityFactory = new WizardAbilityFactory();
//			Ability darkOrb = wizzardAbilityFactory.createCharacterAction("dark orb", play);
//			play.addAction(darkOrb);
//			break;
//		}
		
		return play;
	}
}
