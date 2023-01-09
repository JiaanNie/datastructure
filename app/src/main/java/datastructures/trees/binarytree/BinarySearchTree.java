package datastructures.trees.binarytree;

import datastructures.trees.node.Node;
import datastructures.queue.Queue;

import java.lang.reflect.Array;

import datastructures.dynamiclist.DynamicList;

// element that is smaller then it parent it will insert to the left
// element that is greater then it parent it will insert to the right

public class BinarySearchTree<T extends Comparable<T>> {
  Node<T> root;
  int size;

  public BinarySearchTree() {
    this.root = null;
    this.size = 0;
  }

  public BinarySearchTree(Node<T> root) {
    this.root = root;
    this.size = 1;
  }

  public void addNode(T data) {
    // create a new node and ready to added to the tree
    Node<T> newNode = new Node<T>(data);
    if (this.root == null) {
      this.root = newNode;
      this.size++;
    } else {
      Node<T> currentNodePointer = this.root;
      while (true) {
        // newNode > currentNode
        if (newNode.compareTo(currentNodePointer) == 1) {

          if (currentNodePointer.rightChild == null) {
            currentNodePointer.rightChild = newNode;
            this.size++;
            return;
          } else {
            currentNodePointer = currentNodePointer.rightChild;

          }

        }
        // newNode < currentNode
        else if (newNode.compareTo(currentNodePointer) == -1) {
          if (currentNodePointer.leftChild == null) {
            currentNodePointer.leftChild = newNode;
            this.size++;
            return;
          } else {
            currentNodePointer = currentNodePointer.leftChild;
          }

        }
        // newNode == currentNode
        else {
          // we will do nothing
          return;
        }

      }

    }
  }

  public T removeNode(T target) {
    T removedData = null;
    // find the target node and it parent node
    Node<T>[] nodes = findTargetNodeParent(new Node<T>(target));
    Node<T> parentNode = nodes[0];
    Node<T> targetNode = nodes[1];
    if (targetNode == null) {
      throw new NullPointerException("target does not exist in the tree");
    }

    // case 1 removing a leaf node
    if (targetNode.leftChild == null && targetNode.rightChild == null) {
      removeNodeHelper(parentNode, targetNode, null);
      this.size--;
    }

    // case 2 the target node contain left subtree
    else if (targetNode.leftChild != null && targetNode.rightChild == null) {
      // temp pointer pointing to the remaining left sub tree
      removeNodeHelper(parentNode, targetNode, targetNode.leftChild);
      this.size--;

    }
    // case 3 the target node contain right subtree
    else if (targetNode.leftChild == null && targetNode.rightChild != null) {
      removeNodeHelper(parentNode, targetNode, targetNode.rightChild);
      this.size--;
    }

    // case 4 target node contain both left and right subtree
    else {
      // the successor can be largest value in the left subtree
      // keep travel to the right child untill you reach null
      // the smallest vzalue in the right substree
      // keep travel to the left child untill you reach null
      Node<T>[] successors = findSuccessor(targetNode.leftChild);
      Node<T> successorParentNode = successors[0];
      Node<T> largestNode = successors[1];
      targetNode.setData(largestNode.getData());
      parentNode = successorParentNode;
      targetNode = largestNode;
      // swap the content of the two two successor and target node
      // case 1 removing a leaf node
      if (targetNode.leftChild == null && targetNode.rightChild == null) {
        removeNodeHelper(parentNode, targetNode, null);
        this.size--;
      }

      // case 2 the target node contain left subtree
      else if (targetNode.leftChild != null && targetNode.rightChild == null) {
        // temp pointer pointing to the remaining left sub tree
        removeNodeHelper(parentNode, targetNode, targetNode.leftChild);
        this.size--;

      }
      // case 3 the target node contain right subtree
      else if (targetNode.leftChild == null && targetNode.rightChild != null) {
        removeNodeHelper(parentNode, targetNode, targetNode.rightChild);
        this.size--;
      }

    }
    removedData = targetNode.getData();
    return removedData;
  }

  public void buildTree(T[] datas) {
    for (int i = 0; i < datas.length; i++) {
      addNode(datas[i]);
    }
  }

  @SuppressWarnings("unchecked")
  private Node<T>[] findSuccessor(Node<T> leftSubtree) {
    Node<T>[] results = (Node<T>[]) Array.newInstance(Node.class, 2);
    Node<T> largestNode = leftSubtree;
    Node<T> parentNode = leftSubtree;
    while (largestNode.rightChild != null) {
      parentNode = largestNode;
      largestNode = largestNode.rightChild;
    }
    results[0] = parentNode;
    results[1] = largestNode;

    return results;

  }

  private void removeNodeHelper(Node<T> parentNode, Node<T> targetNode, Node<T> subTree) {
    if (parentNode.compareTo(targetNode) == 0) {
      this.root = null;
    } else if (parentNode.compareTo(targetNode) == 1) {
      // parentNode > targetNode the target node is in the left side
      parentNode.leftChild = subTree;
    } else {
      // parentNode < targetNode the target node is in the right side
      parentNode.rightChild = subTree;
    }

  }

  @SuppressWarnings("unchecked")
  public Node<T>[] findTargetNodeParent(Node<T> node) {
    Node<T> targetNode = this.root;
    Node<T> currentNodePointer = this.root;
    Node<T> parentNodePointer = this.root;
    Node<T>[] results = (Node<T>[]) Array.newInstance(Node.class, 2);
    boolean targetFound = false;

    // check if the root node is the one we are looking for
    while (targetFound == false && targetNode != null) {

      if (currentNodePointer.compareTo(node) == 0) {
        // data find
        targetNode = currentNodePointer;
        targetFound = true;
      } else if (node.compareTo(currentNodePointer) == -1) {
        // go to the left subtree node < currentNode
        if (currentNodePointer.leftChild == null) {
          targetNode = null;
        }
        parentNodePointer = currentNodePointer;
        currentNodePointer = currentNodePointer.leftChild;

      } else if (node.compareTo(currentNodePointer) == 1) {
        // go to the right subtree
        if (currentNodePointer.rightChild == null) {
          targetNode = null;
        }
        parentNodePointer = currentNodePointer;
        currentNodePointer = currentNodePointer.rightChild;
      }
    }
    if (targetNode == null) {
      parentNodePointer = null;
    }
    results[0] = parentNodePointer;
    results[1] = targetNode;

    return results;

  }

  public DynamicList<Node<T>> breadthFirstSearch() {
    Queue<Node<T>> queue = new Queue<Node<T>>();
    DynamicList<Node<T>> vistedElements = new DynamicList<Node<T>>();
    Node<T> currentNodePointer = this.root;
    while (vistedElements.size() != this.size) {

      if (vistedElements.contains(currentNodePointer) == true) {
        currentNodePointer = queue.dequeue();
      } else {
        queue.enqueue(currentNodePointer);
        // add the parent node childrens to the queue
        if (currentNodePointer.leftChild != null) {
          queue.enqueue(currentNodePointer.leftChild);
        }
        if (currentNodePointer.rightChild != null) {
          queue.enqueue(currentNodePointer.rightChild);
        }
        vistedElements.add(currentNodePointer);
      }
    }
    return vistedElements;
  }

}
