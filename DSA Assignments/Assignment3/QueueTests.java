import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTests {
  Queue q = new LinkedListQueue();
  
  @Test
  public void runQueueTests() {
    // Instantiate your Queue and run tests here
    for (int i = 0; i < 10; i++){
        instrumentTiming(q);
    }
    
  }
  
  public void instrumentTiming(Queue q) {
    long start = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
      q.enqueue(Integer.toString(i));
    }
    long end = System.nanoTime();
    System.out.println("Enqueue took " + (end - start) + " ns.");
    start = System.nanoTime();
    while (!q.isEmpty()) {
      q.dequeue();
    }
    end = System.nanoTime();
    System.out.println("Dequeue took " + (end - start) + " ns.");
  }

  @Test
  public void loadAndEmptyQueue() {
    for (int i = 0; i < 100; i++) {
      q.enqueue(Integer.toString(i));
    }
    assertEquals(100, q.size());
    for (int i = 0; i < 100; i++) {
      String s = q.dequeue();
      assertEquals(Integer.toString(i), s);
    }
  }
  
  @Test
  public void orderQueue() {
    q.enqueue("0");  // q is 0
    q.dequeue(); 
    assertEquals(0, q.size());
    q.enqueue("0");  // q is 0
    q.enqueue("1");  // q is 0 1
    q.dequeue();
    assertEquals(1, q.size());
    assertEquals("1", q.dequeue());
    assertTrue(q.isEmpty());
    q.enqueue("0");  // q is 0
    q.enqueue("1");  // q is 0 1
    q.dequeue(); // q is 1
    assertEquals(1, q.size());
    q.enqueue("1");  // q is 1 1
    q.enqueue("2");  // q is 1 1 2
    q.enqueue("3");  // q is 1 1 2 3
    assertEquals(q.size(), 4);
    assertEquals("1", q.dequeue());
    assertEquals(3, q.size());
    q.dequeue(); // q is 2 3
    q.enqueue("4");  // q is 2 3 4
    assertEquals(3, q.size());
    assertEquals("2", q.dequeue());
    assertEquals("3", q.dequeue());
    assertEquals("4", q.dequeue());
    assertTrue(q.isEmpty());
  }
}