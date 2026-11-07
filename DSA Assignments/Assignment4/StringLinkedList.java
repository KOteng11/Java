import java.util.NoSuchElementException;

public class StringLinkedList implements StringIterable {

  private Node head;
  private Node tail;
  private int size;
  
  private class Node {
    Node next;
    String value;
    
    public Node(String value) {
      this.value = value;
    }
    
    public Node(String value, Node next) {
      this(value);
      this.next = next;
    }
  }
  
  private class LinkedListIterator implements StringIterator{
    private Node curIndex = head;
      
    @Override
    public String next(){
        if (curIndex == null){
            throw new NoSuchElementException();
        }
        String curValue = curIndex.value;
        curIndex = curIndex.next;
        return curValue;
    }
    
    @Override
    public boolean hasNext(){
        return curIndex.next != null; 
    }
  }
  
  @Override
  public StringIterator iterator(){
      return new LinkedListIterator();
  }
  
  public StringLinkedList() {
    size = 0;
  }
  
  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public void add(String s) {
    if (isEmpty()) {
      head = tail = new Node(s);
    } else {
      Node last = new Node(s);
      tail.next = last;
      tail = last;
    }
    size++;
  }
  
  private void checkBounds(int i) {
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  private Node getNodeAt(int index) {
    checkBounds(index);
    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current;
  }
  
  public void add(int i, String s) {
    checkBounds(i);
    if (i == 0) {
      Node n = new Node(s);
      n.next = head;
      head = n;
    } else {
      Node n = getNodeAt(i - 1);
      Node newNode = new Node(s);
      newNode.next = n.next;
      n.next = newNode;
    }
    size++;
  }
  
  public String get(int index) {
    return getNodeAt(index).value;
  }
  
  public void set(int i, String s) {
    getNodeAt(i).value = s;
  }
  
  public void clear() {
    head = tail = null;
    size = 0;
  }
  
  public int indexOf(String s) {
    Node current = head;
    for (int i = 0; current != null; i++) {
      if ((s != null && s.equals(current.value)) || s == null && current.value == null) {
        return i;
      }
      current = current.next;
    }
    // the commented code below is more code, but a bit more efficient
    // and equivalent to the for-loop code above
//     if (s == null) {
//       for (int i = 0; current != null; i++) {
//         if (current.value == null) {
//           return i;
//         }
//         current = current.next;
//       }
//     } else {
//       for (int i = 0; current != null; i++) {
//         if (s.equals(current.value)) {
//           return i;
//         }
//         current = current.next;
//       }
//     }
    return -1;
  }
  
  public boolean contains(String s) {
    return indexOf(s) != -1;
  }
  
  public String remove(int i) {
    checkBounds(i);
    String result = null;
    if (head == tail) {
      result = head.value;
      head = tail = null;
    } else if (i == 0) {
      result = head.value;
      head = head.next;
    } else if (i == size - 1) {
      Node n = getNodeAt(i - 1);
      result = tail.value;
      tail = n;
      tail.next = null;
    } else {
      Node n = getNodeAt(i - 1);
      result = n.next.value;
      n.next = n.next.next;
    }
    size--;
    return result;
  }
  
  public String[] toArray() {
    String[] result = new String[size];
//     for (int i = 0; i < result.length; i++) {   // This is O(n)
//       result[i] = this.get(i);                  // This is also O(n)
//     }
    Node current = head;
    for (int i = 0; i < result.length; i++) {      // This is O(n)
      result[i] = current.value;                   // This is O(1)
      current = current.next;                      // This is O(1)
    }
    return result;
  }
  
  public String toString() {
    StringBuilder s = new StringBuilder();
    Node current = head;
    String delimiter = "";
    while (current != null) {
      s.append(delimiter);
      delimiter = ", ";
      s.append(current.value);
      current = current.next;
    }
    return s.toString();
  }
}