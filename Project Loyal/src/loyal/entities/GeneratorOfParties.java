
package loyal.entities;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Random;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.Battle.Characters.CharacterState.Stat;

public class GeneratorOfParties
{
	private ArrayList<PlayingCharacter> party;
	private ArrayList<PlayingCharacter> randomEnemyParty;
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
		this.wizzard = new Wizard("enemy wizzard", CharacterType.WIZZARD);
	}
	
	public ArrayList<PlayingCharacter> generateParty()
	{
		this.party = new ArrayList<PlayingCharacter>();
		this.hunter = new Hunter("enemy hunter", CharacterType.HUNTER);
		this.warrior = new Warrior("enemy warrior", CharacterType.WARRIOR);
		this.cleric = new Cleric("enemy cleric", CharacterType.CLERIC);
		this.wizzard = new Wizard("enemy wizzard", CharacterType.WIZZARD);
		this.party.add(this.hunter);
		this.party.add(this.warrior);
		this.party.add(this.cleric);
		this.party.add(this.wizzard);
		return party;
	}

	public ArrayList<PlayingCharacter> generateEnemyParty()
	{
		Random gen = new Random();
		int numberOfEnemmies = gen.nextInt(4);
		this.randomEnemyParty = new ArrayList<PlayingCharacter>();
		
		for(int i = 0; i < numberOfEnemmies; i++)
		{
			int randomClass = gen.nextInt(numberOfEnemmies);
			if(randomClass == 0)
			{
				this.warrior = new Warrior("enemy warrior", CharacterType.WARRIOR);
				this.randomEnemyParty.add(this.warrior);
			}
			else if(randomClass == 1)
			{
				this.wizzard = new Wizard("enemy wizzard", CharacterType.WIZZARD);
				this.randomEnemyParty.add(this.wizzard);
			}
			else if(randomClass == 2)
			{
				this.cleric = new Cleric("enemy cleric", CharacterType.CLERIC);
				this.randomEnemyParty.add(this.cleric);
			}
			
			else if(randomClass == 3)
			{
				this.hunter = new Hunter("enemy hunter", CharacterType.HUNTER);
				this.randomEnemyParty.add(this.hunter);
			}
			else
			{
				System.out.println("there was a problem with picking characters");
				return null;
			}
		}
		
		return this.randomEnemyParty;
	}
}

