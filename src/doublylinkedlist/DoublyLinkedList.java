package doublylinkedlist;

public class DoublyLinkedList {

  private Node head;
  private Node tail;
  private int length;

  class Node {

    int value;
    Node next;
    Node prev;

    Node(int value) {
      this.value = value;
    }
  }

  public DoublyLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
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
      newNode.prev = tail;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if (length == 0) {
      return null;
    }
    Node temp = tail;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      tail.prev.next = null;
      tail = tail.prev;
      temp.prev = null;
    }
    length--;
    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      head.prev = newNode;
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
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.prev = null;
      temp.next = null;
    }
    length--;
    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    Node current = head;

  if (index < length / 2) {
    for (int i = 0; i < index; i++) {
      current = current.next;

    }
  }else {
    current = tail;
    for (int i = length - 1; i > index; i--) {
      current = current.prev;
    }
  }
    return current;
  }

public  boolean set(int index,int value){
    Node temp = get(index);
    if (temp != null){
      temp.value = value;
      return true;
    }
    return false;
}

public boolean insert(int index,int value) {
  if (index < 0 || index > length) {
    return false;
  } else if (index == 0) {
    prepend(value);
    return true;
  } else if (index == length) {
    append(value);
    return true;
  }
  Node newNode = new Node(value);
  Node beforeNode = get(index - 1);
  Node afterNode = beforeNode.next;

  beforeNode.next = newNode;
  newNode.prev = beforeNode;
  newNode.next = afterNode;
  afterNode.prev = newNode;
  length++;
  return true;
}

public Node remove(int index){
    if (index < 0 || index >= length){
      return null;
    }else if (index == 0){
      return removeFirst();
    }else if (index == length - 1){
      return removeLast();
    }
    Node temp = get(index);
    Node beforeNode = temp.prev;
    Node afterNode = temp.next;

    beforeNode.next = afterNode;
    afterNode.prev = beforeNode;
    temp.prev = null;
    temp.next = null;
    length--;
    return temp;
}
}


