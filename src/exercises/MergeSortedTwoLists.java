package exercises;

public class MergeSortedTwoLists {

  public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
      int value;
      Node next;

      Node(int value) {
        this.value = value;
      }
    }

    public LinkedList(int value) {
      Node newNode = new Node(value);
      head = newNode;
      tail = newNode;
      length = 1;
    }

    public Node getHead() {
      return head;
    }

    public Node getTail() {
      return tail;
    }

    public int getLength() {
      return length;
    }

    public void makeEmpty() {
      head = null;
      tail = null;
      length = 0;
    }

    public void printList() {
      Node temp = head;
      while (temp != null) {
        System.out.println(temp.value);
        temp = temp.next;
      }
    }

    public void printAll() {
      if (length == 0) {
        System.out.println("Head: null");
        System.out.println("Tail: null");
      } else {
        System.out.println("Head: " + head.value);
        System.out.println("Tail: " + tail.value);
      }
      System.out.println("Length:" + length);
      System.out.println("\nLinked List:");
      if (length == 0) {
        System.out.println("empty");
      } else {
        printList();
      }
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

    public void merge(LinkedList list) {

      if (list.getLength() == 0) {
        return;
      }
      if (length == 0) {
        head = list.getHead();
        tail = list.getTail();
        length = list.getLength();
        return;
      }
      Node current = head;
      Node next = current.next;
      Node listCurrent = list.getHead();
      Node listNext = listCurrent.next;
      while (current != null && listCurrent != null) {
        if (current.value <= listCurrent.value && (next == null || current.value <= listCurrent.value && listCurrent.value <= next.value)) {
          current.next = listCurrent;
          listCurrent.next = next;
          current = listCurrent;
          listCurrent = listNext;
          if (listNext != null) {
            listNext = listNext.next;
          }
        } else {
          if (next != null) {
            current = next;
            next = next.next;
          } else {
            current = null;
          }
        }
      }
      if (listCurrent != null) {
        tail.next = listCurrent;
        tail = list.getTail();
        length += list.getLength();
      }
    }

    public void bubbleSort() {
      if (length < 2) {
        return;
      }

      Node sortedUtil = null;

      while (sortedUtil != head.next) {
        Node current = head;
        while (current.next != sortedUtil) {
          if (current.value > current.next.value) {
            int temp = current.value;
            current.value = current.next.value;
            current.next.value = temp;
          }
          current = current.next;
        }
        sortedUtil = current;
      }
    }

    public void selectionSort() {
      if (length < 2) {
        return;
      }
      Node current = head;
      while (current != null) {
        Node min = current;
        Node r = current.next;
        while (r != null) {
          if (min.value > r.value) {
            min = r;
          }
          r = r.next;
        }
        int temp = current.value;
        current.value = min.value;
        min.value = temp;
        current = current.next;
      }
    }

    public void insertionSort() {
      if (length < 2) {
        return;
      }
      Node current = head;
      while (current != null) {
        Node r = current.next;
        while (r != null) {
          if (current.value > r.value) {
            int temp = current.value;
            current.value = r.value;
            r.value = temp;
          }
          r = r.next;
        }
        current = current.next;
      }
    }


  }

}
