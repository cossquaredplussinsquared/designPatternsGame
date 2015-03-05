package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public class Arms extends ModifyingItem{
	private int value = 2;
	private Stat Heal = Stat.HEALTH, Man = Stat.MANA, Str = Stat.STRENGTH, 
			MPower = Stat.MAGICPOWER, Arm = Stat.ARMOR, MResist = Stat.MAGICRESIST;
	
	public Arms(State innerState) {
		super(innerState);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void unSetModified() {
		int temp = innerState.getStat(Heal);
		if (modifiedStateArray[Heal.index] > temp)
			modifiedStateArray[Heal.index] = temp;
		else if (modifiedStateArray[Heal.index] - value < 0)
			modifiedStateArray[Heal.index] = 1;
		else
			modifiedStateArray[Heal.index] -= value;
		
		temp = innerState.getStat(Man);
		if (modifiedStateArray[Man.index] > temp)
			modifiedStateArray[Man.index] = temp;
		temp = innerState.getStat(Str);
		if (modifiedStateArray[Str.index] > temp)
			modifiedStateArray[Str.index] = temp;
		temp = innerState.getStat(MPower);
		if (modifiedStateArray[MPower.index] > temp)
			modifiedStateArray[MPower.index] = temp;
		temp = innerState.getStat(Arm);
		if (modifiedStateArray[Arm.index] > temp)
			modifiedStateArray[Arm.index] = temp;
		temp = innerState.getStat(MResist);
		if (modifiedStateArray[MResist.index] > temp)
			modifiedStateArray[MResist.index] = temp;
	}

	@Override
	public void setModified() {
		modifiedStateArray[Heal.index] += value;
		modifiedStateArray[Man.index] += value;
		modifiedStateArray[Str.index] += value;
		modifiedStateArray[MPower.index] += value;
		modifiedStateArray[Arm.index] += value;
		modifiedStateArray[MResist.index] += value;
	}
}
