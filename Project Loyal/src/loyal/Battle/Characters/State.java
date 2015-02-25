package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public interface State {

	int getStat(Stat health);

	void setStat(Stat health, int i);
	
	int[] getCurrentStatus();

	State undecorate();

}
