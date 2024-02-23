package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTable {

  private int size = 7;

  private Node[] dataMap;

  public HashTable() {

    dataMap = new Node[size];
  }


  class Node {

    String key;
    int value;
    Node next;

    Node(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public void printTable() {
    for (int i = 0; i < dataMap.length; i++) {
      System.out.println(i + ":");
      Node current = dataMap[i];
      while (current != null) {
        System.out.println("  {" + current.key + "= " + current.value + "}");
        current = current.next;
      }

    }
  }

  private int hash(String key) {
    int hash = 0;
    for (int i = 0; i < key.length(); i++) {
      hash = (hash + key.charAt(i) * 23) % size;
    }
    return hash;
  }

  public void set(String key, int value) {
    int index = hash(key);
    if (dataMap[index] == null) {
      dataMap[index] = new Node(key, value);
    } else {
      Node current = dataMap[index];
      while (current.next != null) {
        current = current.next;
      }
      current.next = new Node(key, value);
    }
  }

  public int get(String key) {
    int index = hash(key);
    Node current = dataMap[index];
    while (current != null) {
      if (current.key.equals(key)) {
        return current.value;
      }
      current = current.next;
    }
    return 0;
  }

  public ArrayList<String> keys() {
    ArrayList<String> keysArray = new ArrayList<>();
    for (int i = 0; i < dataMap.length; i++) {
      Node temp = dataMap[i];
      while (temp != null) {
        keysArray.add(temp.key);
        temp = temp.next;

      }
    }
    return keysArray;
  }

  public static Character firstNonRepeatingChar(String letter){
    HashMap<Character,Integer> map = new HashMap<>();
    for (int i = 0; i < letter.length(); i++) {
      char c = letter.charAt(i);
      if (map.containsKey(c)){
        map.put(c,map.get(c)+1);
      }else {
        map.put(c,1);
      }
    }
    for (int i = 0; i < letter.length(); i++) {
      char c = letter.charAt(i);
      if (map.get(c) == 1){
        return c;
      }
    }
    return null;
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sorted = new String(charArray);
      if (!map.containsKey(sorted)) {
        map.put(sorted, new ArrayList<>());
      }
      map.get(sorted).add(str);
    }
    return new ArrayList<>(map.values());
  }

  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)){
        return new int[]{map.get(complement),i};
      }
      map.put(nums[i],i);
    }
    return new int[]{};
  }

  public static int[] subarraySum(int[] nums, int target) {
    Map<Integer, Integer> sumIndex = new HashMap<>();
    sumIndex.put(0, -1);
    int currentSum = 0;

    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];
      if (sumIndex.containsKey(currentSum - target)) {
        return new int[]{sumIndex.get(currentSum - target) + 1, i};
      }
      sumIndex.put(currentSum, i);
    }

    return new int[]{};
  }

}
