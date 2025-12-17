public class LinkedList
{
	private Node head;
	private Node tail;
	private int length;
	
	class Node
	{
		int value;
		Node next;
		
		Node(int value)
		{
			this.value = value;
		}
	}
	
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
		Node cur = other.head;
		while (cur.next != null)
		{
			cur = cur.next;
			append(cur.value);
		}
	}
	
	public void append(int value)
	{
		Node newNode = new Node(value);
		if (length == 0)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}
	
	public void prepend(int value)
	{
		Node newNode = new Node(value);
		if (length == 0)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.next = head;
			head = newNode;
		}
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
		}
		length--;
		return temp;
	}
	
	public Node removeLast()
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
			Node prev = head;
			
			while (temp.next != null)
			{
				prev = temp;
				temp = temp.next;
			}
			tail = prev;
			prev.next = null;
		}
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
		if (index < 0 || index >= length)
			return false;
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
		Node prev = get(index - 1);
		newNode.next = prev.next;
		prev.next = newNode;
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
	
	public void reverse()
	{
		Node temp = head;
		head =  tail;
		tail = temp;
		Node after = temp.next;
		Node before = null;
		
		for(int i = 0; i < length; i++)
		{
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}	
	}
	
	public Node findMiddleNode()
	{
		Node fast = head;
		Node slow = head;
		
		while (fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
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
		LinkedList myList = new LinkedList(2);
		myList.append(3);
		myList.prepend(1);
		myList.set(1, 15);
		myList.insert(0, 0);
		myList.insert(4, 4);
		myList.insert(2, 5);
		myList.printList();
		System.out.println(myList.findMiddleNode().value);

		/**
		for (int i = 0; i < 3; i++)
		{
			System.out.println(myList.get(i).value);
		}**/
	}
}