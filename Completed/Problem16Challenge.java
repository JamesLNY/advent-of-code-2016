public class Problem16Challenge {
  public static void main(String[] args) {
    long b = 0B01110110101001000, numBits = 1;
    String a, c;
    while (numBits < 35651584 && numBits > 0) {
      numBits = (long)(Math.log(b) / Math.log(2) + 1);
      b = b << (numBits + 1) + ~b;
      System.out.println(numBits);
    }
    numBits = (long)(Math.log(b) / Math.log(2) + 1);
    b = b >> 35651584 - numBits;
    a = Long.toBinaryString(b);
    int d = 0;
    while (a.length() % 2 == 0) {
      c = "";
      for (int i = 0; i < a.length(); i += 2) {
        if (a.charAt(i) == a.charAt(i + 1)) {
          c += "1";
        } else {
          c += "0";
        }
      }
      a = c;
      System.out.println(d);
      d++;
    }
    System.out.println(a);
  }

}
