public interface IntSorter {
  public void init(int[] array);
  public void sort();
  public int getSwaps();
  public long getRuntimeInNanos();
}