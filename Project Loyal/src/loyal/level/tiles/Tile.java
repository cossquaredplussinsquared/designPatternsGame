<<<<<<< HEAD
package loyal.level.tiles;

import loyal.Graphics.Colors;
import loyal.Graphics.Screen;
import loyal.level.Level;

public abstract class Tile
{

	public static final Tile[] tiles = new Tile[256];
	public static final Tile VOID = new BasicSolidTile(0,0,0, Colors.get(000,-1,-1,-1), 0xFF000000);
	public static final Tile STONE = new BasicSolidTile(1,1,0,Colors.get(-1,333,-1,-1), 0xFF555555);
	public static final Tile GRASS = new BasicTile(2,2,0,Colors.get(-1,131,141,-1), 0xFF00FF00);
	public static final Tile ROAD = new BasicTile(3,5,0,Colors.get(-1,421,300,-1), 0xFFA52A2A);
	
	public static final Tile WATER = new AnimatedTile(4, new int[][]{{0,4},{1,4},{2,4}}, Colors.get(-1, 004, 115, -1), 0xFF0000FF, 500);
	public static final Tile LARGEGRASS = new AnimatedTile(5, new int[][]{{4,4},{6,4}}, Colors.get(-1,131,540,-1), 0xFFFFFF00, 1000);
	
	public static final Tile MOUNTAIN = new BigTile(6, 0xFFFF0000, 2, 2);
	public static final Tile MOUNTAIN1 = new BasicSolidTile(7,0,2,Colors.get(320,131,320,555), 0xFFFF0000);
	public static final Tile MOUNTAIN2 = new BasicSolidTile(8,1,2,Colors.get(320,131,320,555), 0xFFFF0000);
	public static final Tile MOUNTAIN3 = new BasicSolidTile(9,0,3,Colors.get(320,131,320,555), 0xFFFF0000);
	public static final Tile MOUNTAIN4 = new BasicSolidTile(10,1,3,Colors.get(320,131,320,555), 0xFFFF0000);
	
	public static final Tile TREE = new BigTile(11, 0xFF009600, 2, 2);
	public static final Tile TREE1 = new BasicSolidTile(12,2,2,Colors.get(131,040,210,500), 0xFFFF0000);
	public static final Tile TREE2 = new BasicSolidTile(13,3,2,Colors.get(131,040,210,500), 0xFFFF0000);
	public static final Tile TREE3 = new BasicSolidTile(14,2,3,Colors.get(131,040,210,500), 0xFFFF0000);
	public static final Tile TREE4 = new BasicSolidTile(15,3,3,Colors.get(131,040,210,500), 0xFFFF0000);

	protected int id;
	protected boolean solid;
	protected boolean emitter;
	private int levelColor;
	
	public Tile(int id, boolean isSolid, boolean isEmitter, int levelColor)
	{
		this.id = (byte)id;
		if(tiles[id] != null)
		{
			throw new RuntimeException("Duplicate tile id on" + id);
		}
		this.solid = isSolid;
		this.emitter = isEmitter;
		this.levelColor = levelColor;
		tiles[id] = this;
	}
	
	public int getId()
	{
		return id;
	}
	
	public boolean isSolid()
	{
		return solid;
	}
	
	public boolean isEmitter()
	{
		return emitter;
	}
	
	public int getLevelColor()
	{
		return levelColor;
	}
	
	
	public abstract void tick();
	
	public abstract void render(Screen screen, Level level, int x, int y);

}
=======
package loyal.level.tiles;

import loyal.Graphics.Colors;
import loyal.Graphics.Screen;
import loyal.level.Level;

public abstract class Tile
{

	public static final Tile[] tiles = new Tile[256];
	public static final Tile VOID = new BasicSolidTile(0,0,0, Colors.get(000,-1,-1,-1), 0xFF000000);
	public static final Tile STONE = new BasicSolidTile(1,1,0,Colors.get(-1,333,-1,-1), 0xFF555555);
	public static final Tile GRASS = new BasicTile(2,2,0,Colors.get(-1,131,141,-1), 0xFF00FF00);
	public static final Tile WATER = new AnimatedTile(3, new int[][]{{0,4},{1,4},{2,4}}, Colors.get(-1, 004, 115, -1), 0xFF0000FF, 500);

	protected byte id;
	protected boolean solid;
	protected boolean emitter;
	private int levelColor;
	
	public Tile(int id, boolean isSolid, boolean isEmitter, int levelColor)
	{
		this.id = (byte)id;
		if(tiles[id] != null)
		{
			throw new RuntimeException("Duplicate tile id on" + id);
		}
		this.solid = isSolid;
		this.emitter = isEmitter;
		this.levelColor = levelColor;
		tiles[id] = this;
	}
	
	public byte getId()
	{
		return id;
	}
	
	public boolean isSolid()
	{
		return solid;
	}
	
	public boolean isEmitter()
	{
		return emitter;
	}
	
	public int getLevelColor()
	{
		return levelColor;
	}
	
	public abstract void tick();
	
	public abstract void render(Screen screen, Level level, int x, int y);

}
>>>>>>> PaulWorkSpace
