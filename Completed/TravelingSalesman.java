public class TravelingSalesman {
  static int n = 8;

  static int[][] dist = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
  {0, 0, 20, 76, 28, 238, 220, 16, 166},
  {0, 20, 0, 76, 44, 234, 216, 24, 162},
  {0, 76, 76, 0, 92, 302, 284, 88, 230},
  {0, 28, 44, 92, 0, 230, 212, 32, 162},
  {0, 238, 234, 302, 230, 0, 38, 230, 84},
  {0, 220, 216, 284, 212, 38, 0, 212, 66},
  {0, 16, 24, 88, 32, 230, 212, 0, 162},
  {0, 166, 162, 230, 162, 84, 66, 162, 0}};

  static int[][] memo = new int[n + 1][1 << (n + 1)];

  static int fun(int i, int mask)
  {
    if (mask == ((1 << i) | 3)) return dist[1][i];
    if (memo[i][mask] != 0) return memo[i][mask];
    
    int res = 1000000;
    
    for (int j = 2; j <= n; j++) {
      if ((mask & (1 << j)) != 0 && j != i) {
        res = Math.min(res, fun(j, mask & (~(1 << i))) + dist[j][i]);
      }
    }

    return memo[i][mask] = res;
  }
  public static void main(String[] args)
  {
    int ans = 1000000;
    for (int i = 1; i <= n; i++) {
      ans = Math.min(ans, fun(i, (1 << (n + 1)) - 1) + dist[i][1]);
    }
    System.out.println(ans);
  }
}