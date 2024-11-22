import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem6 {
  public static void main(String[] args) {
    try {
      String result = "";
      int max = 0, maxIndex = 0;
      int[][] indices = new int[8][26];
      File file = new File("Input6.txt");
      Scanner input = new Scanner(file);
      while (input.hasNext()) {
        String s = input.next();
        for (int i = 0; i < s.length(); i++) {
          indices[i][s.charAt(i) - 'a']++;
        }
      }
      for (int[] column : indices) {
        max = 0;
        for (int i = 0; i < 26; i++) {
          if (column[i] > max) {
            max = column[i];
            maxIndex = i;
          }
        }
        result += (char) ('a' + maxIndex);
      }
      input.close();
      System.out.println(result);
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
  }
}