package exercises;

public class ArrayExerciseRemoveDuplicates {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  public static void main(String[] args) {
    ArrayExerciseRemoveDuplicates arrayExerciseRemoveDuplicates = new ArrayExerciseRemoveDuplicates();
    int[] nums = {1, 1, 2};
    System.out.println(arrayExerciseRemoveDuplicates.removeDuplicates(nums));
  }

}
