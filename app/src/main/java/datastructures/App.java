/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package datastructures;

import datastructures.linklist.doublelinked.DoubleLinkedList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public void createDoubleLinkedList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.addElementToTail("abc");
        list.addElementToHead("dsfsaf");
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        App instance = new App();
        System.out.println(instance.getGreeting());
        instance.createDoubleLinkedList();
    }
}