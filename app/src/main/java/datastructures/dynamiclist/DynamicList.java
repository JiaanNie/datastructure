package datastructures.dynamiclist;

@SuppressWarnings("unchecked")
public class DynamicList<T> {
  private T[] array;
  private int length;
  private int capacity;

  public DynamicList() {
    this(2);
  }

  public DynamicList(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Illegal Capacity: " + capacity);
    }
    length = 0;
    this.capacity = capacity;
    // cast object array to T type array with a fix size
    this.array = (T[]) new Object[capacity];

  }

  // inserting might be a bit hard becase you need to figure it out how to compare
  // objects of type T

  public void add(T element) {
    // append the new elemnt to the end of the array
    if (this.length + 1 > this.capacity) {
      this.capacity = this.capacity * 2;
      // create new array of type T with double capacity
      T[] newArray = (T[]) new Object[capacity];
      for (int i = 0; i < this.length; i++) {
        // copy old element over to the new array
        newArray[i] = this.array[i];
      }
      this.array = newArray;
    }
    this.array[this.length] = element;
    this.length += 1;
  }

  public T removeElementAt(int index) {
    if (index >= this.length || index < 0)
      throw new IndexOutOfBoundsException();

    T data = this.array[index];
    // when copy the element over to the new array and skip the one we are removing
    T[] newArray = (T[]) new Object[this.length - 1];
    for (int i = 0, j = 0; i < length; i++, j++) {
      if (i == index) {
        j -= 1;
      } else {
        newArray[j] = this.array[i];
      }

    }
    this.array = newArray;
    this.length -= 1;
    this.capacity = this.length;

    // this is a guard incease if capacity is 0 reset the array capacity to 2
    if (this.capacity == 0) {
      this.capacity = 2;
      T[] arr = (T[]) new Object[this.capacity];
      this.array = arr;
    }
    return data;

  }

  public int indexOf(T element) {
    for (int i = 0; i < this.length; i++) {
      if (element == null) {
        if (this.array[i] == null)
          return i;
      } else {
        if (element.equals(this.array[i]))
          return i;
      }
    }
    return -1;
  }

  public boolean contains(T element) {
    return indexOf(element) != -1;
  }

  public T getElementAt(int index) {
    return this.array[index];
  }

  public int size() {
    return this.length;
  }

  public int capacity() {
    return this.capacity;
  }

  public boolean isEmpty() {
    return this.length == 0;
  }

  public void clear() {
    this.length = 0;
    for (int i = 0; i < this.length; i++) {
      this.array[i] = null;
    }
    this.length = 0;
  }

}