public class LinkedList1
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
	
	public Node head;
	public Node tail;
	public int length;
	
	public LinkedList1(int value)
	{
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public LinkedList1(LinkedList1 other)
	{
		if (other.head == null)
			return;
		this.head = new Node(other.head.value);
		Node currentNew = this.head;
		Node currentOld = other.head.next;
		
		while(currentOld != null)
		{
			currentNew.next = new Node(currentOld.value);
			currentNew = currentNew.next;
			currentOld = currentOld.next;
		}
		tail = currentNew;
	}
	
	public Node get(int index)
	{
		if (index < 0 || index >= length)
			return null;
		Node temp = head;
		for (int i = 0; i <index; i++)
			temp = temp.next;
		return temp;
	}
	
	public Node removeFirst()
	{
		if (length == 0)
			return null;
		Node temp = head;
		head = head.next;
		length--;
		if (length == 0)
			tail.next = null;
		else
			temp.next = null;
		/**
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
		}*/
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
			tail.next = null;
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
			newNode.next = head;
		head = newNode;
		length++;
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
		
		while(temp != null)
		{
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println("\n");
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
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;
	}
	
	public Node remove(int index)
	{
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
		head = tail;
		tail = temp;
		Node before = null;
		Node after = temp.next;
		while (temp != null)
		{
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
	}
	
	public static void main(String[] args)
	{
		LinkedList1 myList = new LinkedList1(2);
		myList.append(3);
		myList.prepend(1);
		myList.append(4);
		myList.insert(0, 0);
		myList.insert(4, 5);
		myList.printList();
		
		LinkedList1 myList2 = new LinkedList1(myList);
		myList2.printList();
		/**
		for (int i = 0; i < 4; i++)
			System.out.println(myList.removeLast().value);
		System.out.println(myList.removeLast());*/
	}	
}