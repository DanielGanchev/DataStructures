package exercises;

import java.util.HashSet;
import java.util.Set;

public class HashTableExerciseHasUniqueChar {

  public static boolean hasUniqueChars(String string) {
    Set<Character> charSet = new HashSet<>();

    for (char ch : string.toCharArray()) {
      if (charSet.contains(ch)) {
        return false;
      }
      charSet.add(ch);
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(hasUniqueChars("abcdefg")); // should return true
    System.out.println(hasUniqueChars("hello")); // should return false
    System.out.println(hasUniqueChars("")); // should return true
    System.out.println(hasUniqueChars("0123456789")); // should return true
    System.out.println(hasUniqueChars("abacadaeaf")); // should return false

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
            true
            false

        */

  }



}
