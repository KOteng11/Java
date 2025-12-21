public class DoublyLinkedList
{
	class Node
	{
		int value;
		Node next;
		Node prev;
		
		Node(int value)
		{
			this.value = value;
		}
	}
	
	private Node head;
	private Node tail;
	private int length;
		
	public DoublyLinkedList(int value)
	{
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}
	
	public DoublyLinkedList(DoublyLinkedList other)
	{
		this(other.head.value);
		Node cur = other.head.next;
		while (cur != null)
		{
			append(cur.value);
			cur = cur.next;
		}
	}
	
	public void append(int value)
	{
		Node newNode = new Node(value);
		if (length == 0)
			head = newNode;
		else
		{
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		length++;
	}
	
	public Node removeFirst()
	{
		if (length == 0)
			return null;
		Node temp = head;
		if (length == 1)
		{
			head = null;
			tail = null;
		}
		else
		{
			head = head.next;
			temp.next = null;
			head.prev = null;
		}
		length--;
		return temp;		
	}
	
	public Node removeLast()
	{
		if (length == 0)
			return null;
		
		Node temp = tail;
		if (length == 1)
		{
			head = null;
			tail = null;
		}
		else
		{
			tail = temp.prev;
			tail.next = null;
			temp.prev = null;
		}
		length--;
		return temp;	
	}
	
	public void prepend(int value)
	{
		Node newNode = new Node(value);
		if (length == 0)
			tail = newNode;
		else
		{
			newNode.next = head;
			head.prev = newNode;
		}
		head = newNode;
		length++;
	}
	
	public Node get(int index)
	{
		if (index < 0 || index >= length)
			return null;
		Node temp = head;
		if (index < length / 2)
		{
			for (int i = 0; i < index; i++)
				temp = temp.next;
		}
		else
		{
			temp = tail;
			for (int i = length - 1; i > index; i--)
				temp = temp.prev;
		}
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
		if (index == 0)
			return removeFirst();
		if (index == length - 1)
			return removeLast();
		Node prev = get(index - 1);
		Node temp = prev.next;
		prev.next = temp.next;
		temp.next = null;
		length--;
		return temp;
	}
		
	public Node getHead()
	{
		return new Node(head.value);
	}
	
	public Node getTail()
	{
		return new Node(tail.value);
	}
		
	public int getLength()
	{
		return length;
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
		
	public static void main(String[] args)
	{
		DoublyLinkedList ll = new DoublyLinkedList(2);
		ll.append(3);
		ll.prepend(1);
		ll.set(2, 6);
		ll.insert(0, 9);
		ll.insert(4, 8);
		ll.insert(2, 7);
		ll.printList();
		ll.remove(5);
		ll.printList();
		ll.remove(0);
		ll.printList();
		ll.remove(1);
		ll.printList();
		//DoublyLinkedList myList = new DoublyLinkedList(ll);
		//myList.printList();
	}
}