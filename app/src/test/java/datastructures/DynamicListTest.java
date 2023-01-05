package datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;
import datastructures.dynamiclist.DynamicList;

class DynamicListTest {
  private static final Logger logger = Logger.getLogger(DynamicListTest.class.getName());

  @Test
  void listCreation() {
    DynamicList<String> list = new DynamicList<String>();
    list.add("1");
    list.add("2");
    assertEquals(2, list.size());
    logger.info("passed");
  }
}
