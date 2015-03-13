package loyal.Utilitys;

public class LinkedList<E>
{
	protected Node<E> head; 
    protected int size;
    
    public LinkedList()
	{
		head = null; 
		size = 0;
    }
    
    public int size()
    {
    	return this.size;
    }

	public void addFirst(Node<E> v)
	{
		v.setNext(head);
		head = v; 
		size ++;
    }
    
    
    public void addLast(Node<E> v)
	{
		if(size == 0)
		{
			addFirst(v);
		}
		else
		{
			Node<E> cur; 
			for(cur = head; cur.getNext() != null; cur = cur.getNext())
			{
				v.setNext(null);
				cur.setNext(v); 
				size ++;
			}
		}
    }

    public void removeFirst()
	{
		if(size == 0)
	    return; 
	
		Node<E> old_head = head; 
		head = head.getNext(); 
		size --; 
		old_head.setNext(null); 
    }

    public void removeLast()
	{
	 	if(size == 0)
	    return; 

		if(size == 1)
		{
			removeFirst();
		}
	
		Node<E> cur; 
		for(cur = head; cur.getNext().getNext() != null; cur=cur.getNext())
		{
			cur.setNext(null);
			size --;
		}
	} 
    
    public void addAfter(Node<E> u, Node<E> v)
	{
	 	if(u == null)
	    return; 
	
		v.setNext(u.getNext()); 
		u.setNext(v);
		size ++;
    }


    public void addBefore(Node<E> u, Node<E> v)
	{
		if(u == null)
	    return;
		if(u.equals(head))
		{
	  		addFirst(v);
		}
		else
		{
			Node<E> cur; 
			for(cur = head; cur.getNext() != u; cur = cur.getNext())
			{
				v.setNext(u);
				cur.setNext(v);
				size ++;
			}
		}
    }
    
    
    public void removeAfter(Node<E> v)
	 {
	 	if(v == null)
	    return;

		if(v.getNext() == null)
	    return; 
	
		Node<E> deleted = v.getNext(); 
		v.setNext(v.getNext().getNext());
		deleted.setNext(null); 
		size --;
    }

    public void removeBefore(Node<E> v)
	{
	 	if(v == null)
	    return;
		if(v.equals(head))
	    return; 

		if(head.getNext().equals(v))
		{
			Node<E> old_head = head; 
			head = v;
			old_head.setNext(null);
		}
		else
		{
	    	Node<E> cur; 
	    	for(cur = head; cur.getNext().getNext() != v; cur = cur.getNext())
	    	{
	    		Node<E> deleted = cur.getNext(); 
	    		cur.setNext(v);
	    		deleted.setNext(null);
	    	}
		}
		size --; 
    }

    public void remove(Node<E> v)
	{
	 	if(v == null)
	    return; 

		if(head.equals(v))
		{
			removeFirst();
		}
	
		else
		{
	    	Node<E> cur; 
	    	for(cur = head; cur.getNext() != v; cur = cur.getNext());
	    	Node<E> deleted = cur.getNext(); 
	    	cur.setNext(v.getNext());
	    	deleted.setNext(null);
		}
		size --; 
    }

    
    public String toString()
	 {
		StringBuilder all = new StringBuilder();
		for(Node<E> cur = head; cur != null; cur = cur.getNext())
		{
			all.append("("+cur.toString()+ ")  ");
		}
		return all.toString();
    }
	 
	 
	 public Node<E> search(E id)
	 {
	 	if(size == 0)
		{
			return null;
		}
		else
		{ 
	 		Node<E> target = null;
	 		for(Node<E> i =  head; i != null; i = i.getNext())
			{
				if(i.getValue().equals(id))
				{
				 	target = i;
				}
			}
			if(target == null)
			{
				return null;
			}
			else
			{
				return target;
			}
		}
	}
	 
	 public boolean contains(E id)
	 {
	 	if(size == 0)
		{
			return false;
		}
		else
		{ 
	 		Node<E> target = null;
	 		for(Node<E> i =  head; i != null; i = i.getNext())
			{
				if(i.getValue().equals(id))
				{
				 	target = i;
				}
			}
			if(target == null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}	
}
