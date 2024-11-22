import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1 {
  public static void main(String[] args) {
    int xChange = 0, yChange = 0, direction = 1;
    String stringInput;
    try {
      File file = new File("Input1.txt");
      Scanner input = new Scanner(file);
      while (input.hasNext()) {
        stringInput = input.next();
        if (stringInput.charAt(0) == 'L') {
          direction++;
          if (direction == 4) direction = 0;
        } else {
          direction--;
          if (direction == -1) direction = 3;
        }
        stringInput = stringInput.substring(1, stringInput.length() - 1);
        switch (direction) {
          case 0:
            xChange += Integer.parseInt(stringInput);
            break;
          case 1:
            yChange += Integer.parseInt(stringInput);
            break;
          case 2:
            xChange -= Integer.parseInt(stringInput);
            break;
          case 3:
            yChange -= Integer.parseInt(stringInput);
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    System.out.println(Math.abs(xChange) + Math.abs(yChange));
  }
}
