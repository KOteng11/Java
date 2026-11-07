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
      if (1.0 * size / table.length > MAX_LOAD_FACTOR){
          increaseCapacity();
      }
      int index = address(value);
      Node newNode = new Node(value);
      if (table[index] == null){
          table[index] = newNode;
      }else{
          Node temp = table[index];
          while(temp.next != null){
              temp = temp.next;
          }
          temp.next = newNode;
      }
      size++;
  }
  
  public void increaseCapacity(){
      
  }
  
  public void remove(BigInteger value) {
  }
  
  public boolean contains(BigInteger value) {
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