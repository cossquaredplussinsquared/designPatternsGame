package loyal.entities;
import loyal.entities.State;
import loyal.entities.State.Stat;

public class King extends BadGuys{
	King king = new King();

	@Override
	public void Interaction(PlayingCharacter sources, PlayingCharacter[] targets) {
		// TODO Auto-generated method stub
		
	}
	
	private Stat stat;
	private void Stuff(){
		State kingState = king.getState();
		kingState.setStat(stat.HEALTH, 20);
	}
	
}
