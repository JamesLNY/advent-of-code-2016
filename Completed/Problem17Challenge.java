import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Problem17Challenge {
  public static String generateHash(String index) {
    String tempString = "pxxbnzuo" + index;
    try {
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.reset();
      m.update(tempString.getBytes());
      byte[] digest = m.digest();
      BigInteger bigInt = new BigInteger(1,digest);
      String hashtext = bigInt.toString(16);
      while (hashtext.length() < 32){
        hashtext = "0" + hashtext;
      }
      tempString = hashtext;
    } catch (Exception e) {
      System.out.println(e);
    }
    return tempString;
  }
  public static void main(String[] args) {
    String latestPath = "";
    int x, y;
    String direction;
    ArrayList<Integer> xValues = new ArrayList<Integer>(), yValues = new ArrayList<Integer>();
    ArrayList<String> directions = new ArrayList<String>();
    ArrayList<Character> valid = new ArrayList<Character>();
    valid.add('b');
    valid.add('c');
    valid.add('d');
    valid.add('e');
    valid.add('f');
    xValues.add(0);
    yValues.add(3);
    directions.add("");
    while (! directions.isEmpty()) {
      direction = directions.getFirst();
      x = xValues.getFirst();
      y = yValues.getFirst();
      directions.remove(0);
      xValues.remove(0);
      yValues.remove(0);
      if (x == 3 && y == 0) {
        latestPath = direction;
        continue;
      }
      if (x < 0 || y < 0 || x > 3 || y > 3) continue;
      String s = generateHash(direction).substring(0, 4);
      if (valid.contains(s.charAt(0))) {
        xValues.add(x);
        yValues.add(y + 1);
        directions.add(direction + "U");
      }
      if (valid.contains(s.charAt(1))) {
        xValues.add(x);
        yValues.add(y - 1);
        directions.add(direction + "D");
      }
      if (valid.contains(s.charAt(2))) {
        xValues.add(x - 1);
        yValues.add(y);
        directions.add(direction + "L");
      }
      if (valid.contains(s.charAt(3))) {
        xValues.add(x + 1);
        yValues.add(y);
        directions.add(direction + "R");
      }
    }
    System.out.println(latestPath.length());
  }
}