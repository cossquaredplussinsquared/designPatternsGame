
package loyal.entities;


import java.util.ArrayList;

import loyal.InputHandler;
import loyal.Loyal;
import loyal.Sound;
import loyal.Graphics.Colors;
import loyal.Graphics.Font;
import loyal.Graphics.Screen;
import loyal.MenuItems.MenuItem;
import loyal.level.Level;
import loyal.level.LevelGenerator;

public class Pointer extends Mob
{
	private InputHandler input;
	private int color = Colors.get(-1, -1, -1, 555);
	private int scale = 1;
	private int tickCount = 0;
	private long time = 0;
	private long curTime;
	private long prevTime = System.currentTimeMillis();
	private int jump;
	private int start;
	private int end;
	private Loyal game;
	private ArrayList<String> menu = new ArrayList<String>();


	public Pointer(Level level, String name, int x, int y, InputHandler input, int jump, int start, int end, Loyal game)

	{
		super(level, name, x, y, 1);
		this.input = input;
		this.jump = jump;
		this.start = start;
		this.end = end;
		this.game = game;
	}

	public boolean hasCollided(int xa, int ya)
	{
		if(y+ya<this.start || y+ya>this.end)
		{
			return true;
		}
		return false;
	}

	public void tick()
	{
		curTime = System.currentTimeMillis();
		time = curTime-prevTime;
		if(time > 100 )
		{
			int xa = 0;
			int ya = 0;
		
			if(input.up.isPressed())
			{
				ya = ya - jump;
				direction++;
			}
			if(input.down.isPressed())
			{
				ya = ya + jump;
				direction--;
			}
			if(input.enter.isPressed())
			{
				newGeneration();
			}
		
			if(xa != 0 || ya != 0)
			{
				move(xa, ya);
				isMoving = true;
			}
			else
			{
				isMoving = false;
			}
			prevTime = System.currentTimeMillis();
		}
		direction=0;
		tickCount++;
	}
	
	public void newGeneration()
	{
		if(position == 1)
		{
			ArrayList<Entity> entities = new ArrayList<Entity>();
			LevelGenerator generator = LevelGenerator.getLevelGenerator(game.VILLAGE, entities);
			game.level.music.stop();
			game.level = generator.getLevel();
			MapPlayer player = new MapPlayer(game.level,150,250,this.input, game);
			NPCMen NPC1 = new NPCMen(game.level, 250,250, 1);
			NPCMen NPC2 = new NPCMen(game.level, 20,20, 1);
			NPCMen NPC3 = new NPCMen(game.level, 100,500, 1);
			NPCMen NPC4 = new NPCMen(game.level, 700,100, 1);
			NPCMen NPC5 = new NPCMen(game.level, 200,700, 1);
			NPCMen NPC6 = new NPCMen(game.level, 700,300, 1);
			NPCMen NPC7 = new NPCMen(game.level, 300,400, 1);
			NPCMen NPC8 = new NPCMen(game.level, 500,600, 1);
			game.level.addEntity(player);
			game.level.addEntity(NPC1);
			game.level.addEntity(NPC2);
			game.level.addEntity(NPC3);
			game.level.addEntity(NPC4);
			game.level.addEntity(NPC5);
			game.level.addEntity(NPC6);
			game.level.addEntity(NPC7);
			game.level.addEntity(NPC8);
			game.level.music.loop();
		}
	}

	public void render(Screen screen)
	{
		int xTile = 1;
		int yTile = 26;
		
		int modifier = 8*scale;
		int xOffset = x - modifier/2;
		int yOffset = y - modifier/2 - 4;
		
		screen.render(xOffset + modifier, yOffset, xTile+yTile*32, color, 0x00, scale);
		
	}

	@Override
	public String inputRun(InputHandler input) {
		// TODO Auto-generated method stub
		return "";
	}

}
