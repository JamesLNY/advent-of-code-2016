import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1Challenge {
  public static int solve() {
    int[][] arr = new int[1000][1000];
    int xCord = 500, yCord = 500, direction = 1;
    String stringInput;
    try {
      File file = new File("Input1.txt");
      try (Scanner input = new Scanner(file)) {
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
          for (int i = 0; i < Integer.parseInt(stringInput); i++) {
            if (arr[xCord][yCord] == 1) return Math.abs(xCord - 500) + Math.abs(yCord - 500);
            arr[xCord][yCord] = 1;
            switch (direction) {
              case 0:
                xCord++;
                break;
              case 1:
                yCord++;
                break;
              case 2:
                xCord--;
                break;
              case 3:
                yCord--;
            }
          }
        }
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return 0;
  }
  public static void main(String[] args) {
    System.out.println(solve());
  }
}