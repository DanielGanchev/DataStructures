package linkedlist;



public class LinkedList {

  private int length;
  private Node head;
  private Node tail;

  class Node {

    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }

  }

  public LinkedList(int value) {
    head = new Node(value);
    tail = head;
    length = 1;
  }

  public void printList() {
    Node current = head;
    while (current != null) {
      System.out.print(current.value + " ");
      current = current.next;
    }
  }

  public void getHead() {
    System.out.println("Head: " + head.value);
  }

  public void getTail() {
    System.out.println("Tail: " + tail.value);
  }

  public void getLength() {
    System.out.println("Length: " + length);
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if (length == 0) {
      return null;
    }
    Node temp = head;
    Node preTail = head;
    while (temp.next != null) {
      preTail = temp;
      temp = temp.next;
    }
    tail = preTail;
    preTail.next = null;
    length--;
    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;

  }

  public Node removeFirst() {
    if (length == 0) {
      return null;
    }
    Node temp = head;
    head = head.next;
    temp.next = null;
    length--;
    if (length == 0) {

      tail = null;
    }
    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node temp = get(index);
    if (temp != null) {
      temp.value = value;
      return true;
    }
    return false;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }
    if (index == 0) {
      prepend(value);
      return true;
    }
    if (index == length) {
      append(value);
      return true;
    }
    Node newNode = new Node(value);
    Node temp = get(index - 1);
    newNode.next = temp.next;
    temp.next = newNode;
    length++;
    return true;
  }

  public Node remove(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == length - 1) {
      return removeLast();
    }
    Node temp = get(index - 1);
    Node removed = temp.next;
    temp.next = removed.next;
    removed.next = null;
    length--;
    return removed;
  }

  public void reverse() {
    Node temp = head;
    head = tail;
    tail = temp;
    Node after = temp.next;
    Node before = null;

    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }

    System.out.println("n\\/a");
  }

  public Node findMiddleNode() {
    Node slowPointer = head;
    Node fastPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }
    return slowPointer;
  }

  public void makeEmpty() {
    head = null;
    tail = null;
    length = 0;
  }

  public boolean hasLoop() {
    Node slowPointer = head;
    Node fastPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;

      if (slowPointer == fastPointer) {
        return true;
      }
    }
    return false;
  }


  public Node findKthFromEnd(int k) {

    Node slowPointer = head;
    Node fastPointer = head;

    for (int i = 0; i < k; i++) {
      if (fastPointer == null) {
        return null;
      }
      fastPointer = fastPointer.next;
    }

    while (fastPointer != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next;
    }
    return slowPointer;

  }

  public void partitionList(int x) {
    Node beforeHead = new Node(0);
    Node before = beforeHead;
    Node afterHead = new Node(0);
    Node after = afterHead;

    Node temp = head;

    while (temp != null) {
      if (temp.value < x) {
        before.next = temp;
        before = temp;
      } else {
        after.next = temp;
        after = temp;
      }
      temp = temp.next;
    }
    after.next = null;
    before.next = afterHead.next;
    head = beforeHead.next;
  }

  public void removeDuplicates() {
    Node current = head;
    while (current != null) {
      Node temp = current;
      while (temp != null && temp.value == current.value) {
        temp = temp.next;
      }
      current.next = temp;
      current = current.next;
    }
  }

  public int binaryToDecimal() {
    Node temp = head;
    int result = 0;
    while (temp != null) {
      result = result * 2 + temp.value;
      temp = temp.next;
    }
    return result;
  }



  public void reverseBetween(int startIndex, int endIndex) {
    if (head == null) return;

    Node dummyNode = new Node(0);
    dummyNode.next = head;
    Node previousNode = dummyNode;

    for (int i = 0; i < startIndex; i++) {
      previousNode = previousNode.next;
    }

    Node currentNode = previousNode.next;

    for (int i = 0; i < endIndex - startIndex; i++) {
      Node nodeToMove = currentNode.next;
      currentNode.next = nodeToMove.next;
      nodeToMove.next = previousNode.next;
      previousNode.next = nodeToMove;
    }

    head = dummyNode.next;
  }



  }














