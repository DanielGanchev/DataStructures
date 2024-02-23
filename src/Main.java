public class Main {

  public static void main(String[] args) {
    String first = "George";
    String second = "Peter";

    System.out.println(sumOfCharsCodesMultiplied(first,second));
  }

  public static int sumOfCharsCodesMultiplied(String first,String second){
    int sum = 0;
    int minLength = Math.min(first.length(),second.length());
    for (int i = 0; i < minLength; i++) {
      sum += first.charAt(i) * second.charAt(i);
    }
    if (first.length() > second.length()){
      for (int i = minLength; i < first.length(); i++) {
        sum += first.charAt(i);
      }
    }else {
      for (int i = minLength; i < second.length(); i++) {
        sum += second.charAt(i);
      }
    }

    return sum;
  }

}
