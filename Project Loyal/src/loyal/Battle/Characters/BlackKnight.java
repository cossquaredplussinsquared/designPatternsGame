package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public class BlackKnight extends BadGuys{
	BlackKnight blackKnight = new BlackKnight();
	private Stat stat;// = new Stat();

	private void SetStats(){
		State blackKnightState = blackKnight.getState();
		blackKnightState.setStat(stat.HEALTH, 40);
		blackKnightState.setStat(stat.MANA, 15);
		blackKnightState.setStat(stat.STRENGTH, 20);
		blackKnightState.setStat(stat.MAGICPOWER, 10);
		blackKnightState.setStat(stat.ARMOR, 20);
		blackKnightState.setStat(stat.MAGICRESIST, 10);
		blackKnightState.setStat(stat.LEVEL, 15);
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
		
		State blackKnightState = blackKnight.getState();
		blackKnightState.setStat(stat.MANA, mana = mana - 5);
		
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