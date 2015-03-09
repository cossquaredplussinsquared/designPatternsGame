
package loyal.entities;

import java.util.ArrayList;

import loyal.InputHandler;
import loyal.LevelGenerator;
import loyal.Loyal;
import loyal.Sound;
import loyal.Graphics.Colors;
import loyal.Graphics.Font;
import loyal.Graphics.Screen;
import loyal.level.Level;

public class pointer extends Mob
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

	public pointer(Level level, String name, int x, int y, InputHandler input, int jump, int start, int end, ArrayList<String> menu, Loyal game)

	{
		super(level, name, x, y, 1);
		this.input = input;
		this.jump = jump;
		this.start = start;
		this.end = end;
		this.game = game;
		for(int i=0;i<menu.size(); i++)
		{
			this.menu.add(menu.get(i));
		}
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
			LevelGenerator generator = LevelGenerator.getLevelGenerator(Level.VILLAGE, entities);
			game.level.music.stop();
			game.level = generator.getLevel();
			MapPlayer player = new MapPlayer(game.level,150,250,this.input, game);
			game.level.addEntity(player);
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
		for(int i=0; i<this.menu.size(); i++)
		{
			Font.render(this.menu.get(i),screen,x+16,start-8+16*i,Colors.get(-1,-1,-1,555),1);
		}
	}

}
