public class Stack
{
	private Node top;
	private int height;
	
	class Node
	{
		int value;
		Node next;
		
		Node(int value)
		{
			this.value = value;
		}
	}
	
	public Stack(int value)
	{
		Node newNode = new Node(value);
		top = newNode;
		height = 1;
	}
	
	public void push(int value) 
	{
		Node newNode = new Node(value);
		if(height != 0)
			newNode.next = top;
		top = newNode;
		height++;
	}
	
	public Node pop()
	{
		if (height == 0)
			return null;
		Node temp = top;
		top = top.next;
		temp.next = null;

		height--;
		return temp;
	}
	
	public void printStack()
	{
		Node temp = top;
		while (temp != null)
		{
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Stack myStack = new Stack(1);
		myStack.push(2);
		myStack.push(3);
		myStack.printStack();
		for (int i = 0; i < 3; i++)
			System.out.println(myStack.pop().value);
		System.out.println(myStack.pop());
	}
}