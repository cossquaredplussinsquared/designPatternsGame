
package loyal.Battle;

import java.util.ArrayList;

import loyal.Battle.Characters.PlayingCharacter;

public class Party {
	
	ArrayList<String> inventory;
	ArrayList<PlayingCharacter> players, activePlayers;
	
	public Party(ArrayList<PlayingCharacter> activePlayers)
	{
		this.activePlayers = activePlayers;
	}
	
	private void addItem(String item)
	{
		inventory.add(item);
	}
	
	private void removeItem(String item)
	{
		inventory.remove(item);
	}
	
	public int countParty()
	{
		int count = 0;
		for (PlayingCharacter p: players)
			count++;
		
		return count;
	}

}

