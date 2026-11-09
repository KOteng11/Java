import java.math.BigInteger;

public class ChainedHashtable implements BigIntSet{
  private int size = 0;
  private Node[] table;
  private static final int DEFAULT_CAPACITY = 11;
  private static final double MAX_LOAD_FACTOR = 0.5;
  
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
  
  public void add(BigInteger value) {
      if (isFull()){
          increaseCapacity();
      }
      
      int index = address(value);
      Node newNode = new Node(value);
      newNode.next = table[index];
      table[index] = newNode;

      size++;
  }
  
  public boolean isFull(){
      return 1.0 * size / table.length > MAX_LOAD_FACTOR;
  }
  
  public void increaseCapacity(){
      
  }
  
  public void remove(BigInteger value) {
      int index = address(value);
      Node temp = table[index];
      Node pre = null;
      
      while (temp != null){
          if (value == temp.value){
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
  
  public static void main(String[] args){
      
  }
}