package algorithms.search;

import datastructures.queue.Queue;
import datastructures.dynamiclist.DynamicList;

public class BreadthFirstSearch<T> {
  Queue<T> queue;
  DynamicList<T> vistedElements;
  

  public BreadthFirstSearch() {
    this.queue = new Queue<T>();
    this.vistedElements = new DynamicList<T>();


  }

  public T search(T tree, T target) {
    T pointer = null;
    return pointer;

  }

}