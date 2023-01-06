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

    for (int i = 0; i < 10; i++) {
      queue.enqueue(i);
    }

    assertEquals(10, queue.size());
    assertEquals(0, queue.peekFirstElement());
    assertEquals(9, queue.peekLastElement());
    int expectedSize = queue.size() - 1;
    for (int i = 0; i < 10; i++) {
      Integer data = queue.dequeue();
      assertEquals(expectedSize, queue.size());
      assertEquals(i, data);
      expectedSize--;
    }

    assertThrows(RuntimeException.class, () -> {
      queue.dequeue();
    });

    // try {
    // Integer data = queue.dequeue()

    // }
    // catch(RuntimeException e) {
    // assertEquals("empty list", e.getMessage());
    // throw e;
    // }
    // fail("fail to catch runtime execption");
    logger.info("passed");

  }

}
