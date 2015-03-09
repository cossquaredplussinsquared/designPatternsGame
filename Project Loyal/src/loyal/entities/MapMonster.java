package loyal.entities;

import java.util.Random;

import loyal.Graphics.Colors;
import loyal.Graphics.Screen;
import loyal.level.Level;

public class MapMonster extends Mob
{
	private int color = Colors.get(-1, 111, 145, 543);
	private int scale = 1;
	private int tickCount;
	private Random random = new Random();
	private int move = 1;
	
	public MapMonster(Level level, int x, int y, int speed)
	{
		super(level, "Monster", x, y, speed);
	}

	public boolean hasCollided(int xa, int ya)
	{
		int xMin = 1;
		int xMax = 6;
		int yMin = 3;
		int yMax = 7;
		
		for(int x = xMin; x < xMax; x++)
		{
			if(isSolidTile(xa, ya, x, yMin) || isWater(xa, ya, x, yMin))
			{
				return true;
			}
		}
		
		for(int x = xMin; x < xMax; x++)
		{
			if(isSolidTile(xa, ya, x, yMax)|| isWater(xa, ya, x, yMin))
			{
				return true;
			}
		}
		
		for(int y = yMin; y < yMax; y++)
		{
			if(isSolidTile(xa, ya, xMin, y)|| isWater(xa, ya, x, yMin))
			{
				return true;
			}
		}
		
		for(int y = yMin; y < yMax; y++)
		{
			if(isSolidTile(xa, ya, xMax, y)|| isWater(xa, ya, x, yMin))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void tick()
	{
		int xa = 0;
		int ya = 0;
		int change = random.nextInt(100);
		
		if(Math.abs(this.x - level.getEntity(0).getX())<80 && Math.abs(this.y - level.getEntity(0).getY())<80)
		{
			stalk();
		}
		else if(change>95)
		{
			move = random.nextInt(4);
		}
		
		if(move == 0)
		{
			ya--;
		}
		if(move == 1)
		{
			ya++;
		}
		if(move == 2)
		{
			xa--;
		}
		if(move == 3)
		{
			xa++;
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
		
		if(level.getTile(this.x>>3, this.y>>3).getId() == 3)
		{
			isSwimming = true;
		}
		
		tileCheck();
		
		this.tickCount++;
	}
	
	public void stalk()
	{
		if(this.x - level.getEntity(0).getX()>0 && Math.abs(this.x - level.getEntity(0).getX())>Math.abs(this.y - level.getEntity(0).getY()))
		{
			move = 2;
		}
		else if(this.x - level.getEntity(0).getX()<0 && Math.abs(this.x - level.getEntity(0).getX())>Math.abs(this.y - level.getEntity(0).getY()))
		{
			move =3;
		}
		else if(this.y - level.getEntity(0).getY()>0)
		{
			move = 0;
		}
		else if(this.y - level.getEntity(0).getY()<0)
		{
			move =1;
		}
	}

	@Override
	public void render(Screen screen)
	{
		int xTile = 12;
		int yTile = 27;
		int walkingSpeed = 4;
		int flipTop = (numSteps >> walkingSpeed & 1);
		int flipBottom = (numSteps >> walkingSpeed &1);
		
		if(movingDir == 0)
		{
			xTile += 8;
		}
		else if(movingDir == 1)
		{
			xTile += 10;
		}
		else if(movingDir >1)
		{
			xTile += 4 + ((numSteps >> walkingSpeed)&1)*2;
			flipTop = (movingDir -1)%2;
			flipBottom = (movingDir-1)%2;
		}
		
		int modifier = 8*scale;
		int xOffset = x - modifier/2;
		int yOffset = y - modifier/2 - 4;
		
		screen.render(xOffset + (modifier*flipTop), yOffset, xTile+yTile*32, color, flipTop, scale);
		screen.render(xOffset+modifier - (modifier*flipTop), yOffset, xTile+1+yTile*32, color, flipTop, scale);
		
		if(!tallGrass)
		{
			screen.render(xOffset + (modifier*flipBottom), yOffset+modifier, xTile+(yTile+1)*32, color, flipBottom, scale);
			screen.render(xOffset+modifier - (modifier*flipBottom), yOffset+modifier, xTile+1+(yTile+1)*32, color, flipBottom, scale);
		}
	}
}
