
package loyal.level;

import java.util.ArrayList;

import loyal.entities.Entity;

public class LevelGenerator
{
	static LevelGenerator generator;
	Level level;
	ArrayList<Entity> entities;
	
	
	public static LevelGenerator getLevelGenerator(Level level, ArrayList<Entity> entities)
	{
		if(generator == null)
		{
			generator = new LevelGenerator();
		}
		generator.setEntity(entities);
		generator.setLevel(level);
		return generator;
	}
	
	private LevelGenerator()
	{
	}
	
	public Level getLevel()
	{
		Level current = level;
		putEntity(current);
		return current;
	}
	
	public void setLevel(Level level)
	{
		this.level = level;
	}
	
	public void setEntity(ArrayList<Entity> entities)
	{
		this.entities = entities;
	}
	
	public void putEntity(Level current)
	{
		for(int i=0; i<entities.size(); i++)
		{
			current.addEntity(entities.get(i));
		}
	}
}

