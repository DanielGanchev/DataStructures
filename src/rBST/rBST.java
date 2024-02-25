package rBST;

import java.util.ArrayList;

public class rBST {



    private Node root;

    public static class Node {
      public int value;
      public Node left;
      public Node right;

      private Node(int value) {
        this.value = value;
      }
    }

    public Node getRoot() {
      return root;
    }

    public boolean insert(int value) {
      Node newNode = new Node(value);
      if (root == null) {
        root = newNode;
        return true;
      }
      Node temp = root;
      while (true) {
        if (newNode.value == temp.value) return false;
        if (newNode.value < temp.value) {
          if (temp.left == null) {
            temp.left = newNode;
            return true;
          }
          temp = temp.left;
        } else {
          if (temp.right == null) {
            temp.right = newNode;
            return true;
          }
          temp = temp.right;
        }
      }
    }

    public boolean contains(int value) {
      if (root == null) return false;
      Node temp = root;
      while (temp != null) {
        if (value < temp.value) {
          temp = temp.left;
        } else if (value > temp.value) {
          temp = temp.right;
        } else {
          return true;
        }
      }
      return false;
    }


    private boolean rContains(Node currentNode, int value) {
      if (currentNode == null) return false;

      if (currentNode.value == value) return true;

      if (value < currentNode.value) {
        return rContains(currentNode.left, value);
      } else {
        return rContains(currentNode.right, value);
      }
    }
    public boolean rContains(int value) { return rContains(root, value); }


    private Node rInsert(Node currentNode, int value) {
      if (currentNode == null) return new Node(value);

      if (value < currentNode.value) {
        currentNode.left = rInsert(currentNode.left, value);
      } else if (value > currentNode.value) {
        currentNode.right = rInsert(currentNode.right, value);
      }
      return currentNode;
    }
    public void rInsert(int value) {
      if (root == null) root = new Node(value);
      rInsert(root, value);
    }

    public int minValue(Node currentNode) {
      while (currentNode.left != null) {
        currentNode = currentNode.left;
      }
      return currentNode.value;
    }

  public void deleteNode(int value) {
    root = deleteNode(root, value);




  }

  private Node deleteNode(Node currentNode, int value) {
    if (currentNode == null) return null;

    if (value < currentNode.value) {
      currentNode.left = deleteNode(currentNode.left, value);
    } else if (value > currentNode.value) {
      currentNode.right = deleteNode(currentNode.right, value);
    } else {
      if (currentNode.left == null && currentNode.right == null) {
        return null;
      } else if (currentNode.left == null) {
        currentNode = currentNode.right;
      } else if (currentNode.right == null) {
        currentNode = currentNode.left;
      } else {
        int subTreeMin = minValue(currentNode.right);
        currentNode.value = subTreeMin;
        currentNode.right = deleteNode(currentNode.right, subTreeMin);
      }
    }
    return currentNode;
  }

  public ArrayList<Integer> BFS() {
    ArrayList<Integer> result = new ArrayList<>();
    ArrayList<Node> queue = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node currentNode = queue.remove(0);
      result.add(currentNode.value);
      if (currentNode.left != null)
        queue.add(currentNode.left);
      if (currentNode.right != null)
        queue.add(currentNode.right);
    }
    return result;
  }

  public ArrayList<Integer> DFSPreOrder() {
    ArrayList<Integer> results = new ArrayList<>();

    class Traverse {
      Traverse(Node currentNode) {
        results.add(currentNode.value);
        if (currentNode.left != null) {
          new Traverse(currentNode.left);
        }
        if (currentNode.right != null) {
          new Traverse(currentNode.right);
        }
      }
    }

    new Traverse(root);
    return results;
  }

  public ArrayList<Integer> DFSPostOrder() {
    ArrayList<Integer> results = new ArrayList<>();

    class Traverse {
      Traverse(Node currentNode) {
        if (currentNode.left != null) {
          new Traverse(currentNode.left);
        }
        if (currentNode.right != null) {
          new Traverse(currentNode.right);
        }
        results.add(currentNode.value);
      }
    }

    new Traverse(root);
    return results;
  }

  public ArrayList<Integer> DFSInOrder() {
    ArrayList<Integer> results = new ArrayList<>();

    class Traverse {

      Traverse(Node currentNode) {
        if (currentNode.left != null) {
          new Traverse(currentNode.left);
        }
        results.add(currentNode.value);
        if (currentNode.right != null) {
          new Traverse(currentNode.right);
        }
      }
    }

    new Traverse(root);
    return results;
  }



  }



