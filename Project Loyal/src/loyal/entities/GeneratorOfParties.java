package loyal.entities;

import java.lang.Thread.State;
import java.util.ArrayList;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.Battle.Characters.CharacterState.Stat;

public class GeneratorOfParties {
	static private ArrayList<PlayingCharacter> party, enemy;
	PlayingCharacter hunter;
	PlayingCharacter warrior;
	PlayingCharacter cleric;
	PlayingCharacter wizard;


	public GeneratorOfParties() {
		this.party = new ArrayList<PlayingCharacter>();
		this.enemy = new ArrayList<PlayingCharacter>();
	}

	public ArrayList<PlayingCharacter> generateParty() {
		if (this.party == null) {
			this.hunter = new Hunter("Hunt", CharacterType.HUNTER);
			this.warrior = new Warrior("War", CharacterType.WARRIOR);
			this.cleric = new Cleric("Cler", CharacterType.CLERIC);
			this.wizard = new Wizard("Wiz", CharacterType.WIZZARD);
			this.party.add(this.hunter);
			this.party.add(this.warrior);
			this.party.add(this.cleric);
			this.party.add(this.wizard);
		}
		return party;
	}
	
	public ArrayList<PlayingCharacter> generateEnemyParty(){
		enemy.add( new Hunter("enemy hunter", CharacterType.HUNTER));
		enemy.add( new Warrior("enemy warrior", CharacterType.WARRIOR));
		enemy.add( new Cleric("enemy cleric", CharacterType.CLERIC));
		enemy.add(  new Wizard("enemy wizard", CharacterType.WIZZARD));
		return this.enemy;
		
		
	}
}
