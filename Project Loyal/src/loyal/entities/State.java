package loyal.entities;

public class State
{
	// default state is 1 health nothing else
	private int[] stateArray = {1,0,0,0,0,0,0};
	
	//Usage is:
	// Stat stat = new Stat();
	// State.setStat(stat.HEALTH, 4);
	// int currentHealth = State.getStat(stat.HEALTH);
	
	public enum Stat
	{
		HEALTH(0), MANA(1), STRENGTH(2), MAGICPOWER(3), ARMOR(4), MAGICRESIST(5), LEVEL(6);

		private int index;

		private Stat(int index) {
			this.index = index;
		}
	}
	
	public void setStat(int index, int value){
		stateArray[index] = value;
	}
	
	public int getStat(int index){
		return stateArray[index];
	}

}
