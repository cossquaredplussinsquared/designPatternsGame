package loyal.entities;

import loyal.level.Level;
import loyal.level.tiles.Tile;

public abstract class Mob extends Entity
{
	protected String name;
	protected int speed;
	protected int numSteps = 0;
	protected boolean isMoving;
	protected int movingDir = 1;
	protected int scale = 1;
	protected int position = 1;
	protected int direction = 0;
	protected boolean isSwimming = false;
	protected boolean tallGrass = false;
	int walkingSpeed = 4;

	public Mob(Level level, String name, int x, int y, int speed)
	{
		super(level);
		this.name = name;
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	
	public void move(int xa, int ya)
	{
		if(xa != 0 && ya != 0)
		{
			move(xa, 0);
			move(0, ya);
			numSteps--;
			return;
		}
		numSteps++;
		
		if(!hasCollided(xa, ya))
		{
			if(ya < 0)
			{
				movingDir = 0;
			}
			if(ya > 0)
			{
				movingDir = 1;
			}
			if(xa < 0)
			{
				movingDir = 2;
			}
			if(xa > 0)
			{
				movingDir = 3;
			}
			
			x += xa*speed;
			y += ya*speed;
			position = position+direction;
		}
	}
	
	
	public abstract boolean hasCollided(int xa, int ya);
	
	protected boolean isSolidTile(int xa, int ya, int x, int y)
	{
		if(level == null)
		{
			return false;
		}
		
		Tile lastTile = level.getTile((this.x + x) >> 3, (this.y + y) >> 3);
		Tile newTile = level.getTile((this.x + x + xa) >> 3, (this.y + y + ya) >> 3);
		
		if(!lastTile.equals(newTile) && newTile.isSolid())
		{
			return true;
		}
		return false;
	}
	
	protected boolean isWater(int xa, int ya, int x, int y)
	{
		if(level == null)
		{
			return false;
		}
		
		Tile lastTile = level.getTile((this.x + x) >> 3, (this.y + y) >> 3);
		Tile newTile = level.getTile((this.x + x + xa) >> 3, (this.y + y + ya) >> 3);
		
		if(!lastTile.equals(newTile) && newTile.getId() == 3)
		{
			return true;
		}
		return false;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void tileCheck()
	{
		if(level.getTile(this.x>>3, this.y>>3).getId() == 3)
		{
			isSwimming = true;
		}
		if(isSwimming && level.getTile(this.x>>3, this.y>>3).getId() != 3)
		{
			isSwimming = false;
		}
		if(level.getTile(this.x>>3, this.y>>3).getId() == 5)
		{
			tallGrass = true;
		}
		if(tallGrass && level.getTile(this.x>>3, this.y>>3).getId() != 5)
		{
			tallGrass = false;
		}
	}
}
