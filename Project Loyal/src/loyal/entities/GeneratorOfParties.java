

package loyal.entities;

import java.lang.Thread.State;
import java.util.ArrayList;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.Battle.Characters.CharacterState.Stat;

public class GeneratorOfParties
{
	private ArrayList<PlayingCharacter> party;
	PlayingCharacter hunter;
	PlayingCharacter warrior;
	PlayingCharacter cleric;
	PlayingCharacter wizzard;
	
	public GeneratorOfParties()
	{
		this.party = new ArrayList<PlayingCharacter>();
		this.hunter = new Hunter("enemy hunter", CharacterType.HUNTER);
		this.warrior = new Warrior("enemy warrior", CharacterType.WARRIOR);
		this.cleric = new Cleric("enemy cleric", CharacterType.CLERIC);
		this.wizzard = new Wizard("enemy wizzard", CharacterType.WIZARD);
	}
	
	public ArrayList<PlayingCharacter> generateParty()
	{
		ArrayList<PlayingCharacter> enemies = new ArrayList<PlayingCharacter>();
		enemies.add(new Hunter("Hunt", CharacterType.HUNTER));
		enemies.add(new Warrior("War", CharacterType.WARRIOR));
		enemies.add(new Cleric("Cle", CharacterType.CLERIC));
		enemies.add(new Wizard("Wiz", CharacterType.WIZARD));
		return enemies;
	}

	public ArrayList<PlayingCharacter> generateEnemyParty() {
		this.party.add(this.hunter);
		this.party.add(this.warrior);
		this.party.add(this.cleric);
		this.party.add(this.wizzard);
		return party;
	}
}
