package loyal.entities;

import java.util.ArrayList;

public abstract class PlayingCharacter implements Interactable {
	
	private String name;
	private PlayingCharacter[] targets;
	private ArrayList<CharacterAction> actions;
	private CharacterAction currentAction;
	private ArrayList<PlayingCharacter> allies;
	private State state;
	private CharacterType type;
	
	// When you are creating your characters you need to create actions for each
	// of the abilities you want them to have. Those actions are going to be
	// used in the interaction function and will be set by the battle object
	// Ex:
	// BattleObject calls menu and lets you select an action from a list of
	// actions in the PlayingCharacter
	// BattleObject sets the action then calls menu and lets you select from a
	// list of targets from the PlayingCharacter
	// Then calls Interaction with the source as the current character and
	// targets as an array (we can change this to some kind of list also)

	@Override
	abstract public void Interaction(PlayingCharacter sources,
			PlayingCharacter[] targets);

	public State getState(){
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
	
	public String getName()
	{
		return this.name;
	}
}