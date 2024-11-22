import java.math.BigInteger;
import java.security.*;

public class Problem5Challenge {
  public static void main(String[] args) {
    String s = "abbhdwsy", tempString;
    char[] result = new char[8];
    boolean[] filled = new boolean[8];
    for (int i = 0; i < 8; i++) {
      filled[i] = false;
    }
    int i = 0, number = 0;
    while (number < 8) {
      tempString = s + i;
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
        if (hashtext.substring(0, 5).equals("00000")) {
          System.out.println(hashtext.substring(5, 7));
          if (Character.isDigit(hashtext.charAt(5))) {
            int position = Integer.parseInt(hashtext.substring(5, 6));
            if (position < 8 && ! filled[position]) {
              result[position] = hashtext.charAt(6);
              System.out.println(result[position]);
              number++;
              filled[position] = true;
            }
          };
        }
      } catch (Exception e) {
        System.out.println(e);
      }
      i++;
    }
    for (int n = 0; n < 8; n++) {
      System.out.println(result[n]);
    }
  }
}