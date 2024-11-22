import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Problem20 {
  public static void main(String[] args) {
    ArrayList<Long> starts = new ArrayList<Long>(), ends = new ArrayList<Long>();
    try {
      String[] s;
      File file = new File("Input20.txt");
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        s = input.nextLine().split("-");
        starts.add(Long.parseLong(s[0]));
        ends.add(Long.parseLong(s[1]));
      }
      input.close();
      long index = 0;
      long count = 0;
      boolean completed;
      while (index < 4294967292L) {
        completed = false;
        for (int i = 0; i < starts.size(); i++) {
          if (starts.get(i) <= index && ends.get(i) >= index) {
            index = ends.get(i) + 1;
            completed = true;
          }
        }
        if (! completed) {
          count++;
          index++;
        }
      }
      System.out.println(count);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
}
}
