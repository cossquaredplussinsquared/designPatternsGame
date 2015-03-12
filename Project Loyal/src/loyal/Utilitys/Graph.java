package loyal.Utilitys;

import java.util.ArrayList;

public class Graph<E>
{
	private ArrayList<Edge<E>> edges; 
	
	public Graph()
	{
		edges = new ArrayList<Edge<E>>();
	}
	
	public boolean addEdge(Edge<E> vertex)
	{
		if(edges.contains(vertex))
		{
			return false;
		}
		edges.add(vertex);
		return true;
	}
	
	public boolean contains(Edge<E> vertex)
	{
		return edges.contains(vertex);
	}
	
	public Edge<E> get(int index)
	{
		return edges.get(index);
	}

	public int count()
	{
		return edges.size();
	}

	public boolean equals(Graph<E> other)
	{
		if(other.edges.size() != edges.size())
		{
			return false;
		}

		ArrayList<Edge<E>> temp = new ArrayList<Edge<E>>(other.edges);
		return temp.retainAll(edges);
	}
}
