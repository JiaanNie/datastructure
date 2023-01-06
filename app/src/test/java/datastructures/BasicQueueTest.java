package datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import datastructures.queue.Queue;

public class BasicQueueTest {
  private static final Logger logger = Logger.getLogger(Queue.class.getName());

  @Test
  void TestBasicFunctionForQueue() {

    // queue creation
    Queue<Integer> queue = new Queue<Integer>();
    assertEquals(0, queue.size());
    assertEquals(true, queue.isEmpty());

    for (int i = 0; i < 1_000_000; i++) {
      queue.enqueue(i);
    }

    assertEquals(1_000_000, queue.size());
    assertEquals(0, queue.peekFirstElement());
    assertEquals(999_999, queue.peekLastElement());
    int expectedSize = queue.size() - 1;
    for (int i = 0; i < 1_000_000; i++) {
      Integer data = queue.dequeue();
      assertEquals(expectedSize, queue.size());
      assertEquals(i, data);
      expectedSize--;
    }

    assertThrows(RuntimeException.class, () -> {
      queue.dequeue();
    });
    logger.info("passed");

  }

}
