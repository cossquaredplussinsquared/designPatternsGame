// Creating factory to pump orcs out

package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

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
		
		State orcState = orc.getState();
		orcState.setStat(stat.MANA, mana = mana - 5);
		
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