// Creating factory to pump orcs out

package loyal.Battle.Characters;

import java.util.Scanner;

import loyal.Battle.Characters.State.Stat;

public class Orc extends BadGuys{
	Orc orc = new Orc();
	private Stat stat;
	
	private void SetStats(){
		State orcState = orc.getState();
		orcState.setStat(stat.HEALTH, 10);
		orcState.setStat(stat.MANA, 10);
		orcState.setStat(stat.STRENGTH, 10);
		orcState.setStat(stat.MAGICPOWER, 5);
		orcState.setStat(stat.ARMOR, 20);
		orcState.setStat(stat.MAGICRESIST, 10);
		orcState.setStat(stat.LEVEL, 5);
	}
	
	@Override
	public void Interaction(PlayingCharacter sources, PlayingCharacter[] targets) {
		int choice = Menu();
		if (choice == 1)
			Attack(sources, targets);
		else if (choice == 2)
			Magic(sources, targets);
		else if (choice == 3)
			Special(sources, targets);
		else if (choice == 4)
			Inventory(sources, targets);
		else
			Flee();
	}
	
	private int Menu() {
		System.out.println("1. Attack\n"
				+ "2. Magic attack\n"
				+ "3. Special attack\n"
				+ "4. Inventory\n"
				+ "5. Flee");
		
		Scanner kb = new Scanner(System.in);
		int choice;
		
		do
		{
			choice = kb.nextInt();
		} while (choice > 5 || choice < 1);
		
		return choice;
	}
	
	private void Inventory(PlayingCharacter sources, PlayingCharacter[] targets) {
		// TODO Auto-generated method stub
		
	}

	private void Special(PlayingCharacter sources, PlayingCharacter[] targets) {
		// TODO Auto-generated method stub
		
	}

	private void Magic(PlayingCharacter sources, PlayingCharacter[] targets) {
		// TODO Auto-generated method stub
		
	}

	private void Attack(PlayingCharacter sources, PlayingCharacter[] targets) {
		// TODO Auto-generated method stub
		
	}
	
	private void Flee(){
		//depends on if we want there to be a chance of flee or not
	}
	
}