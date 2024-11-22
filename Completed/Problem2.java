import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2 {
  public static void main(String[] args) {
    int xIndex = 1, yIndex = 1;
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
              if (yIndex > 0) yIndex--;
              break;
            case 'L':
              if (xIndex > 0) xIndex--;
              break;
            case 'R':
              if (xIndex < 2) xIndex++;
              break;
            case 'D':
              if (yIndex < 2) yIndex++;
              break;
          }
        }
        result += xIndex + 1 + yIndex * 3;
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    System.out.println(result);
  }
}
