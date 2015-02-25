package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public class DarkMage extends BadGuys{
	DarkMage darkMage = new DarkMage();
	private Stat stat;
	
	private void SetStats(){
		State darkMageState = darkMage.getState();
		darkMageState.setStat(stat.HEALTH, 30);
		darkMageState.setStat(stat.MANA, 50);
		darkMageState.setStat(stat.STRENGTH, 5);
		darkMageState.setStat(stat.MAGICPOWER, 15);
		darkMageState.setStat(stat.ARMOR, 10);
		darkMageState.setStat(stat.MAGICRESIST, 20);
		darkMageState.setStat(stat.LEVEL, 10);
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
		
		State darkMageState = darkMage.getState();
		darkMageState.setStat(stat.MANA, mana = mana - 4);
		
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