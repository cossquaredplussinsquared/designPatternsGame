package loyal.entities;

import java.util.Random;

import loyal.InputHandler;
import loyal.Graphics.Colors;
import loyal.Graphics.Screen;
import loyal.Utilitys.AStarTile;
import loyal.level.Decision;
import loyal.level.DecisionFactory;
import loyal.level.Level;
import loyal.level.tiles.Tile;

public class MapMoblin extends Mob
{
	private int color = Colors.get(-1, 000, 500, 555);
	private int scale = 1;
	private Random random = new Random();
	protected int move = 1;
	protected int stalkDistance;
	protected Decision decision;
	
	public MapMoblin(Level level, int x, int y, int speed, int stalkDistance)
	{
		super(level, "Monster", x, y, speed);
		this.stalkDistance = 80;
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
	
	private void intBattle()
	{
		level.currentDecision = DecisionFactory.ENTERBATTLE;
		level.spawnNewBattleLevel(this);
	}
	
	private boolean playerCheck()
	{
		int collisionDistance = 16;
		
		if(this.x - level.getEntity(0).getX() < collisionDistance  && this.y-level.getEntity(0).getY() < collisionDistance)
		{
			//System.out.println("HI");
			return true;
			
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
		else if(change>95 || move==8)
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
		if(move == 4)
		{
			xa--;
			ya--;
		}
		if(move == 5)
		{
			xa--;
			ya++;
		}
		if(move == 6)
		{
			xa++;
			y--;
		}
		if(move == 7)
		{
			xa++;
			y++;
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
		if(playerCheck())
		{
			intBattle();
		}
		
	}
	
	public void stalk(int stalkDistance)
	{
		int width = (stalkDistance/4)+3;
		Tile[][] tiles = new Tile[width][width];
		for(int i = 0; i<width; i++)
		{
			for(int j = 0; j<width; j++)
			{
				tiles[i][j] = this.level.getTile((this.x-4-stalkDistance+(i*8))/8,(this.y-4-stalkDistance+(i*8))/8);
			}
		}
		
		move = Pathfinder(tiles,width);
		
		/*if(this.x - level.getEntity(0).getX()>0 && this.y - level.getEntity(0).getY()>0)
		{
			move = 4;
		}
		else if(this.x - level.getEntity(0).getX()>0 && this.y - level.getEntity(0).getY()<0)
		{
			move = 5;
		}
		else if(this.x - level.getEntity(0).getX()<0 && this.y - level.getEntity(0).getY()>0)
		{
			move = 6;
		}
		else if(this.x - level.getEntity(0).getX()<0 && this.y - level.getEntity(0).getY()<0)
		{
			move = 7;
		}
		else if(this.x - level.getEntity(0).getX()>0)
		{
			move = 2;
		}
		else if(this.x - level.getEntity(0).getX()<0)
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
		}*/
	}
	
	public int Pathfinder(Tile[][] tiles, int width)
	{
		AStarTile[] AStarTiles = new AStarTile[width*width];
		int start = (width*width-1)/2;
		int end = (start+(level.getEntity(0).getX()-this.x)/8+((level.getEntity(0).getY()-this.y)/8)*width);
		int curr = start;
		
		for(int i = 0; i<width; i++)
		{
			for(int j = 0; j<width; j++)
			{
				AStarTiles[j+i*width] = new AStarTile(j+i*width, tiles[j][i].isSolid());
			}
		}
		
		AStarTiles[start].setOpen(true);
		AStarTiles[start].setParent(start);
		
		while(curr != end && curr != -1)
		{
			if(curr-width-1 >=0 && curr-width-1 < width*width && (curr-width-1)%width!=(width-1))
			{
				AStarTiles = pathScoring(curr, curr-width-1, AStarTiles,14,width,end);
			}
			if(curr-width >=0 && curr-width < width*width)
			{
				AStarTiles = pathScoring(curr, curr-width, AStarTiles,10,width,end);
			}
			if(curr-width+1 >=0 && curr-width+1 < width*width && (curr-width+1)%width!=0)
			{
				AStarTiles = pathScoring(curr, curr-width+1, AStarTiles,14,width,end);
			}
			if(curr-1 >=0 && curr-1 < width*width && (curr-1)%width!=(width-1))
			{
				AStarTiles = pathScoring(curr, curr-1, AStarTiles,10,width,end);
			}
			if(curr+1 >=0 && curr+1 < width*width && (curr+1)%width!=0)
			{
				AStarTiles = pathScoring(curr, curr+1, AStarTiles,10,width,end);
			}
			if(curr+width-1 >=0 && curr+width-1 < width*width && (curr+width-1)%width!=(width-1))
			{
				AStarTiles = pathScoring(curr, curr+width-1, AStarTiles,14,width,end);
			}
			if(curr+width >=0 && curr+width < width*width)
			{
				AStarTiles = pathScoring(curr, curr+width, AStarTiles,10,width,end);
			}
			if(curr+width+1 >=0 && curr+width+1 < width*width && (curr+width+1)%width!=0)
			{
				AStarTiles = pathScoring(curr, curr+width+1, AStarTiles,14,width,end);
			}
				
			AStarTiles[curr].setOpen(false);
			AStarTiles[curr].setClosed(true);
			curr = lowestScore(AStarTiles, curr, width, end);
		}
		if(curr != -1)
		{
			while(AStarTiles[AStarTiles[curr].getParent()].getId() != start)
			{
				curr = AStarTiles[AStarTiles[curr].getParent()].getId();
			}
		}
		else
		{
			System.out.println("it me");
		}
		
		if(curr == start-width-1)
		{
			return 4;
		}
		if(curr == start-width)
		{
			return 0;
		}
		if(curr == start-width+1)
		{
			return 6;
		}
		if(curr == start-1)
		{
			return 2;
		}
		if(curr == start+1)
		{
			return 3;
		}
		if(curr == start+width-1)
		{
			return 5;
		}
		if(curr == start+width)
		{
			return 1;
		}
		if(curr == start+width+1)
		{
			return 7;
		}
		
		return 8;
	}
	
	public AStarTile[] pathScoring(int curr, int tile, AStarTile[] AStarTiles,int distance,int width,int end)
	{
		if(AStarTiles[tile].isSolid() == false && AStarTiles[tile].isClosed() == false)
		{
			if(AStarTiles[tile].isOpen() == true && AStarTiles[tile].getDistance() < AStarTiles[curr].getDistance()+distance)
			{
				
			}
			else
			{
				AStarTiles[tile].setOpen(true);
				AStarTiles[tile].setParent(curr);
				AStarTiles[tile].setDistance(distance);
				AStarTiles[tile].setHuristic((Math.abs(end%width-tile%width)+Math.abs(end/width-tile/width))*10);
				AStarTiles[tile].setScore(distance+AStarTiles[tile].getHuristic());
			}
		}
		return AStarTiles;
	}
	
	public int lowestScore(AStarTile[] AStarTiles, int curr, int width, int end)
	{
		AStarTile next = new AStarTile(-1,false);
		next.setScore(width*width*width*width);
		if((curr-width-1 >=0 && curr-width-1 < width*width) && AStarTiles[curr-width-1].isSolid() == false && AStarTiles[curr-width-1].isClosed() == false && (curr-width-1)%width!=(width-1))
		{
			next = AStarTiles[curr-width-1];
		}
		if(curr-width >=0 && curr-width < width*width && AStarTiles[curr-width].isSolid() == false && AStarTiles[curr-width].isClosed() == false && AStarTiles[curr-width].getScore() < next.getScore())
		{
			next = AStarTiles[curr-width];
		}
		if(curr-width+1 >=0 && curr-width+1 < width*width && AStarTiles[curr-width+1].isSolid() == false && AStarTiles[curr-width+1].isClosed() == false && (curr-width+1)%width!=0 && AStarTiles[curr-width+1].getScore() < next.getScore())
		{
			next = AStarTiles[curr-width+1];
		}
		if(curr-1 >=0 && curr-1 < width*width && AStarTiles[curr-1].isSolid() == false && AStarTiles[curr-1].isClosed() == false && (curr-1)%width!=(width-1) && AStarTiles[curr-1].getScore() < next.getScore())
		{
			next = AStarTiles[curr-1];
		}
		if(curr+1 >=0 && curr+1 < width*width && AStarTiles[curr+1].isSolid() == false && AStarTiles[curr+1].isClosed() == false && (curr+1)%width!=0 && AStarTiles[curr+1].getScore() < next.getScore())
		{
			next = AStarTiles[curr+1];
		}
		if(curr+width-1 >=0 && curr+width-1 < width*width && AStarTiles[curr+width-1].isSolid() == false && AStarTiles[curr+width-1].isClosed() == false && (curr+width-1)%width!=(width-1) && AStarTiles[curr+width-1].getScore() < next.getScore())
		{
			next = AStarTiles[curr+width-1];
		}
		if(curr+width >=0 && curr+width < width*width && AStarTiles[curr+width].isSolid() == false && AStarTiles[curr+width].isClosed() == false && AStarTiles[curr+width].getScore() < next.getScore())
		{
			next = AStarTiles[curr+width];
		}
		if(curr+width+1 >=0 && curr+width+1 < width*width && AStarTiles[curr+width+1].isSolid() == false && AStarTiles[curr+width+1].isClosed() == false  && (curr+width+1)%width!=0 && AStarTiles[curr+width+1].getScore() < next.getScore())
		{
			next = AStarTiles[curr+width+1];
		}
		return next.getId();
	}

	public void render(Screen screen)
	{
		int xTile = 12;
		int yTile = 27;
		walkingSpeed = 4;
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
