package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public class Sword extends ModifyingItem{

	private int value = 3;
	private Stat Str = Stat.STRENGTH;

	public Sword(State innerState) {
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
}
