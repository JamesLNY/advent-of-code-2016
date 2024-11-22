import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Problem7Challenge {
  public static boolean evaluate(String s) {
    ArrayList<String> inside = new ArrayList<String>(), outside = new ArrayList<String>();
    boolean b = false;
    String otherString;
    for (int i = 0; i < s.length() - 2; i++) {
      if (s.charAt(i) == '[') b = true;
      if (s.charAt(i) == ']') b = false;
      if (s.charAt(i) == s.charAt(i + 2) && s.charAt(i) != s.charAt(i + 1)) {
        if (b) {
          inside.add(s.substring(i, i + 3));
        } else {
          outside.add(s.substring(i, i + 3));
        }
      }
    }
    for (String str : inside) {
      otherString = "" + str.charAt(1) + str.charAt(0) + str.charAt(1);
      if (outside.contains(otherString)) return true;
    }
    return false;
  }
  public static void main(String[] args) {
    try {
      String s;
      int count = 0;
      File file = new File("Input7.txt");
      Scanner input = new Scanner(file);
      while (input.hasNext()) {
        s = input.next();
        if (evaluate(s)) count++;
      }
      System.out.println(count);
      input.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}
