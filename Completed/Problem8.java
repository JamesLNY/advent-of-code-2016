import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem8 {
  public static void rotate(int[][] originalArr, int[][] newArr, String s) {
    boolean x = s.charAt(s.indexOf("=") - 1) == 'x';
    int rowColumn = Integer.parseInt(s.substring(s.indexOf("=") + 1, s.indexOf("=") + 3).trim());
    int rotation = Integer.parseInt(s.substring(s.indexOf("by") + 3));
    if (x) {
      for (int i = 0; i < 6; i++) {
        newArr[i][rowColumn] = originalArr[(6 + (i - rotation) % 6) % 6][rowColumn];
      }
    } else {
      for (int i = 0; i < 50; i++) {
        newArr[rowColumn][i] = originalArr[rowColumn][(50 + (i - rotation)) % 50];
      }
    }
  }
  public static void rect(int[][] originalArr, int[][] newArr, String s) {
    int x = Integer.parseInt(s.substring(s.indexOf("x") - 2, s.indexOf("x")).trim());
    int y = Integer.parseInt(s.substring(s.indexOf("x") + 1));
    for (int i = 0; i < x; i++) {
      for (int n = 0; n < y; n++) {
        newArr[n][i] = 1;
      }
    }
  }
  public static void main(String[] args) {
    try {
      int count = 0;
      int[][] originalArr = new int[6][50];
      int[][] newArr = new int[6][50];
      String s;
      File file = new File("Input8.txt");
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        s = input.nextLine();
        if (s.equals("\n")) continue;
        if (s.substring(0, 4).equals("rect")) {
          rect(originalArr, newArr, s);
        } else {
          rotate(originalArr, newArr, s);
        }
        originalArr = new int[6][50];
        for(int i = 0; i < 6; i++) originalArr[i] = newArr[i].clone();
      }
      input.close();
      for (int i = 0; i < 6; i++) {
        for (int n = 0; n < 50; n++) {
          if (originalArr[i][n] == 1) count++;
        }
      }
      System.out.println(count);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}