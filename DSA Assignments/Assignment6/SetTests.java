import static org.junit.Assert.*;
import java.math.BigInteger;
import java.util.Random;
import org.junit.Test;

public class SetTests {

  private static BigIntSet getNewSet() {
    return new ChainedHashtable();
  }

  private static BigIntSet getNewSet(int initialSize) {
    return new ChainedHashtable(initialSize);
  }
  
  @Test
  public void testClear() {
    BigIntSet set = getNewSet();
    for (int i = 0; i < 100; i++) {
      set.add(new BigInteger(Integer.toString(i)));
    }
    assertEquals(100, set.size());
    set.clear();
    assertEquals(0, set.size());
    assertTrue(set.isEmpty());
  }

  @Test
  public void testSetContains() {
    BigIntSet set = getNewSet();
    set.add(new BigInteger("12345678910"));
    assertTrue(set.contains(new BigInteger("12345678910")));
    assertEquals(1, set.size());
    for (int i = 0; i < 100; i++) {
      set.add(new BigInteger(Integer.toString(i)));
      assertTrue(set.contains(new BigInteger(Integer.toString(i))));
    }
    assertEquals(101, set.size());
  }
  
  @Test
  public void testReplace() {
    BigIntSet set = getNewSet();
    set.add(new BigInteger("0"));
    assertEquals(1, set.size());
    assertTrue(set.contains(new BigInteger("0")));
    set.add(new BigInteger("0"));
    assertEquals(1, set.size());
    assertTrue(set.contains(new BigInteger("0")));
    set.add(new BigInteger("12"));
    assertEquals(2, set.size());
    assertTrue(set.contains(new BigInteger("12")));
    set.add(new BigInteger("12"));
    assertEquals(2, set.size());
    assertTrue(set.contains(new BigInteger("12")));
    set.add(new BigInteger("23"));
    assertEquals(3, set.size());
    assertTrue(set.contains(new BigInteger("23")));
    set.add(new BigInteger("23"));
    assertEquals(3, set.size());
    assertTrue(set.contains(new BigInteger("23")));
  }
  
  @Test
  public void testCollision() {
    BigIntSet set = getNewSet(11);
    set.add(new BigInteger("0"));
    assertEquals(1, set.size());
    assertTrue(set.contains(new BigInteger("0")));
    set.add(new BigInteger("12"));
    assertEquals(2, set.size());
    assertTrue(set.contains(new BigInteger("12")));
    set.add(new BigInteger("23"));
    assertEquals(3, set.size());
    assertTrue(set.contains(new BigInteger("23")));
    set.remove(new BigInteger("0"));
    assertFalse(set.contains(new BigInteger("0")));
    assertTrue(set.contains(new BigInteger("12")));
    assertTrue(set.contains(new BigInteger("23")));
    assertEquals(2, set.size());
  }
  
  @Test
  public void testRemove() {
    BigIntSet set = getNewSet();
    for (int i = 0; i < 100; i++) {
      set.add(new BigInteger(Integer.toString(i * 22)));
    }
    assertEquals(100, set.size());
    assertTrue(set.contains(new BigInteger("0")));
    set.remove(new BigInteger("0"));
    assertFalse(set.contains(new BigInteger("0")));
    assertEquals(99, set.size());
    assertTrue(set.contains(new BigInteger("22")));
    set.remove(new BigInteger("22"));
    assertFalse(set.contains(new BigInteger("22")));
    assertEquals(98, set.size());
    set.remove(new BigInteger("88"));
    assertFalse(set.contains(new BigInteger("88")));
    assertEquals(97, set.size());
    set.remove(new BigInteger("1000"));
    assertFalse(set.contains(new BigInteger("1000")));
    assertEquals(97, set.size());
    set.remove(new BigInteger("2000"));
    assertFalse(set.contains(new BigInteger("2000")));
    assertEquals(97, set.size());
    assertTrue(set.contains(new BigInteger("44")));
    assertTrue(set.contains(new BigInteger("66")));
  }

  @Test
  public void instrumentAdds() {
    BigIntSet set = getNewSet(11);
    long totalAddTime = 0;
    for (int i = 0; i < 10; i++) {
      Random random = new Random();
      for (int k = 0; k < 10000; k++) {
        BigInteger bigint = new BigInteger(128, random);
        long now = System.nanoTime();
        set.add(bigint);
        totalAddTime += System.nanoTime() - now;
      }
    }
    System.out.println("Time to add 10k values 10x: ");
    System.out.println("\t" + totalAddTime + "ms");
  }
}