package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public class Wand extends ModifyingItem{

	private int value = 2;
	private Stat Str = Stat.STRENGTH, MPower = Stat.MAGICPOWER;

	public Wand(State innerState) {
		super(innerState);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void unSetModified() {
		double temp = innerState.getStat(Str);
		if (modifiedStateArray[Str.index] > temp)
			modifiedStateArray[Str.index] = temp;
		temp = innerState.getStat(MPower);
		if (modifiedStateArray[MPower.index] > temp)
			modifiedStateArray[MPower.index] = temp;
	}

	@Override
	public void setModified() {
		modifiedStateArray[Str.index] += value;
		modifiedStateArray[MPower.index] += value;
	}
}
