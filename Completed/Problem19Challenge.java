public class Problem19Challenge {
  public static void main(String[] args) {
    int length = 3004953;
    boolean[] bArr = new boolean[length];
    for (int i = 0; i < bArr.length; i++) {
      bArr[i] = true;
    }
    int cycle = length % 2 + 1, index = 0 + length / 2, count = 0;
    while (true) {
      count = 0;
      if (cycle > 0) {
        bArr[index] = false;
      } else {
        index++;
        if (index == bArr.length) index = 0;
      }
      while (! bArr[index]) {
        index++;
        count++;
        if (index == bArr.length) index = 0;
        if (count == length) {
          System.out.println(index + 1);
          return;
        }
      }
      cycle = (cycle + 1) % 3;
    }
  }
}