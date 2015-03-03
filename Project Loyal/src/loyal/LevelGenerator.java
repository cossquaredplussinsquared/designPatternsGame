package loyal;

import java.util.ArrayList;

import loyal.entities.Entity;
import loyal.entities.MapPlayer;
import loyal.level.Level;

public class LevelGenerator
{
	static LevelGenerator generator;
	String level;
	ArrayList<Entity> entities;
	
	
	public static LevelGenerator getLevelGenerator(String level, ArrayList<Entity> entities){
		if(generator == null)
			generator = new LevelGenerator();
		generator.setEntity(entities);
		generator.setLevel(level);
		return generator;
	}
	
	private LevelGenerator()
	{
	}
	
	public Level getLevel()
	{
		Level current = new Level(level);
		putEntity(current);
		return current;
	}
	
	public void setLevel(String level)
	{
		this.level = level;
	}
	
	public void setEntity(ArrayList<Entity> entities){
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
