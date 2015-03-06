package loyal.entities;

public class State
{
	// default state is 1 health nothing else
	private double[] stateArray = {100,10,50,30,50,20,1,10,10};
	
	//Usage is:
	// Stat stat = new Stat();
	// State.setStat(stat.HEALTH, 4);
	// int currentHealth = state.getStat(Stat.HEALTH);
	
	//SPEED is used by the battle control and is the number of turns that the character will be out of play until next turn. 
	
	public enum Stat {
		HEALTH(0), MANA(1), STRENGTH(2), MAGICPOWER(3), DEFENSE(4), MAGICRESIST(5), LEVEL(6), SPEED(7), DEXTERITY(8);

		private int index;

		private Stat(int index) {
			this.index = index;
		}
	}
	
	public void setStat(Stat stat, double someStat)
	{
		stateArray[stat.index] = someStat;
	}
	
	public double getStat(Stat defensiveStat)
	{
		return stateArray[defensiveStat.index];
	}

}