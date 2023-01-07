package datastructures.trees.binarayheap;

import datastructures.trees.node.Node;

// invariant children will never be greater then it parent 

// going to use iterative O(1) for space method instead of recursive O(LogN) for space

public class BinarayHeap<T extends Comparable<T>> {
  Node<T> root;
  int size;

  public BinarayHeap() {
    this.root = null;
    this.size = 0;
  }

  public BinarayHeap(Node<T> root) {
    this.root = root;
    this.size = 1;
  }

  public void swaim() {

  }

  public void sink() {

  }

  public void balanceTree() {

  }

  

  public void insertElement(Node<T> node) {
    if (this.root == null) {
      this.root = node;
    }
    else {
      Node<T> currentNodePointer = this.root;
      while (currentNodePointer != null) {
        currentNodePointer = currentNodePointer.leftChild;





      }

      
  




    }

  }



  public Node<T> removeElement(Node<T> node) {
    return null;
  }

}
