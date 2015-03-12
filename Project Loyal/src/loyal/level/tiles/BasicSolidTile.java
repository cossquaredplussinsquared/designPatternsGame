package loyal.level.tiles;

public class BasicSolidTile extends BasicTile
{

	public BasicSolidTile(int id, int x, int y, int tileColor, int levelColor, int width, int height)
	{
		super(id, x, y, tileColor, levelColor, width, height);
		this.solid = true;
	}
}
