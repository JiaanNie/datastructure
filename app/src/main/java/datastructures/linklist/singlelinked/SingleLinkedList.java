package singlelinkedlist;

import linklist.node.Node;

public class SingleLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public SingleLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public SingleLinkedList(T data) {
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
    this.size--;
    return data;

  }

  public T removeLastElement() {
    if (this.head == null) {
      throw new RuntimeException("empty list");
    }
    T data = this.tail.getData();

    if (this.size == 1) {
      this.head = null;
      this.tail = null;
    } else {

      Node<T> temp = this.head.next;
      Node<T> temp2 = this.head;
      while (temp != null) {
        temp = temp.next;
        temp2 = temp2.next;
      }
      this.tail = temp2;
      temp2.next = null;

    }
    this.size--;
    return data;

  }

  public T removeElementAt(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
    T data = null;
    if (index == 0) {
      data = removeFirstElement();

    } else if (index == this.size - 1) {
      data = removeLastElement();

    } else {
      // at this point the list has to have 3 or more nodes
      Node<T> previousNode = this.head;
      Node<T> currentNode = previousNode.next;
      Node<T> nextNode = currentNode.next;

      int i = 1;
      while (i != index) {
        previousNode = previousNode.next;
        currentNode = currentNode.next;
        nextNode = nextNode.next;
        i++;
      }
      data = currentNode.getData();
      previousNode.next = nextNode;
      this.size--;
    }

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

      String data = String.format("( %s %s %s data: %s)",
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
