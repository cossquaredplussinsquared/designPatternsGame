package loyal.entities;

import loyal.Graphics.Screen;
import loyal.level.Level;

public abstract class Entity
{
	public int x,y;
	protected Level level;
	
	public Entity(Level level)
	{
		init(level);
	}
	
	
	public final void init(Level level)
	{
		this.level = level;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public abstract void tick();
	public abstract void render(Screen screen);
}
