package datastructures.trees.binarytree;

import datastructures.trees.node.Node;

// element that is smaller then it parent it will insert to the left
// element that is greater then it parent it will insert to the right

public class BinarySearchTree<T extends Comparable<T>> {
  Node<T> root;
  int size;

  public BinarySearchTree() {
    this.root = null;
    this.size = 0;
  }

  public BinarySearchTree(Node<T> root) {
    this.root = root;
    this.size = 1;
  }

  public void addNode(T data) {
    // create a new node and ready to added to the tree
    Node<T> newNode = new Node<T>(data);
    if (this.root == null) {
      this.root = newNode;
    } else {
      Node<T> currentNodePointer = this.root;
      while (currentNodePointer != null) {
        // newNode > currentNode
        if (newNode.compareTo(currentNodePointer) == 1) {
          currentNodePointer = currentNodePointer.rightChild;
          if (currentNodePointer == null) {
            currentNodePointer = newNode;
          }

        }
        // newNode < currentNode
        else if (newNode.compareTo(currentNodePointer) == -1) {
          currentNodePointer = currentNodePointer.leftChild;
          if (currentNodePointer == null) {
            currentNodePointer = newNode;
          }

        }
        // newNode == currentNode
        else {
          // we will do nothing
        }

      }

    }

  }

}
