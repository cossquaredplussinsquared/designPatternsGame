package loyal.Utilitys;

public class Vertex<E> implements Comparable<Vertex<E>>
{
	private Edge<E> one, two;
	private int distance;

	public Vertex(Edge<E> one, Edge<E> two)
	{
		this(one, two, 0); 
	}

	public Vertex(Edge<E> one, Edge<E> two, int distance)
	{ 
		this.one = one;
	    this.two = two;
	    this.distance = distance;
	}

	public Edge<E> getOne()
	{
		return one;
	}
	public Edge<E> getTwo()
	{
		return two;
	}
	public int getDistance()
	{
		return distance;
	}
	public void setDistance(int distance)
	{
		this.distance = distance;
	}

	public boolean equals(Vertex<E> other)
	{
		return one.equals(other.getOne()) && 
	    two.equals(other.getTwo()) &&
	    distance == other.getDistance();
	}

	public String toString()
	{
		return "(" + one.getElem() + ", " + two.getElem() + "): " + distance;
	}

	public int compareTo(Vertex<E> other)
	{
		return this.distance - other.distance;
	}
}
