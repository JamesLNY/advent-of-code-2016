public class Problem18 {
  public static void main(String[] args) {
    String original = ".^^^^^.^^^..^^^^^...^.^..^^^.^^....^.^...^^^...^^^^..^...^...^^.^.^.......^..^^...^.^.^^..^^^^^...^.";
    String newString = "";
    int total = 0;
    for (int i = 0; i < original.length(); i++) {
      if (original.charAt(i) == '.') total++;
    }
    for (int i = 0; i < 39; i++) {
      newString = "";
      for (int n = 0; n < original.length(); n++) {
        if (n == 0) {
          if (original.charAt(n + 1) == '^') {
            newString += '^';
          } else {
            newString += '.';
            total++;
          }
          continue;
        }
        if (n == original.length() - 1) {
          if (original.charAt(n - 1) == '^') {
            newString += '^';
          } else {
            newString += '.';
            total++;
          }
          continue;
        }
        if (original.charAt(n - 1) != original.charAt(n + 1)) {
          newString += '^';
        } else {
          newString += '.';
          total++;
        }
      }
      original = newString;
    }
    System.out.println(total);
  }
  
}
