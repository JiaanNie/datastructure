package datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import datastructures.dynamiclist.DynamicList;

class DynamicListTest {
  private static final Logger logger = Logger.getLogger(DynamicListTest.class.getName());

  @Test
  void listCreation() {
    DynamicList<Integer> list = new DynamicList<Integer>();
    assertEquals(2, list.capacity());
    logger.info("passed");
  }

  @Test
  void addElementToList() {
    DynamicList<Integer> list = new DynamicList<Integer>();
    assertEquals(2, list.capacity());

    // make sure the list can dynamic expan and keep the old values
    list.add(1);
    list.add(2);
    list.add(2);
    assertEquals(4, list.capacity());
    assertEquals(1, list.getElementAt(0));
    assertEquals(2, list.getElementAt(1));
    logger.info("passed");
  }

}
