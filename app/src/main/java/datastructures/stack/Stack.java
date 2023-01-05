package datastructures.stack;

import datastructures.linklist.doublelinked.DoubleLinkedList;
// stack is FILO first in last out 

public class Stack<T> {
  private DoubleLinkedList<T> stack;
  private int size;

  public Stack() {
    this.stack = new DoubleLinkedList<T>();
    this.size = stack.size();

  }

  public Stack(T data) {
    this.stack = new DoubleLinkedList<T>(data);
    this.size = stack.size();
  }

  // anytime adding element you added it to the head
  public void push(T data) {
    this.size++;
    stack.addElementToHead(data);
  }

  // anytime removing element you remove from top to bottom
  public T pop() {
    this.size--;
    return stack.removeFirstElement();

  }

}