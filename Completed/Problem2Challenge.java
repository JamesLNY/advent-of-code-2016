import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2Challenge {
  public static void main(String[] args) {
    int xIndex = -2, yIndex = 0;
    int[][] table = {{0, 0, 1, 0, 0}, {0, 2, 3, 4, 0}, {5, 6, 7, 8, 9}, {0, 10, 11, 12, 0}, {0, 0, 13, 0, 0}};
    String stringInput, result = "";
    try {
      File file = new File("Input2.txt");
      Scanner input = new Scanner(file);
      while (input.hasNext()) {
        stringInput = input.next();
        for (int i = 0; i < stringInput.length(); i++) {
          char c = stringInput.charAt(i);
          switch (c) {
            case 'U':
              yIndex--;
              if (Math.abs(xIndex) + Math.abs(yIndex) > 2) yIndex++;
              break;
            case 'L':
              xIndex--;
              if (Math.abs(xIndex) + Math.abs(yIndex) > 2) xIndex++;
              break;
            case 'R':
              xIndex++;
              if (Math.abs(xIndex) + Math.abs(yIndex) > 2) xIndex--;
              break;
            case 'D':
              yIndex++;
              if (Math.abs(xIndex) + Math.abs(yIndex) > 2) yIndex--;
              break;
          }
        }
        if (table[yIndex + 2][xIndex + 2] >= 10) {
          switch (table[yIndex + 2][xIndex + 2]) {
            case 10:
              result += 'A';
              break;
            case 11:
              result += 'B';
              break;
            case 12:
              result += 'C';
              break;
            case 13:
              result += 'D';
              break;
          }
        } else {
          result += table[yIndex + 2][xIndex + 2];
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    System.out.println(result);
  }
}
