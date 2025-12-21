public class Queue
{
	class Node
	{
		int value;
		Node next;
		
		Node(int value)
		{
			this.value = value;
		}
	}
	
	private Node first;
	private Node last;
	private int length;
	
	public Queue(int value)
	{
		Node newNode = new Node(value);
		first = newNode;
		last = newNode;
		length = 1;
	}
	
	public void enqueue(int value)
	{
		Node newNode = new Node(value);
		if (length == 0)
			first = newNode;
		else
			last.next = newNode;
		last = newNode;
		length++;
	}
	
	public Node dequeue()
	{
		if (length == 0)
			return null;
		Node temp = first;
		if (length == 1)
		{
			first = null;
			last = null;
		}
		else
		{
			first = first.next;
			temp.next = null;
		}
		length--;
		
		return temp;
	}
	
	public Node getFirst()
	{
		return new Node(first.value);
	}
	
	public Node getLast()
	{
		return new Node(last.value);
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void printQueue()
	{
		Node temp = first;
		
		while (temp != null)
		{
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Queue queue = new Queue(2);
		queue.enqueue(3);
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		System.out.println(queue.dequeue());
	}
}