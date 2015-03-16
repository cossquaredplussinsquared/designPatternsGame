package loyal.level;

import loyal.Loyal;

public class DecisionFactory
{
	public static final Decision ENTERBATTLE = new EnterBattle();

	public static final Decision SWITCHBATTLECONTROLLER = new SwitchBattleController();
	
	public static final Decision EDGECOLLISIONDECITION = new EdgesCollisionDecision();

	public static final Decision SWITCHBATTLESTATE = new SwitchBattleState();
	
	private Loyal game;
	
	public DecisionFactory( Loyal game)
	{
		this.game = game;
	}
	
	public void init()
	{
		ENTERBATTLE.setGame(game);
		SWITCHBATTLECONTROLLER.setGame(game);
		EDGECOLLISIONDECITION.setGame(game);
		SWITCHBATTLESTATE.setGame(game);
	}

}
