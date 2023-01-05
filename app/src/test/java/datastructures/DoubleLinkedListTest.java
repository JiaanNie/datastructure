package datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import datastructures.linklist.doublelinked.DoubleLinkedList;

public class DoubleLinkedListTest {
  private static final Logger logger = Logger.getLogger(DoubleLinkedList.class.getName());

  @Test
  void testDoublelinkedList() {

    // make sure i can add element to the head
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    list.addElementToHead(1);
    assertNull(list.getHead().previous);
    assertNull(list.getHead().next);

    list.addElementToHead(2);
    assertEquals(2, list.getTail().previous.getData());
    assertEquals(1, list.getTail().getData());

    // right now the list should be 3<->2<->1
    list.addElementToHead(3);

    assertEquals(2, list.getHead().next.getData());
    assertEquals(3, list.size());

    list.addElementToHead(4);
    list.addElementToHead(5);

    // 5<->4<->3<->2<->1
    assertEquals(5, list.size());

    // remove first element
    list.removeFirstElement();
    assertEquals(4, list.size());
    assertNull(list.getHead().previous);
    assertEquals(4, list.getHead().getData());

    // remove last element
    list.removeLastElement();
    assertEquals(3, list.size());
    assertNull(list.getTail().next);
    assertEquals(3, list.getTail().previous.getData());
    assertEquals(2, list.getTail().getData());

    // 4<->3<->2
    assertEquals(2, list.getTail().getData());
    assertEquals(4, list.getHead().getData());
    assertEquals(3, list.getHead().next.getData());
    assertEquals(3, list.getTail().previous.getData());
    assertNull(list.getTail().next);
    assertNull(list.getHead().previous);

    logger.info("passed");

  }

}