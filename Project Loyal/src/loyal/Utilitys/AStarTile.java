package loyal.Utilitys;

public class AStarTile
{
	private int id;
	private boolean isSolid;
	private boolean closed;
	private boolean open;
	private int parent;
	private int score;
	private int distance;
	private int huristic;
	
	public AStarTile(int id, boolean isSolid)
	{
		this.id = id;
		this.isSolid = isSolid;
		if(this.isSolid)
		this.closed = false;
		this.open = false;
		this.parent = -1;
		this.score = 0;
		this.distance = 0;
		this.huristic = 0;
	}
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public boolean isSolid()
	{
		return isSolid;
	}

	public void setSolid(boolean isSolid)
	{
		this.isSolid = isSolid;
	}

	public boolean isClosed()
	{
		return closed;
	}

	public void setClosed(boolean closed)
	{
		this.closed = closed;
	}

	public boolean isOpen()
	{
		return open;
	}

	public void setOpen(boolean open)
	{
		this.open = open;
	}

	public int getParent()
	{
		return parent;
	}

	public void setParent(int parent)
	{
		this.parent = parent;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getDistance()
	{
		return distance;
	}

	public void setDistance(int distance)
	{
		this.distance = this.distance + distance;
	}

	public int getHuristic()
	{
		return huristic;
	}

	public void setHuristic(int huristic)
	{
		this.huristic = huristic;
	}
}
