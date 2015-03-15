package loyal.Battle.Characters;

import java.util.ArrayList;

import loyal.Battle.Actions.CharacterAction;
import loyal.Battle.Characters.CharacterState.Stat;

public abstract class PlayingCharacter 
{
	
	private String name;
	private ArrayList<PlayingCharacter> targets;
	private ArrayList<CharacterAction> actions;
	private CharacterAction currentAction;
	private ArrayList<PlayingCharacter> allies;
	protected State state;
	private CharacterType type;
	
	public PlayingCharacter(String name, CharacterType type)
	{
		this.name = name;
		this.type = type;
		this.actions = new ArrayList<CharacterAction>();
		this.allies = new ArrayList<PlayingCharacter>();
		this.state = new CharacterState();
	}

	public State getState()
	{
		return state;
	}
	
	public void setState(State state)
	{
		this.state = state;
	}

	public ArrayList<PlayingCharacter> getTargets() {
		return targets;
	}

	public void setTargets(ArrayList<PlayingCharacter> targets) {
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
	
	public ArrayList<PlayingCharacter> getTartgets()
	{
		return this.targets;
	}
	
	public boolean isDead()
	{
		return (state.getStat(Stat.HEALTH) <= 0);
	}
}