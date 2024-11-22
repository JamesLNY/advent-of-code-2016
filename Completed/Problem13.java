import java.util.ArrayList;
public class Problem13 {
  public static void main(String[] args) {
    int[][] visited = new int[1000][1000];
    int x, y, count;
    int[][] arr = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    ArrayList<Integer> xValues = new ArrayList<Integer>(), yValues = new ArrayList<Integer>(), counts = new ArrayList<Integer>();
    xValues.add(1);
    yValues.add(1);
    counts.add(0);
    while (true) {
      count = counts.getFirst();
      x = xValues.getFirst();
      y = yValues.getFirst();
      if (x == 31 && y == 39) {
        System.out.println(count);
        break;
      }
      counts.remove(0);
      xValues.remove(0);
      yValues.remove(0);
      if (x < 0 || y < 0) continue;
      if (visited[x][y] == 1) continue;
      if ((Integer.bitCount(x*x + 3*x + 2*x*y + y + y*y + 1364)) % 2 == 1) continue;
      visited[x][y] = 1;
      for (int[] a : arr) {
        xValues.add(x + a[0]);
        yValues.add(y + a[1]);
        counts.add(count + 1);
      }
    }
  }
}
