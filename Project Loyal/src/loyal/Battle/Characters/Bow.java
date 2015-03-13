package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public class Bow extends ModifyingItem{

	private int value = 2;
	private Stat Str = Stat.STRENGTH;

	public Bow(State innerState) {
		super(innerState);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void unSetModified() {
		double temp = innerState.getStat(Str);
		if (modifiedStateArray[Str.index] > temp)
			modifiedStateArray[Str.index] = temp;		
	}

	@Override
	public void setModified() {
		modifiedStateArray[Str.index] += value;
	}

	@Override
	public void setStat(Stat health, double currentHealth) {
		// TODO Auto-generated method stub
		
	}
}
