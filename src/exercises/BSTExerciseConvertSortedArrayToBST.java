package exercises;

import java.util.ArrayList;
import java.util.List;

public class BSTExerciseConvertSortedArrayToBST {
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

  public List<Integer> inorderTraversal() {
    List<Integer> result = new ArrayList<>();
    inorderHelper(this.root, result);
    return result;
  }

  private void inorderHelper(Node node, List<Integer> result) {
    if (node == null) return;
    inorderHelper(node.left, result);
    result.add(node.value);
    inorderHelper(node.right, result);
  }

  public boolean isBalanced() {
    return height(this.root) != -1;
  }

  private int height(Node node) {
    if (node == null) return 0;
    int leftHeight = height(node.left);
    if (leftHeight == -1) return -1;
    int rightHeight = height(node.right);
    if (rightHeight == -1) return -1;
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public void sortedArrayToBST(int[] nums) {
    this.root = sortedArrayToBST(nums, 0, nums.length - 1);
  }

  private Node sortedArrayToBST(int[] nums, int i, int i1) {

    if (i > i1) {
      return null;
    }
    int mid = i + (i1 - i) / 2;
    Node node = new Node(nums[mid]);
    node.left = sortedArrayToBST(nums, i, mid - 1);
    node.right = sortedArrayToBST(nums, mid + 1, i1);
    return node;
  }
}
