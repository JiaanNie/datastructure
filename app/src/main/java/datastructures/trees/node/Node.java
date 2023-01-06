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

  public Node(T data, Node<T> leftChild, Node<T> rightChild) {
    this.leftChild = leftChild;
    this.rightChild = rightChild;
    this.data = data;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public int compareTo(Node<T> o) {
    return this.data.compareTo(o.getData());
  }
}
