import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem9 {
    public static void main(String[] args) {
    try {
      File file = new File("Input9.txt");
      Scanner input = new Scanner(file);
      String s = "";
      while (input.hasNext()) {
        s += input.next();
      }
      int i = 0, count = 0;
      String charseq = "", times = "";
      while (i < s.length()) {
        if (s.charAt(i) == '(') {
          charseq = "";
          times = "";
          i++;
          while (s.charAt(i) != 'x') {
            charseq += s.charAt(i);
            i++;
          }
          i++;
          while (s.charAt(i) != ')') {
            times += s.charAt(i);
            i++;
          }
          i++;
          count += Integer.parseInt(charseq) * Integer.parseInt(times);
          i += Integer.parseInt(charseq);
        } else {
          count++;
          i++;
        }
      }
      input.close();
      System.out.println(count);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}