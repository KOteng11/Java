import java.util.Arrays;

public class MergeSorter implements IntSorter {

  private static final boolean VERBOSE = false;
  
  private int[] array;
  private int swaps = 0;
  private long startTime = 0;
  private long endTime = 0;
  
  public void init(int[] array) {
    this.array = array;
    swaps = 0;
  }
  
  public void sort() {
    startTime = System.nanoTime();
    // real algorithm starts here
    int[] temp = new int[array.length];
    sortHelper(temp, 0, array.length - 1);
    
    endTime = System.nanoTime();
  }
  
  private void outputArray() {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");;
    }
    System.out.println();
  }
  
  public long getRuntimeInNanos() {
    return endTime - startTime;
  }
  
  public int getSwaps() {
    return swaps;
  }
  
  private void sortHelper(int[] temp, int lo, int hi){
    if (lo >= hi){
        return;
    }
    
    int mid = (lo + hi) / 2;
    sortHelper(temp, lo, mid);
    sortHelper(temp, mid + 1, hi);
    merge(temp, lo, mid, hi);
  }
  
  private void merge(int[] temp, int lo, int mid, int hi)
  {
    for (int i = lo; i <= hi; i++)
    {
      temp[i] = array[i];
    }

    int i = lo;
    int k = mid + 1;
    int m = lo;

    while ( i <= mid && k <= hi)
    {
        if (temp[i] <= temp[k])
        {
            array[m++] = temp[i++];
        }
        else
        {
            array[m++] = temp[k++];
        }
    }
    
    while(i <= mid)
    {
        array[m++] = temp[i++];
    }
    
    while(k <= hi)
    {
        array[m++] = temp[k++];
    }
  }
  
  
  public static void main(String[] args){
      int[] A = {8, 5, 12, 7, 6, 1, 3, 2, 11, 15, 6, 9, 21};
      MergeSorter t = new MergeSorter();
      
      t.init(A);
      t.sort();
      
      System.out.println(Arrays.toString(A));
      
  }
}