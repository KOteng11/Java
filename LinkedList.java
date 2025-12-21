public class LinkedList
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
	
	private Node head;
	private Node tail;
	private int length;
	
	public LinkedList(int value)
	{
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}
	
	public LinkedList(LinkedList other)
	{
		this(other.head.value);
		//if (this.head == null)
		//	throw new NullPointerException("LinkedList is empty.");
		Node temp = other.head;
		for (int i = 1; i < other.length; i++)
		{
			temp = temp.next;
			append(temp.value);
		}
	}
	
	public int getHead()
	{
		return head.value;
	}
	
	public int getTail()
	{
		return tail.value;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void append(int value)
	{
		Node newNode = new Node(value);
		if (length == 0)
			head = newNode;
		else
			tail.next = newNode;
		tail = newNode;
		length++;
	}
	
	public void prepend(int value)
	{
		Node newNode = new Node(value);
		if (length == 0)
			tail = newNode;
		else
			newNode.next = head;
		head = newNode;
		length++;
	}
	
	public void printList()
	{
		Node temp = head;
		
		while (temp != null)
		{
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public Node removeFirst()
	{
		if (length == 0)
			return null;
		
		Node temp = head;
		head = head.next;
		temp.next = null;
		if (length == 0)
			tail = null;
		length--;
		return temp;
	}
	
	public Node removeLast()
	{
		if (length == 0)
			return null;
		Node temp = head;
		Node prev = head;
		
		while (temp.next != null)
		{
			prev = temp;
			temp = temp.next;
		}
		tail = prev;
		tail.next = null;
		length--;
		return temp;
	}
	
	public Node get(int index)
	{
		if (index < 0 || index >= length)
			return null;
		Node temp = head;
		for (int i = 0; i < index; i++)
			temp = temp.next;
		
		return temp;
	}
	
	public boolean set(int index, int value)
	{
		Node temp = get(index);
		if (temp != null)
		{
			temp.value = value;
			return true;
		}
		return false;
	}
	
	public boolean insert(int index, int value)
	{
		if (index < 0 || index > length)
			return false;
		if (index == 0)
		{
			prepend(value);
			return true;
		}
		if (index == length)
		{
			append(value);
			return true;
		}
		Node newNode = new Node(value);
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;
	}
	
	public Node remove(int index)
	{
		if (index < 0 || index >= length)
			return null;
		if (length == 0)
			return removeFirst();
		if (length == length - 1)
			return removeLast();
		Node prev = get(index - 1);
		Node temp = prev.next;
		prev.next = temp.next;
		temp.next = null;
		length--;
		return temp;
	}
	
	public void reverse()
	{
		Node temp = head;
		head = tail;
		tail = temp;
		Node after = temp.next;
		Node before = null;
		
		for (int i = 0; i < length; i++)
		{
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
	}
	
	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList(2);
		ll.append(3);
		ll.prepend(1);
		ll.insert(1, 6);
		ll.insert(2, 7);
		
		System.out.println(ll);
		LinkedList myList = new LinkedList(ll);
		System.out.println(myList);
	}
}