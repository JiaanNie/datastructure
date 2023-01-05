package datastructures;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import datastructures.linklist.doublelinked.DoubleLinkedList;

public class DoubleLinkedListTest {
  private static final Logger logger = Logger.getLogger(DoubleLinkedList.class.getName());

  @Test
  void testDoublelinkedList() {
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    list.addElementToHead(1);
    assertNull(list.getHead().previous);
    assertNull(list.getHead().next);
    logger.info("passed");

  }

}