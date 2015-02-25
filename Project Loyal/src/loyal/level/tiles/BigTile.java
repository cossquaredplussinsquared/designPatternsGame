package loyal.level.tiles;

import loyal.Graphics.Screen;
import loyal.level.Level;

public class BigTile extends Tile
{
	protected int width;
	protected int height;
	
	public BigTile(int id, int levelColor, int height, int width)
	{
		super(id, false, false, levelColor);
		this.width = width;
		this.height = height;
	}


	
	public void tick()
	{
		
	}

	public void render(Screen screen, Level level, int x, int y)
	{
<<<<<<< HEAD
		int id = this.id;
=======
		byte id = this.id;
>>>>>>> PaulWorkSpace
		for(int i = 0; i<this.height; i++)
		{
			for(int j = 0; j<this.width; j++)
			{
				id++;
				level.tiles[((x-1)/8)+1+j+(((y-1)/8)+1+i)*level.width] = id;
			}
		}
	}
}
