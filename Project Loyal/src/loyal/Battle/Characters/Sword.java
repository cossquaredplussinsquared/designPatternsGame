package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public class Sword extends ModifyingItem{

	public Sword(State innerState) {
		super(innerState);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State undecorate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unSetModified() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModified() {
		int temp = this.getStat(strength);
		temp = (temp * 1.1);
		setStat(strength, temp);
	}

}
