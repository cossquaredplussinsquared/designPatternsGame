package loyal.entities;

import java.util.ArrayList;

import loyal.InputHandler;
<<<<<<< HEAD
import loyal.Loyal;
=======
>>>>>>> PaulWorkSpace
import loyal.Graphics.Colors;
import loyal.Graphics.Font;
import loyal.Graphics.Screen;
import loyal.level.Level;

public class pointer extends Mob
{
	private InputHandler input;
	private int color = Colors.get(-1, -1, -1, 555);
	private int scale = 1;
	private int tickCount;
	private int jump;
	private int start;
	private int end;
	private ArrayList<String> menu = new ArrayList();
<<<<<<< HEAD
	private Screen screen;

	public pointer(Level level, String name, int x, int y, InputHandler input, int jump, int start, int end, ArrayList<String> menu, Screen screen)
=======

	public pointer(Level level, String name, int x, int y, InputHandler input, int jump, int start, int end, ArrayList<String> menu)
>>>>>>> PaulWorkSpace
	{
		super(level, name, x, y, 1);
		this.input = input;
		this.jump = jump;
		this.start = start;
		this.end = end;
		for(int i=0;i<menu.size(); i++)
		{
			this.menu.add(menu.get(i));
		}
<<<<<<< HEAD
		this.screen = screen;
=======
>>>>>>> PaulWorkSpace
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
		int xa = 0;
		int ya = 0;
		
		if(input.up.isPressed())
		{
			ya = ya - jump;
		}
		if(input.down.isPressed())
		{
			ya = ya + jump;
		}
		
<<<<<<< HEAD
		if(input.right.isPressed())
=======
		if(input.enter.isPressed())
>>>>>>> PaulWorkSpace
		{
			
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
		
		tickCount++;
	}

	public void render(Screen screen)
	{
		int xTile = 1;
		int yTile = 26;
		int walkingSpeed = 1;
		
		
		int modifier = 8*scale;
		int xOffset = x - modifier/2;
		int yOffset = y - modifier/2 - 4;
		
		screen.render(xOffset + modifier, yOffset, xTile+yTile*32, color, 0x00, scale);
		for(int i=0; i<this.menu.size(); i++)
		{
<<<<<<< HEAD
			Font.render(this.menu.get(i),screen,x+16,start-8+8*i,Colors.get(-1,-1,-1,555),1);
=======
			Font.render(this.menu.get(i),screen,x+16,start-8+16*i,Colors.get(-1,-1,-1,555),1);
>>>>>>> PaulWorkSpace
		}
	}

}
