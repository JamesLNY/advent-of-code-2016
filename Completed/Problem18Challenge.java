public class Problem18Challenge {
  public static void main(String[] args) {
    String original = ".^^^^^.^^^..^^^^^...^.^..^^^.^^....^.^...^^^...^^^^..^...^...^^.^.^.......^..^^...^.^.^^..^^^^^...^.";
    StringBuilder sb = new StringBuilder();
    int total = 0;
    for (int i = 0; i < original.length(); i++) {
      if (original.charAt(i) == '.') total++;
    }
    for (int i = 0; i < 399999; i++) {
      sb = new StringBuilder();
      for (int n = 0; n < original.length(); n++) {
        if (n == 0) {
          if (original.charAt(n + 1) == '^') {
            sb.append('^');
          } else {
            sb.append('.');
            total++;
          }
          continue;
        }
        if (n == original.length() - 1) {
          if (original.charAt(n - 1) == '^') {
            sb.append('^');
          } else {
            sb.append('.');
            total++;
          }
          continue;
        }
        if (original.charAt(n - 1) != original.charAt(n + 1)) {
          sb.append('^');
        } else {
          sb.append('.');
          total++;
        }
      }
      original = sb.toString();
    }
    System.out.println(total);
  }
}
