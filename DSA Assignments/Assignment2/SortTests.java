import org.junit.Test;
import static org.junit.Assert.*;

public class SortTests {

  private IntSorter sorter = new InsertionSorter();
  
  @Test
  public void testEmptyArray() {
    int[] empty = new int[0];
    sorter.init(empty);
    sorter.sort();
  }
  
  @Test 
  public void testSingleArray() {
    int[] oneValue = {0};
    sorter.init(oneValue);
    sorter.sort();
  }
  
  @Test
  public void testTWoValues() {
    int[] twoValues = {2, 1};
    sorter.init(twoValues);
    sorter.sort();
  }
  
  @Test
  public void testRealSorting() {
    long totalTime = 0;
    for (int i = 0; i < 1000; i++) {
      int[] array = generateArray(100);
      sorter.init(array);
      sorter.sort();
      totalTime += sorter.getRuntimeInNanos();
      assertTrue(isSorted(array));
    }
    System.out.println("Avg time to run sort: " + (totalTime / 10));
  }
  
  
  private int[] generateArray(int size) {
    int[] result = new int[size];
    for (int i = 0; i < result.length; i++) {
      result[i] = (int)(Math.random() * 1999) - 999;
    }
    return result;
  }

  private boolean isSorted(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] > array[i]) {
        return false;
      }
    }
    return true;
  }
}
