package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public interface State {

	double getStat(Stat health);

	void setStat(Stat health, double currentHealth);
	
	double[] getCurrentStatus();

	State undecorate(String name);

}
