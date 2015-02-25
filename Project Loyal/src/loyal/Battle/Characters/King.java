// Creating singleton to make one Bad King Final Boss

package loyal.Battle.Characters;

import java.util.Scanner;

import loyal.Battle.Characters.State.Stat;

public class King extends BadGuys{
	King king = new King();
	private Stat stat;
	
	private void SetStats(){
		State kingState = king.getState();
		kingState.setStat(stat.HEALTH, 45);
		kingState.setStat(stat.MANA, 20);
		kingState.setStat(stat.STRENGTH, 15);
		kingState.setStat(stat.MAGICPOWER, 20);
		kingState.setStat(stat.ARMOR, 30);
		kingState.setStat(stat.MAGICRESIST, 10);
		kingState.setStat(stat.LEVEL, 20);
	}

	@Override
	public void Interaction(PlayingCharacter sources, PlayingCharacter[] targets) {
		// TODO Auto-generated method stub
		
	}
	
	private void basicAttack(PlayingCharacter source, PlayingCharacter[] targets){
		int damage = source.getState().getStat(stat.STRENGTH);
		
		for(PlayingCharacter target : targets){
			target.causeAction(stat.HEALTH, stat.ARMOR, damage);
		}
	}
	
	private void magicAttack(PlayingCharacter source, PlayingCharacter[] targets){
		int damage = source.getState().getStat(stat.MAGICPOWER), mana = source.getState().getStat(stat.MANA);
		
		State kingState = king.getState();
		kingState.setStat(stat.MANA, mana = mana - 4);
		
		for(PlayingCharacter target : targets){
			target.causeAction(stat.HEALTH, stat.MAGICRESIST, damage);
		}
	}
	
	//dependent on if we do potion heal or character heal
/*	private void heal(PlayingCharacter source, PlayingCharacter[] targets){
		int damage = source.getState().getStat(stat.STRENGTH);
		
		for(PlayingCharacter target : targets){
			target.causeAction(stat.HEALTH, stat.ARMOR, damage);
		}
	}*/
	
	private void strongAttack(PlayingCharacter source, PlayingCharacter[] targets){
		int damage = source.getState().getStat(stat.STRENGTH) * 2;
		
		for(PlayingCharacter target : targets){
			target.causeAction(stat.HEALTH, stat.ARMOR, damage);
		}
	}
}
