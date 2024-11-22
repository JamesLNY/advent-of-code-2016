public class Problem19 {
  public static void main(String[] args) {
    int firstNum = 1, start;
    int iterations = 1;
    start = 3004953;
    while (start != 1) {
      if (start % 2 == 1) {
        firstNum += Math.pow(2, iterations);
      }
      iterations++;
      start /= 2;
    }
    System.out.println(firstNum);
  }
}