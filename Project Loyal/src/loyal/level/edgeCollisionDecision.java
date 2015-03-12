package loyal.level;

import java.util.ArrayList;
import java.util.Random;

import loyal.InputHandler;
import loyal.Loyal;
import loyal.entities.Entity;
import loyal.entities.MapMoblin;
import loyal.entities.MapPlayer;
import loyal.level.tiles.Tile;

public class edgeCollisionDecision implements Decision {

	private Loyal game;
	private int entityWatchedX;
	private int entityWatchedY;
	private Level levelWatched;
	private InputHandler input;

	@Override
	public void update() {
		game.level.music.stop();		
		game.level = Loyal.levels[levelWatched.newLevelIdentifier(entityWatchedX, entityWatchedY)];


		if (!game.level.hasBeenPlayed) {
			MapPlayer player = new MapPlayer(this.game.level, 0, 0,
					this.input, this.game);
			game.level.addEntity(0, player);
		}
		
		if(game.level.getEntitySize() == 1 && game.level.getId() == 2)
		{
			addMonsters();
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
	
	public void addMonsters()
	{
		Random random = new Random();
		
		int MonsterX = random.nextInt(399);
		int MonsterY = random.nextInt(399);
		for(int i = 0; i<100; i++)
		{
			Tile tile = game.level.getTile(MonsterX,MonsterY);
			while(tile.isSolid()==true || game.level.tiles[MonsterX+MonsterY*game.level.width] == 3)
			{
				MonsterX = random.nextInt(399);
				MonsterY = random.nextInt(399);
				tile = game.level.getTile(MonsterX,MonsterY);
			}
			MapMoblin monster = new MapMoblin(this.game.level, MonsterX*8, MonsterY*8, 1, 64);
			game.level.addEntity(monster);
			MonsterX = random.nextInt(399);
			MonsterY = random.nextInt(399);
		}
	}
	

}
