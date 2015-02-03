package loyal.Battle.Characters;

public abstract class BadGuys extends PlayingCharacter {
	
	// this will have an AI controlling class it will probably need a control interface. 
	// implement as you see fit but look at the PlayingCharacter Class for all of the inherited code/comments
	// NOTE: STATS ARE STORED IN THE STATE CLASS SO WE CAN EASILY PASS IT AROUND.

	@Override
	abstract public void Interaction(PlayingCharacter sources, PlayingCharacter[] targets);

}
