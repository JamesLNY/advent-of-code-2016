import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem7 {
  public static boolean evaluate(String s) {
    boolean b = false, hasThing = false;
    for (int i = 0; i < s.length() - 3; i++) {
      if (s.charAt(i) == '[') {
        b = true;
      }
      if (s.charAt(i) == ']') b = false;
      if (s.charAt(i) == s.charAt(i + 3) && s.charAt(i + 1) == s.charAt(i + 2) && s.charAt(i) != s.charAt(i + 1)) {
        if (b) {
          return false;
        } else {
          hasThing = true;
        }
      }
    }
    return hasThing;
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
