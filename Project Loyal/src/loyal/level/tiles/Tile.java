package loyal.level.tiles;

import loyal.Graphics.Colors;
import loyal.Graphics.Screen;
import loyal.level.Level;

public abstract class Tile
{

	public static final Tile[] tiles = new Tile[256];
	public static final Tile VOID = new BasicSolidTile(0, 0, 0, Colors.get(000,-1,-1,-1), 0xFF000000,1,1);
	public static final Tile STONE = new BasicSolidTile(1, 1, 0, Colors.get(-1,333,-1,-1), 0xFF555555,1,1);
	public static final Tile GRASS = new BasicTile(2, 2, 0, Colors.get(-1,131,141,-1), 0xFF00FF00,1,1);
	public static final Tile WATER = new AnimatedTile(3, new int[][]{{0,4},{1,4},{2,4}}, Colors.get(-1, 004, 115, -1), 0xFF0000FF, 500,1,1);
	public static final Tile ROAD = new BasicTile(4, 5, 0, Colors.get(-1,300,400,-1), 0xFFA52A2A,1,1);
	public static final Tile WHEAT = new AnimatedTile(5, new int[][]{{3,4},{5,4}}, Colors.get(-1, 131, 550, -1), 0xFFFFFF00, 700,1,1);
	public static final Tile MOUNTAIN1 = new BasicSolidTile(6, 0, 2, Colors.get(020,110,020,555), 0xFFFF0000,2,2);
	public static final Tile MOUNTAIN2 = new BasicSolidTile(7, 1, 2, Colors.get(020,110,020,555), 0xFFFF0000,2,2);
	public static final Tile MOUNTAIN3 = new BasicSolidTile(8, 2, 2, Colors.get(-1,110,020,555), 0xFFFF0000,2,2);
	public static final Tile MOUNTAIN4 = new BasicSolidTile(9, 3, 2, Colors.get(-1,110,020,555), 0xFFFF0000,2,2);
	public static final Tile Tree1 = new BasicSolidTile(10, 4, 2, Colors.get(131,121,110,500), 0xFF009600,2,2);
	public static final Tile Tree2 = new BasicSolidTile(11, 5, 2, Colors.get(131,121,110,500), 0xFF009600,2,2);
	public static final Tile Tree3 = new BasicSolidTile(12, 6, 2, Colors.get(131,121,110,500), 0xFF009600,2,2);
	public static final Tile Tree4 = new BasicSolidTile(13, 7, 2, Colors.get(131,121,110,500), 0xFF009600,2,2);
	public static final Tile HOUSE = new BasicSolidTile(14, 6, 0, Colors.get(-1,311,411,-1), 0xFFD2B48C,1,1);
	public static final Tile ROOF = new BasicSolidTile(15, 1, 0, Colors.get(-1,211,-1,-1), 0xFF310C0C,1,1);
	public static final Tile DOOR = new BasicSolidTile(16, 1, 0, Colors.get(-1,211,-1,-1), 0xFFC73627,1,1);
	public static final Tile DOORNOB = new BasicSolidTile(17, 7, 0, Colors.get(211,-1,-1,555), 0xFFFFA500,1,1);
	public static final Tile Boarder = new BasicSolidTile(18, 1, 0, Colors.get(-1,444,-1,-1), 0xFFc8c8c8,1,1);

	protected byte id;
	protected boolean solid;
	protected boolean emitter;
	private int levelColor;
	protected boolean isBig = false;
	protected int width;
	protected int height;
	
	public Tile(int id, boolean isSolid, boolean isEmitter, int levelColor, int width, int height)
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
		this.width = width;
		this.height = height;
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
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public abstract void tick();
	
	public abstract void render(Screen screen, Level level, int x, int y);

}
