package loyal.level.tiles;

import loyal.Graphics.Screen;
import loyal.level.Level;

public class BasicTile extends Tile
{
	protected int tileId;
	protected int tileColor;
	int id;

	public BasicTile(int id, int x, int y, int tileColor, int levelColor, int width, int height)
	{
		super(id, false, false, levelColor, width, height);
		this.tileId = x+y*32;
		this.tileColor = tileColor;
		this.id = id;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Screen screen, Level level, int x, int y)
	{
			screen.render(x,y,tileId,tileColor, 0x00, 1);
	}

}
