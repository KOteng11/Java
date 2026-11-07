import java.math.BigInteger;

public interface BigIntSet {
  public void add(BigInteger value);
  public void remove(BigInteger value);
  public boolean contains(BigInteger value);
  public boolean isEmpty();
  public void clear();
  public int size(); 
}