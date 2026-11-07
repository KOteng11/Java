public interface Queue {
  public void enqueue(String s);
  public String dequeue();
  public int size();
  public boolean isEmpty();
}