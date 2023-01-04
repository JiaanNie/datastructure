package doublelinkedlist;

import linklist.node.Node;

public class DoubleLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public DoubleLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public DoubleLinkedList(T data) {
    this.head = this.tail = new Node<T>(data);
    this.size = 1;
  }

  public void addElementToTail(T data) {
    Node<T> node = new Node<T>(data);

    // check to see if this is the first node being added to the list
    if (this.head == null && this.tail == null) {
      this.head = this.tail = node;
    } else {
      this.tail.next = node;
      node.previous = this.tail;
      this.tail = node;
    }
    this.size += 1;

  }

  public void addElementToHead(T data) {
    Node<T> node = new Node<T>(data);

    // check to see if this is the first node being added to the list
    if (this.head == null && this.tail == null) {
      this.head = this.tail = node;
    } else {
      this.head.previous = node;
      node.next = head;
      head = node;

    }
    this.size += 1;

  }

  public T removeFirstElement() {
    if (this.head == null) {
      throw new RuntimeException("empty list");
    }
    T data = this.head.getData();
    Node<T> temp = this.head;
    this.head = this.head.next;
    temp.next = null;
    this.head.previous = null;
    return data;

  }

  public T removeLastElement() {
    if (this.head == null) {
      throw new RuntimeException("empty list");
    }
    T data = this.tail.getData();
    Node<T> temp = this.tail;
    this.tail = this.tail.previous;
    temp.previous = null;
    this.head.next = null;
    this.size--;

    return data;

  }

  public T removeElementAt(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
    T data = null;
    Node<T> tempPointer = this.head;
    for (int i = 0; i <= index; i++) {
      if (i == index) {
        data = tempPointer.getData();
        Node<T> nextNode = tempPointer.next;
        Node<T> previousNode = tempPointer.previous;
        if (nextNode == null) {
          previousNode.next = null;
          tempPointer.previous = null;
          this.tail = previousNode;

        } else if (previousNode == null) {
          nextNode.previous = null;
          tempPointer.next = null;
          this.head = nextNode;
        } else if (previousNode != null && nextNode != null) {
          previousNode.next = nextNode;
          nextNode.previous = previousNode;
        }
      }
      tempPointer = tempPointer.next;

    }
    this.size--;
    return data;

  }

  public boolean isEmpty() {
    return this.size == 0;

  }

  public T peakFirstElement() {
    if (this.size == 0) {
      throw new RuntimeException("empty list");
    }
    return this.head.getData();

  }

  public T peakLastElement() {
    if (this.size == 0) {
      throw new RuntimeException("empty list");
    }
    return this.tail.getData();
  }

  public int indexOf(Object obj) {
    if (this.size == 0) {
      throw new RuntimeException("empty list");
    }
    Node<T> temp = this.head;
    if (obj == null) {
      for (int index = 0; temp != null; temp = temp.next, index++) {
        if (temp.getData() == null) {
          return index;
        }
      }
    } else {
      for (int index = 0; temp != null; temp = temp.next, index++) {
        if (obj.equals(temp.getData())) {
          return index;
        }
      }
    }
    return -1;

  }

  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  public int size() {
    return this.size;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    String next;
    String previous;
    sb.append("[ ");
    Node<T> trav = head;
    while (trav != null) {
      if (trav.next == null) {
        next = "null";
      } else {
        next = Integer.toString(trav.next.hashCode());
      }

      if (trav.previous == null) {
        previous = "null";
      } else {
        previous = Integer.toString(trav.previous.hashCode());
      }

      String data = String.format("( previous node: %s current node: %s next node: %s data: %s)",
          previous,
          trav.hashCode(),
          next,
          trav.getData());

      sb.append(data + ", ");

      trav = trav.next;
    }
    sb.append(" ]");
    return sb.toString();
  }

}
