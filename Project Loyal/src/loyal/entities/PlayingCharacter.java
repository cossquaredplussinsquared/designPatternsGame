package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public class PlayingCharacter 
{
	
	private String name;
	private PlayingCharacter[] targets;
	private ArrayList<CharacterAction> actions;
	private CharacterAction currentAction;
	private ArrayList<PlayingCharacter> allies;
	private State state;
	private CharacterType type;
	
	public PlayingCharacter(String name, CharacterType type)
	{
		this.name = name;
		this.type = type;
	}

	public State getState()
	{
		return state;
	}

	public PlayingCharacter[] getTargets() {
		return targets;
	}

	public void setTargets(PlayingCharacter[] targets) {
		this.targets = targets;
	}

	public ArrayList<CharacterAction> getActions() {
		return actions;
	}

	public void addAction(CharacterAction action) {
		actions.add(action);
	}

	// this allows us to remove actions on the fly if something happens (e.g.
	// silenced?)
	public void removeActions(ArrayList<CharacterAction> removedActions) {
		actions.removeAll(removedActions);
	}
	
	public void setAction(CharacterAction action){
		currentAction = action;
	}
	
	public CharacterType getType()
	{
		return this.type;
	}
	
	public ArrayList<PlayingCharacter> getAllies()
	{
		return this.allies;
	}
	
	public int compareTo(PlayingCharacter pi)
	{
		if(this.name.compareTo(pi.name) == 0)
			return this.getType().compareTo(pi.getType());
		return this.name.compareTo(pi.name);
	}

	public CharacterType getCharacterType()
	{
		return this.type;
	}
	
	public void setType(CharacterType type)
	{
		this.type = type;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public PlayingCharacter[] getTartgets()
	{
		return this.targets;
	}
	
	public boolean isDead()
	{
		return (state.getStat(Stat.HEALTH) <= 0);
	}
}