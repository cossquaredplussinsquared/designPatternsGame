package loyal.Utilitys;

public class Node<E>
{
	private E value;
	private Node<E> next;
	
	public Node()
	{
		this.value = null;
		this.next = null;
	}
	
	public Node(E value, Node<E> next)
	{
		this.value = value;
		this.next = next;
	}
	

	public E getValue()
	{
		return this.value;
	}
	
	public Node<E> getNext()
	{
		return this.next;
	}
		
	public void setValue(E value)
	{
		this.value = value;
	}
		
	public void setNext(Node<E> next)
	{
		this.next = next;
	}
}
