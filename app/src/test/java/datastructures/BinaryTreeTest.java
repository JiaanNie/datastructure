package datastructures;

import datastructures.trees.binarytree.BinarySearchTree;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import datastructures.dynamiclist.DynamicList;
import datastructures.trees.node.Node;

public class BinaryTreeTest {
  private static final Logger logger = Logger.getLogger(BinarySearchTree.class.getName());

  @Test
  void testBinaryTree() {
    BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
    DynamicList<Node<Integer>> elements;
    Integer[] data = new Integer[8];
    data[0] = 15;
    data[1] = 20;
    data[2] = 12;
    data[3] = 30;
    data[4] = 56;
    data[5] = 8;
    data[6] = 14;
    data[7] = 11;
    tree.buildTree(data);
    // elements = tree.breadthFirstSearch();

    // for (int i = 0; i < elements.size(); i++) {
    //   System.out.println(elements.getElementAt(i).getData());
    // }
    logger.info("passed");

  }

}
