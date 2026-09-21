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
    
    boolean sorted = false;
    while (!sorted) {
      if (VERBOSE) {
        outputArray();
      }
      sorted = true;
      for (int i = 1; i < array.length; i++) {
        if (array[i - 1] > array[i]) {
          sorted = false;
          swap(i - 1, i);
        }
      }
    }
    
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
  
  private int[] merge(int[] array1, int[] array2){
      int index = 0;
      int i = 0;
      int k = 0;
      int[] combined = new int[array1.length + array2.length];
      
      while(i < array1.length && k < array2.length){
          if (array1[i] < array2[k]){
              combined[index++] = array1[i++];
          }else{
              combined[index++] = array2[k++];
          }
      }
      
      while (i < array1.length){
          combined[index++] = array1[i++];
      }
      
      while (k < array2.length){
          combined[index++] = array2[k++];
      }
      
      return combined;
  }
}