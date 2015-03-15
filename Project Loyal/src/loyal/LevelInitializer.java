package loyal;

import java.util.ArrayList;
import java.util.Random;

import loyal.entities.Entity;
import loyal.entities.MapMoblin;
import loyal.entities.MapPlayer;
import loyal.entities.MenuItems;
import loyal.entities.NPCMen;
import loyal.entities.Pointer;
import loyal.level.Level;
import loyal.level.tiles.Tile;

public class LevelInitializer {
	public static final Level[] levels = new Level[100];
	public static final Level VILLAGE = new Level(1, "/Levels/HomeVillage.png",
			Sound.VillageMusic);
	public static final Level OVERWORLD = new Level(2,
			"/Levels/OverWorldMap.png", Sound.OverWorldMusic);
	public static final Level STARTMENU = new Level(3, "/Levels/test_menu.png",
			Sound.MenuMusic);
	
	public static final Level BATTLE = new Level(4, "/Levels/BattleMap.png", Sound.BattleMusic);

	private Loyal game;

	public LevelInitializer(Loyal game) {
		this.game = game;

	}

	public void initLeveValues() {
		// this allows us to decide the exit points in one array rather than
		// multiple arrays values are id, xMin, xMax, yMin, yMax
		ArrayList<int[]> villageExitValues = new ArrayList<int[]>();
		villageExitValues.add(new int[] { 2, 99, 100, 0, 100 });

		ArrayList<int[]> overworldExitValues = new ArrayList<int[]>();
		overworldExitValues.add(new int[] { 1, 0, 0, 0, 100 });

		// Sets the values for change map conditions.
		VILLAGE.setExitValues(villageExitValues);
		OVERWORLD.setExitValues(overworldExitValues);

		// sets default player X and Y
		OVERWORLD.setPlayerDefaultX(8);
		OVERWORLD.setPlayerDefaultY(320);
		
		VILLAGE.setPlayerDefaultX(150);
		VILLAGE.setPlayerDefaultY(250);
		
		game.level = STARTMENU;
		startMenuCreation();
		addMonsters();
		villageNPCCreation();
	}
	
	private void addMonsters()
	{
		Random random = new Random();
		
		int MonsterX = random.nextInt(399);
		int MonsterY = random.nextInt(399);
		for(int i = 0; i<100; i++)
		{
			Tile tile = OVERWORLD.getTile(MonsterX,MonsterY);
			while(tile.isSolid()==true || OVERWORLD.tiles[MonsterX+MonsterY*OVERWORLD.width] == 3)
			{
				MonsterX = random.nextInt(399);
				MonsterY = random.nextInt(399);
				tile = OVERWORLD.getTile(MonsterX,MonsterY);
			}
			MapMoblin monster = new MapMoblin(OVERWORLD, MonsterX*8, MonsterY*8, 1, 64);
			OVERWORLD.addEntity(monster);
			MonsterX = random.nextInt(399);
			MonsterY = random.nextInt(399);
		}
	}

	private void startMenuCreation() {
		ArrayList<String> menuItems = new ArrayList<String>();
		menuItems.add("Start");
		menuItems.add("Load");
		menuItems.add("Option");
		menuItems.add("Quit");


		Entity player = new Pointer(game.level, "pointer", 20, 100, 16, 100, 148,
				game);
		Entity menu = new MenuItems(game.level, menuItems, 100);
		game.level.addEntity(player);
		game.level.addEntity(menu);
		
		
		game.level.music.loop();
	}
	
	private void villageNPCCreation(){
		MapPlayer player = new MapPlayer(VILLAGE,0,0,game.input, game);
		NPCMen NPC1 = new NPCMen(VILLAGE, 250,250, 1);
		NPCMen NPC2 = new NPCMen(VILLAGE, 20,20, 1);
		NPCMen NPC3 = new NPCMen(VILLAGE, 100,500, 1);
		NPCMen NPC4 = new NPCMen(VILLAGE, 700,100, 1);
		NPCMen NPC5 = new NPCMen(VILLAGE, 200,700, 1);
		NPCMen NPC6 = new NPCMen(VILLAGE, 700,300, 1);
		NPCMen NPC7 = new NPCMen(VILLAGE, 300,400, 1);
		NPCMen NPC8 = new NPCMen(VILLAGE, 500,600, 1);
		VILLAGE.addEntity(0,player);
		VILLAGE.addEntity(NPC1);
		VILLAGE.addEntity(NPC2);
		VILLAGE.addEntity(NPC3);
		VILLAGE.addEntity(NPC4);
		VILLAGE.addEntity(NPC5);
		VILLAGE.addEntity(NPC6);
		VILLAGE.addEntity(NPC7);
		VILLAGE.addEntity(NPC8);
	}

}
