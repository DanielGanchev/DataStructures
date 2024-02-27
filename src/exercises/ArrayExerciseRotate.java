package exercises;

public class ArrayExerciseRotate {

  public void rotate(int[] nums, int k) {
    int[] a = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      a[(i + k) % nums.length] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = a[i];
    }
  }

  public static void main(String[] args) {
    ArrayExerciseRotate arrayExerciseRotate = new ArrayExerciseRotate();
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    arrayExerciseRotate.rotate(nums, k);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

}
