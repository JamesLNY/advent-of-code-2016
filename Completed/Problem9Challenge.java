import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Problem9Challenge {
    public static int updateArr(ArrayList<Integer> a, ArrayList<Integer> b, int d) {
      for (int n = 0; n < a.size(); n++) {
        a.set(n, a.get(n) - 1);
        if (a.get(n) == 0) {
          d /= b.get(n);
          a.remove(n);
          b.remove(n);
          n--;
        }
      }
      return d;
    }
    public static void main(String[] args) {
    try {
      File file = new File("Input9.txt");
      Scanner input = new Scanner(file);
      String s = "";
      while (input.hasNext()) {
        s += input.next();
      }
      int i = 0, currentMultiple = 1;
      long count = 0;
      ArrayList<Integer> timesArr = new ArrayList<Integer>(), values = new ArrayList<Integer>();
      String charseq = "", times = "";
      while (i < s.length()) {
        if (s.charAt(i) == '(') {
          charseq = "";
          times = "";
          i++;
          currentMultiple = updateArr(timesArr, values, currentMultiple);
          while (s.charAt(i) != 'x') {
            charseq += s.charAt(i);
            i++;
            currentMultiple = updateArr(timesArr, values, currentMultiple);
          }
          i++;
          currentMultiple = updateArr(timesArr, values, currentMultiple);
          while (s.charAt(i) != ')') {
            times += s.charAt(i);
            i++;
            currentMultiple = updateArr(timesArr, values, currentMultiple);
          }
          i++;
          currentMultiple = updateArr(timesArr, values, currentMultiple);
          values.add(Integer.parseInt(times));
          timesArr.add(Integer.parseInt(charseq));
          currentMultiple *= Integer.parseInt(times);
        } else {
          count += currentMultiple;
          i++;
          currentMultiple = updateArr(timesArr, values, currentMultiple);
        }
      }
      input.close();
      System.out.println(count);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}