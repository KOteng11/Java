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
	
	public void printList()
	{
		Node temp = head;
		
		while (temp != null)
		{
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args)
	{
		LinkedList myList = new LinkedList(2);
		System.out.println(myList.head.value);
		System.out.println(myList.tail.value);
		System.out.println(myList.length);
	}
}