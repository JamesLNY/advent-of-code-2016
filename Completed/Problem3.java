import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3 {
  public static boolean isTriangle(int a, int b, int c) {
    if (a + b <= c) return false;
    if (a + c <= b) return false;
    if (b + c <= a) return false;
    return true;
  }

  public static int countTrianglesA(String filename) {
    int count = 0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while(input.hasNext()){
        if (isTriangle(input.nextInt(), input.nextInt(), input.nextInt())) {
          count++;
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      return 0;
    }
    return count;
  }

  public static int countTrianglesB(String filename) {
    int count = 0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      int[] sides = new int[9];
      while(input.hasNext()){
        for (int i = 0; i < 9; i++) sides[i] = input.nextInt();
        if (isTriangle(sides[0], sides[3], sides[6])) count++;
        if (isTriangle(sides[1], sides[4], sides[7])) count++;
        if (isTriangle(sides[2], sides[5], sides[8])) count++;
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      return 0;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countTrianglesB("Input3.txt"));
  }
}
