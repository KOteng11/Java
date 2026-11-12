import java.math.BigInteger;

public class LinearProbingHashtable implements BigIntSet {

  private static final double MAX_LOAD_FACTOR = 0.5;

  private int size = 0;
  private BigInteger[] table;
  
  public LinearProbingHashtable(int initialSize) {
    table = new BigInteger[initialSize];
  }
  
  public LinearProbingHashtable() {
    this(11);
  }
  
  private void ensureCapacity() {
    if (1.0 * size / table.length > MAX_LOAD_FACTOR) {
      BigInteger[] old = table;
      table = new BigInteger[table.length * 2 + 1];
      size = 0;
      for (int i = 0; i < old.length; i++) {
        if (old[i] != null) {
          this.add(old[i]);
        }
      }
    }
  }
  
  private int address(BigInteger value) {
    return Math.abs(value.hashCode() % table.length);
  }
  
  public void add(BigInteger value) {
    ensureCapacity();
    int a = address(value);
    while (table[a] != null) {
      if (table[a].equals(value)) {
        table[a] = value;
        return;
      }
      a = (a + 1) % table.length;
    }
    table[a] = value;
    size++;
  }
  
  public void remove(BigInteger value) {
    int a = address(value);
    boolean removed = false;
    while (table[a] != null) {
      if (removed) {
        BigInteger readdress = table[a];
        table[a] = null;
        size--;
        this.add(readdress);
      } else if (table[a].equals(value)) {
        table[a] = null;
        size--;
        removed = true;
      }
      a = (a + 1) % table.length;
    }
  }
  
  public boolean contains(BigInteger value) {
    int a = address(value);
    while (table[a] != null) {
      if (table[a].equals(value)) {
        return true;
      }
      a = (a + 1) % table.length;
      // the line above is equivalent to:
      // a++;
      // if (a >= table.length) {
      //   a = 0;
      // }
    }
    return false;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public void clear() {
    for (int i = 0; i < table.length; i++) {
      table[i] = null;
    }
    size = 0;
  }
  
  public int size() {
    return size;
  }
  
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < table.length; i++) {
      s.append("| ").append(i).append("\t| ");
      if (table[i] != null) {
        s.append(table[i]);
      }
      s.append("\n");
    }
    return s.toString();
  }
}