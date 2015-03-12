package loyal.Battle.Characters;

public class CharacterState implements State {
	// default state is 1 health nothing else
	private double[] stateArray = {1,0,0,0,0,0,0,0,0,0};
	
	//Usage is:
	// State.setStat(Stat.HEALTH, 4);
	// int currentHealth = State.getStat(stat.HEALTH);
	
	//SPEED is used by the battle control and is the number of turns that the character will be out of play until next turn. 
	
	public enum Stat {
		HEALTH(0), MANA(1), STRENGTH(2), MAGICPOWER(3), ARMOR(4), MAGICRESIST(5), LEVEL(6), SPEED(7), DEXTERITY(8), DEFENSE(9) ;

		public int index;

		private Stat(int index) {
			this.index = index;
		}
	}
	
	public void setStat(Stat stat, int value){
		stateArray[stat.index] = value;
	}
	
	public double getStat(Stat defensiveStat){
		return stateArray[defensiveStat.index];
	}

	@Override
	public double[] getCurrentStatus() {
		// TODO Auto-generated method stub
		return stateArray;
	}

	@Override
	public State undecorate(String name) {
		return this;
	}

	@Override
	public void setStat(Stat health, double currentHealth) {
		// TODO Auto-generated method stub
		
	}

}
