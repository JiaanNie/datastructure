package datastructures.trees.node;

public class Node<T extends Comparable<T>> {
  T data;
  public Node<T> leftChild;
  public Node<T> rightChild;

  public Node(T data) {
    this.leftChild = null;
    this.rightChild = null;
    this.data = data;
  }

  public T getData() {
    return this.data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
}
