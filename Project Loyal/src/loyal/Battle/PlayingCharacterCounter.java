package loyal.Battle;

import loyal.Battle.Characters.CharacterState.Stat;
import loyal.Battle.Characters.PlayingCharacter;

public class PlayingCharacterCounter implements Comparable{
	private PlayingCharacter cur;
	private int turn;
	public PlayingCharacterCounter(PlayingCharacter cur) {
		this.cur = cur;
		this.turn = cur.getState().getStat(Stat.SPEED);
	}
	
	public PlayingCharacter getCharacter(){
		return cur;
	}
	public void decrementTurn(){
		turn--;
	}
	public int getTurn(){
		return turn;
	}
	@Override
	public int compareTo(Object arg0) {
		return turn;
	}
	
}
