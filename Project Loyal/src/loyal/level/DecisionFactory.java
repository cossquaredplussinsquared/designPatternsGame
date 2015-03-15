package loyal.level;

import loyal.Loyal;

public class DecisionFactory
{
	public static final EnterBattle ENTERBATTLE = new EnterBattle();
	
	private Loyal game;
	
	public DecisionFactory( Loyal game)
	{
		this.game = game;
	}
	
	public void init()
	{
		ENTERBATTLE.setGame(game);
	}

}
