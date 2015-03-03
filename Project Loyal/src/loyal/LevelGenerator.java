package loyal;

import java.util.ArrayList;

import loyal.entities.Entity;
import loyal.entities.MapPlayer;
import loyal.level.Level;

public class LevelGenerator
{
	Level level;
	
	public LevelGenerator(String level, ArrayList<Entity> entities)
	{
		this.level = new Level(level);
		for(int i=0; i<entities.size(); i++)
		{
			entities.get(i).init(this.level);
			this.level.addEntity(entities.get(i));
		}
	}
	
	public Level getLevel()
	{
		return this.level;
	}
	
	public void setLevel(String level)
	{
		this.level = new Level(level);
	}
	
	public void setEntity(ArrayList<Entity> entities)
	{
		for(int i=0; i<entities.size(); i++)
		{
			this.level.addEntity(entities.get(i));
		}
	}
}
