package datastructures.queue;

// Queue FIFO first in first out

// enqueue put item at the back/tail of the line

import datastructures.linklist.doublelinked.DoubleLinkedList;

public class Queue<T> {
  DoubleLinkedList<T> queue;
  int size;

  public Queue() {
    this.queue = new DoubleLinkedList<T>();
    this.size = this.queue.size();
  }

  public void enqueue(T element) {
    // enqueue put item at the back/tail of the line
    this.queue.addElementToTail(element);
    this.size++;
  }

  public T dequeue() {
    // dequeue remove item at the head of the line
    T data = this.queue.removeFirstElement();
    this.size--;
    return data;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public T peekFirstElement() {
    return queue.peakFirstElement();
  }

  public T peekLastElement() {
    return queue.peakLastElement();
  }

}
