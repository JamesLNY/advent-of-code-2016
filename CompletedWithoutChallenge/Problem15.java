public class Problem15 {
  public static void main(String[] args) {
    for (long i = 0; i < 100000000; i++) {
      if ((i + 6) % 17 == 0) {
        if ((i + 10) % 19 == 0) {
          if ((i + 4) % 7 == 0) {
            if ((i + 11) % 13 == 0) {
              if ((i + 6) % 5 == 0) {
                if ((i + 6) % 3 == 0) {
                  if ((i + 7) % 11 == 0) {
                    System.out.println(i);
                    break;
                  }
                }
              }
            }
          }
        }
      }
    } 
  }
}