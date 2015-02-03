package loyal.entities;

import java.util.ArrayList;

import loyal.entities.State.Stat;

public abstract class PlayingCharacter implements Interactable {
	

	private PlayingCharacter[] targets;
	private ArrayList<CharacterAction> actions;
	private CharacterAction currentAction;
	private State state;
	
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
	
//	use this to cause an action to happen on this target 
//	usage: 
//	basicAttack(PlayingCharacter source, PlayingCharacter[] targets){
//		
//		Stat stat = new Stat();
//		int damage = source.getState().getStat(stat.STRENGTH);
//		
//		for(PlayingCharacter target : targets){
//			target.causeAction(stat.HEALT, stat.ARMOR, damage);
//		}
//}
	public void causeAction(Stat targetStat, Stat defensiveStat, int valueChange){
		int modifiedValue = 0;
		if(defensiveStat == null){
			modifiedValue = valueChange;
		}
		else if(state.getStat(defensiveStat) != 0){
			modifiedValue = valueChange / state.getStat(defensiveStat);
		}
		
		state.setStat(targetStat, state.getStat(targetStat) + modifiedValue);
	}

	// this allows us to remove actions on the fly if something happens (e.g.
	// silenced?)
	public void removeActions(ArrayList<CharacterAction> removedActions) {
		actions.removeAll(removedActions);
	}
	
	public void setAction(CharacterAction action){
		currentAction = action;
	}
}