package loyal.entities;

import java.util.ArrayList;
import java.util.Random;

import loyal.InputHandler;
import loyal.Loyal;
import loyal.Graphics.Colors;
import loyal.Graphics.Screen;
import loyal.level.Level;
import loyal.level.tiles.Tile;

public class MapMoblin extends Mob
{
	private int color = Colors.get(-1, 000, 500, 555);
	private int scale = 1;
	private int tickCount;
	private Random random = new Random();
	protected int move = 1;
	protected int stalkDistance;
	
	public MapMoblin(Level level, int x, int y, int speed, int stalkDistance)
	{
		super(level, "Monster", x, y, speed);
		this.stalkDistance = stalkDistance;
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


	public void tick()
	{
		int xa = 0;
		int ya = 0;
		int change = random.nextInt(100);
		
		if(Math.abs(this.x - level.getEntity(0).getX())<stalkDistance && Math.abs(this.y - level.getEntity(0).getY())<stalkDistance)
		{
			stalk(stalkDistance);
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
	
	public void stalk(int stalkDistance)
	{
		int width = (stalkDistance/4)+1;
		Tile[][] tiles = new Tile[width][width];
		for(int i = 0; i<width; i++)
		{
			for(int j = 0; j<width; j++)
			{
				tiles[i][j] = this.level.getTile((this.x-stalkDistance+(i*8))/8,(this.y-stalkDistance+(i*8))/8);
			}
		}
		
		//move = shortestPath(tiles,width);
		
		
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
	
	public int shortestPath(Tile[][] tiles, int width)
	{
		int xPlayer = level.getEntity(0).getX()/8;
		int yPlayer = level.getEntity(0).getY()/8;
		
		int xMonster = this.x;
		int yMonster = this.x;
		
		int xDistance = xMonster-xPlayer;
		int yDistance = yMonster-yPlayer;
		
		int mid = ((width-1)/2)+1;
		
		int[][] check = new int[width][width];
		check[mid][mid] = 2;
		check[mid+xDistance][mid+yDistance] = 3;
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		int distance = 0;
		int shortest = 100;
		int bestDirection = 0;
		int direction = 0;
		int i = mid;
		int j = mid;
		
		do
		{
			if(direction == 0)
			{
				j--;
			}
			if(direction == 1)
			{
				j++;
			}
			if(direction == 2)
			{
				i--;
			}
			if(direction == 3)
			{
				i++;
			}
			
			path.add(direction);
			
			
		}while(path.size() != 0);
		
		return bestDirection;
	}

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

	@Override
	public String inputRun(InputHandler input) {
		// TODO Auto-generated method stub
		return "";
	}
}
