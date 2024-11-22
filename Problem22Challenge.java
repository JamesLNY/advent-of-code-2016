import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem22Challenge {
  public static void main(String[] args) {
    try {
      int used;
      String s;
      File file = new File("Input22.txt");
      Scanner input = new Scanner(file);
      for (int i = 0; i < 34; i++) {
        for (int n = 0; n < 30; n++) {
          input.next();
          input.next();
          s = input.next();
          used = Integer.parseInt(s.substring(0, s.length() - 1));
          input.next();
          input.next();
          if (used > 100) {
            System.out.print('#');
          } else if (used == 0) {
            System.out.print('_');
          } else {
            System.out.print('.');
          }
        }
        System.out.println();
      }
      input.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
  }
}
