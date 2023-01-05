package datastructures.linklist;

public class Node<T> {
  T data;
  public Node<T> next;
  public Node<T> previous;

  public Node(T data) {
    this.next = null;
    this.previous = null;
    this.data = data;
  }

  public Node(T data, Node<T> next) {
    this.next = next;
    this.previous = null;
    this.data = data;
  }

  public Node(T data, Node<T> next, Node<T> previous) {
    this.next = next;
    this.previous = previous;
    this.data = data;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

}
