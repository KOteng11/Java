public class InsertionSorter implements IntSorter {

  private static final boolean VERBOSE = false;
  
  private int[] array;
  private int swaps = 0;
  private long startTime = 0;
  private long endTime = 0;
  
  public void init(int[] array) {
    this.array = array;
    swaps = 0;
  }
  
  /**
  public void sort() {
    startTime = System.nanoTime();
    // real algorithm starts here
    
    for (int i = 1; i < array.length; i++) {
      for (int k = i; k > 0 && array[k - 1] > array[k]; k--) {
        swap(k, k - 1);
      }
    }
    
    endTime = System.nanoTime();
  }
  */
  
  public void sort(){
    startTime = System.nanoTime();
      
    for (int i = 1; i < array.length; i++){
      int temp = array[i];
      int k;
      for (k = i; k > 0 && array[k-1] > temp; k--){
        array[k] = array[k-1];
      }
      array[k] = temp;
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

/**
  private void swap(int position1, int position2) {
    int temp = array[position1];
    array[position1] = array[position2];
    array[position2] = temp;
    swaps++; // not part of the algorithm, but useful for instrumentation
  }
  
  */
}