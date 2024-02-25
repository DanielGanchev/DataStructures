public class Main {

  public static void main(String[] args) {





  }

  public static void bubbleSort(int[] array) {
    for (int i = array.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j] > array[j+1]) {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
  }

  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int minIndex = i;
      for (int j = i+1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
  }

  public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = i;
      int temp = array[i];
      while (j > 0 && array[j-1] > temp) {
        array[j] = array[j-1];
        j--;
      }
      array[j] = temp;
    }
  }

  public static int[] mergeSort(int[] array) {
    if (array.length <= 1) {
      return array;
    }
    int midpoint = array.length / 2;
    int[] left = new int[midpoint];
    int[] right;
    if (array.length % 2 == 0) {
      right = new int[midpoint];
    } else {
      right = new int[midpoint + 1];
    }
    for (int i = 0; i < midpoint; i++) {
      left[i] = array[i];
    }
    for (int j = 0; j < right.length; j++) {
      right[j] = array[midpoint+j];
    }
    int[] result = new int[array.length];
    left = mergeSort(left);
    right = mergeSort(right);
    result = merge(left, right);
    return result;

  }

  public static int[] merge(int[] array1, int[] array2) {
    int[] combined = new int[array1.length + array2.length];
    int index = 0;
    int i = 0;
    int j = 0;
    while (i < array1.length && j < array2.length) {
      if (array1[i] < array2[j]) {
        combined[index] = array1[i];
        index++;
        i++;
      } else {
        combined[index] = array2[j];
        index++;
        j++;
      }
    }
    while (i < array1.length) {
      combined[index] = array1[i];
      index++;
      i++;
    }
    while (j < array2.length) {
      combined[index] = array2[j];
      index++;
      j++;
    }
    return combined;
  }

  private static void swap(int[] array, int firstIndex, int secondIndex) {
    int temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
  }

  private static int pivot(int[] array, int pivotIndex, int endIndex) {
    int swapIndex = pivotIndex;
    for (int i = pivotIndex + 1; i <= endIndex; i++) {
      if (array[i] < array[pivotIndex]) {
        swapIndex++;
        swap(array, swapIndex, i);
      }
    }
    swap(array, pivotIndex, swapIndex);

    return swapIndex;
  }

  public static void quickSortHelper(int[] array, int left, int right) {
    if (left < right) {
      int pivotIndex = pivot(array, left, right);
      quickSortHelper(array, left, pivotIndex - 1);
      quickSortHelper(array, pivotIndex + 1, right);
    }
  }


}
