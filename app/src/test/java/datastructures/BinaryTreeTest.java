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

    // lmao the search is a infiniate loop fix it tomorrow
    elements = tree.breadthFirstSearch();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < elements.size(); i++) {
      sb.append(Integer.toString(elements.getElementAt(i).getData()) + ",");
    }
    logger.info(sb.toString());
    Node<Integer> target = new Node<Integer>(14);
    Node<Integer>[] results = tree.findTargetNodeParent(target);
    if (results[0] == null) {
      logger.info("null");
    } else {
      logger.info(results[0].getData().toString());
      logger.info(results[1].getData().toString());
    }
    Integer data2 = tree.removeNode(12);
    Integer data3 = tree.removeNode(15);
    logger.info(data2.toString());

  }

}
