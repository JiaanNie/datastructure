package src.main;

// import java.util.Arrays;
// import src.datastructures.dynamiclist.DynamicList;
import src.datastructures.linklist.doublelinked.DoubleLinkedList;
import src.datastructures.linklist.singlelinked.SingleLinkedList;

class Main {
  public static void main(String[] args) {
    // DynamicList<String> mylist = new DynamicList<String>();
    // System.out.println(mylist.length);
    // System.out.println(mylist.capacity);
    // mylist.add("dfadf");
    // System.out.println(mylist.length);
    // System.out.println(mylist.capacity);
    // mylist.removeElementAt(0);
    // System.out.println(Arrays.toString(mylist.array));
    // System.out.println(mylist.length);
    // System.out.println(mylist.capacity);

    // mylist.add("dfadf");
    // System.out.println(Arrays.toString(mylist.array));
    // System.out.println(mylist.length);
    // System.out.println(mylist.capacity);

    // DoubleLinkedList<String> linkedlist = new DoubleLinkedList<String>();
    // System.out.println(linkedlist.size());
    // linkedlist.addElementLast("abc");
    // System.out.println(linkedlist.peakFirstElement());
    // linkedlist.addElementLast("efg");

    // System.out.println(linkedlist.peakFirstElement());
    // System.out.println(linkedlist.peakLastElement());
    // ;
    // linkedlist.removeElementAt(0);
    // linkedlist.addElementLast("efg");
    // linkedlist.addElementLast("efg");
    // linkedlist.addElementLast("efg");
    // linkedlist.addElementLast("efg");
    // linkedlist.addElementLast("efg");

    // System.out.println(linkedlist.toString());

    SingleLinkedList<String> ls = new SingleLinkedList<String>();
    ls.addElementToTail("0");
    ls.addElementToTail("1");
    // ls.addElementToTail("2");
    // ls.addElementToTail("3");
    // ls.addElementToTail("4");

    ls.removeElementAt(1);
    ls.removeElementAt(0);

    System.out.println(ls.size());

  }

}
