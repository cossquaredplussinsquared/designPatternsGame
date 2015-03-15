package loyal.level;

import loyal.InputHandler;
import loyal.LevelInitializer;
import loyal.Loyal;
import loyal.entities.MapPlayer;

public class EdgesCollisionDecision implements Decision {

	private Loyal game;
	private int entityWatchedX;
	private int entityWatchedY;
	private Level levelWatched;
	private InputHandler input;

	@Override
	public void update() {
		game.level.music.stop();		
		game.level = LevelInitializer.levels[levelWatched.newLevelIdentifier(entityWatchedX, entityWatchedY)];


		if (!game.level.hasBeenPlayed) {
			MapPlayer player = new MapPlayer(this.game.level, 0, 0,
					this.input, this.game);
			game.level.addEntity(0, player);
		}
		
		game.level.music.loop();

	}

	@Override
	public void setGame(Loyal game) {
		this.game = game;
		sync();
		
		
	}

	@Override
	public void sync() {
		this.levelWatched = game.level;
		this.entityWatchedX = levelWatched.entities.get(0).getX();
		this.entityWatchedY = levelWatched.entities.get(0).getY();
		this.input = game.input;
		
	}
}

