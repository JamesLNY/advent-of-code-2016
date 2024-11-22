import java.math.BigInteger;
import java.security.*;
import java.util.ArrayList;

public class Problem14 {
  public static void generateHash(ArrayList<String> hashes, int index) {
    String tempString = "ihaygndm" + index;
    try {
      for (int i = 0; i < 2017; i++) {
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
      }
      hashes.add(tempString);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public static void main(String[] args) {
    ArrayList<String> hashes = new ArrayList<String>();
    int i = 0, count = 0;
    while (count < 64) {
      if (i >= hashes.size()) generateHash(hashes, i);
      String hashtext = hashes.get(i);
      for (int n = 0; n < hashtext.length() - 2; n++) {
        if (hashtext.charAt(n) == hashtext.charAt(n + 1) && hashtext.charAt(n + 1) == hashtext.charAt(n + 2)) {
          for (int v = 1; v < 1001; v++) {
            if (i + v >= hashes.size()) generateHash(hashes, i + v);
            if (hashes.get(i + v).contains(hashtext.substring(n, n+3) + hashtext.substring(n, n+2))) {
              count++;
              if (count == 64) {
                System.out.println(i);
              }
              break;
            }
          }
          break;
        }
      }
      i++;
    }
  }
}