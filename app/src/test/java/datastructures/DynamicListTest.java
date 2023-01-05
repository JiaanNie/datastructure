package datastructures;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;
import datastructures.dynamiclist.DynamicList;

class DynamicListTest {
  private static final Logger logger = Logger.getLogger(DynamicListTest.class.getName());

  @Test
  void listCreation() {
    datastructures.dynamiclist.DynamicList<String> list = new DynamicList<String>();
    list.add("test");
    list.add("abdc");
    logger.info(Integer.toString(list.size()));
  }
}
