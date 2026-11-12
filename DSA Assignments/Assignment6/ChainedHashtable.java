import java.math.BigInteger;

public class ChainedHashtable implements BigIntSet{
  private int size = 0;
  private Node[] table;
  private static final int DEFAULT_CAPACITY = 19;
  private static final double MAX_LOAD_FACTOR = 0.75;
  private long count = 0; // Added this
  
  class Node{
      BigInteger value;
      Node next;
      
      Node(BigInteger value){
          this.value = value;
          this.next = null;
      }
  }
  
  public ChainedHashtable(int initialCapacity){
      table = new Node[initialCapacity];
  }
  
  public ChainedHashtable(){
      this(DEFAULT_CAPACITY);
  }
  
  public int address(BigInteger value){
      return Math.abs(value.hashCode() % table.length);
  }
  
  public void add(BigInteger value){
      if (isFull()){
          increaseCapacity();
      }
      
      int index = address(value);
      Node newNode = new Node(value);

      if (table[index] == null){
          table[index] = newNode;
      }else{
          ++count; // Added this
          Node temp = table[index];
          Node pre = null;
          while(temp != null){
              if (temp.value.equals(value)){
                  return;
              }
              pre = temp;
              temp = temp.next;
          }
          pre.next = newNode;
      }
      
      size++;
  }
  
  // Added this
  public long getCollisionCount(){
      return count;
  }
  
  public boolean isFull(){
      return 1.0 * size / table.length > MAX_LOAD_FACTOR;
  }
  
  private void increaseCapacity(){
      Node[] old = table;
      table = new Node[old.length * 2 + 1];
      size = 0;
      for (int i = 0; i < old.length; i++){
          Node temp = old[i];
          while (temp != null){
              add(temp.value);
              temp = temp.next;
          }
      }

  }
  
  public void remove(BigInteger value) {
      int index = address(value);
      Node temp = table[index];
      Node pre = null;
      
      while (temp != null){
          if (temp.value.equals(value)){
              if (pre == null){
                  table[index] = temp.next;
              }else{
                  pre.next = temp.next;
              }
              temp.next = null;
              size--;
              return;
          }
          pre = temp;
          temp = temp.next;
      }
  }
  
  public boolean contains(BigInteger value) {
    int index = address(value);
    Node temp = table[index];
    while(temp != null){
        if (temp.value.equals(value)){
            return true;
        }
        temp = temp.next;
    }
    return false;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public void clear() {
      for (int i = 0; i < table.length; i++){
          table[i] = null;
      }
      size = 0;
  }
  
  public int size() {
    return size;
  }

}