package loyal.Battle.Characters;

import loyal.Battle.Characters.CharacterState.Stat;

public abstract class ModifyingItem implements StateDecorator {

	// When you inherit from this just set valueChange and changedStat, if you
	// want to change more stats just add them in and call the
	protected State innerState;
	protected int[] modifiedStateArray;
	protected String name;

	public ModifyingItem(State innerState) {
		this.innerState = innerState;
		setModified();
		this.modifiedStateArray = innerState.getCurrentStatus();
	}

	@Override
	public int getStat(Stat statChoice) {
		return modifiedStateArray[statChoice.index];
	}

	@Override
	public void setStat(Stat statChoice, int value) {
		modifiedStateArray[statChoice.index] = value;
	}

	@Override
	public int[] getCurrentStatus() {
		return modifiedStateArray;
	}

	final public State undecorate(String name) {
		if (this.name.equals(name)) {
			unSetModified();
			return innerState;
		}
		innerState = innerState.undecorate(name);
		return innerState;
	}

}
