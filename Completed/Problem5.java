import java.math.BigInteger;
import java.security.*;

public class Problem5 {
  public static void main(String[] args) {
    String s = "abbhdwsy", result = "", tempString;
    int i = 0;
    while (result.length() < 8) {
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
          result += hashtext.charAt(5);
        }
      } catch (Exception e) {
        System.out.println(e);
      }
      i++;
    }
    System.out.println(result);
  }
}