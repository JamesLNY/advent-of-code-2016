public class Problem16 {
  public static void main(String[] args) {
    String a = "01110110101001000", b;
    while (a.length() < 35651584) {
      StringBuilder res = new StringBuilder();
      res.append(a);
      res.reverse();
      b = res.toString().replace("0", "x").replace("1", "0").replace("x", "1");
      a = a + '0' + b;
    }
    a = a.substring(0, 35651584);
    while (a.length() % 2 == 0) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < a.length(); i += 2) {
        if (a.charAt(i) == a.charAt(i + 1)) {
          sb.append("1");
        } else {
          sb.append("0");
        }
      }
      a = sb.toString();
    }
    System.out.println(a);
  }
}