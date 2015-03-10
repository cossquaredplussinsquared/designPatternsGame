package loyal.Utilitys;

import java.util.*;

public class Edge<E>
{
	private static int ID = 0;
    private E elem;
    private int id;
    private int weight;
    private LinkedList<Vertex<E>> pointers;

    public Edge()
    {
       this(null, Integer.MAX_VALUE);
    }

    public Edge(E elem, int distance)
    {
       this.elem = elem;
       id = ID++; 
       pointers = new LinkedList<Vertex<E>>();
       this.weight = distance;
    }

    public int getId()
    {
    	return id;
    }

    public E getElem()
    {
    	return elem;
    }
    
    public void setElem(E elem)
    {
    	this.elem = elem;
    }

    public int getDistance()
    {
    	return weight;
    }
    
    public void setDistance(int dist)
    {
    	weight = dist;
    }
    
    public void connectTo(Edge<E> other)
    {
        Vertex<E> c = new Vertex<E>(this, other);

        if(!pointers.contains(c))
        {
        	Node node = new Node(c, null);
        	pointers.addLast(node);	
        }

        LinkedList<Vertex<E>> conn = other.getConnections();
        if(!conn.contains(c))
        {
        	Node node = new Node(c, null);
        	conn.addLast(node);
       	}
    }

    public void connectTo(Edge<E> other, int distance)
    {
        Vertex<E> c = new Vertex<E>(this, other, distance);
        if(!pointers.contains(c))
        {
        	Node node = new Node(c, null);
        	pointers.addLast(node);
       	}
    }

    public LinkedList<Vertex<E>> getConnections()
    {
    	return pointers;
    }

    public String toString()
    {
    	return this.elem.toString();
    }
}
