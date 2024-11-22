import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem22 {
  public static void main(String[] args) {
    try {
      ArrayList<Integer> used = new ArrayList<Integer>(), available = new ArrayList<Integer>(), percentages = new ArrayList<Integer>();
      String s;
      File file = new File("Input22.txt");
      Scanner input = new Scanner(file);
      while (input.hasNext()) {
        input.next();
        input.next();
        s = input.next();
        used.add(Integer.parseInt(s.substring(0, s.length() - 1)));
        s = input.next();
        available.add(Integer.parseInt(s.substring(0, s.length() - 1)));
        s = input.next();
        percentages.add(Integer.parseInt(s.substring(0, s.length() - 1)));
      }
      int answer = 0;
      used.sort(null);
      while (used.get(0) == 0) {
        used.removeFirst();
      }
      available.sort(null);
      input.close();
      int usedPos = 0, availablePos = 0;
      while (availablePos < available.size()) {
        while (used.get(usedPos) <= available.get(availablePos)) {
          if (usedPos == used.size()) break;
          usedPos++;
        }
        answer += usedPos;
        availablePos++;
      }
      for (int i : percentages) {
        if (i < 50 && i != 0) {
          answer--;
        }
      }
      System.out.println(answer);
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
  }
}
