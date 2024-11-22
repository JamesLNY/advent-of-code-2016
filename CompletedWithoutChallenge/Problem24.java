import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem24 {
  public static void main(String[] args) {
    ArrayList<ArrayList<Character>> arr = new ArrayList<ArrayList<Character>>();
    int[] xCords = new int[8], yCords = new int[8];
    int x = 0, y = 0;
    try {
      File file = new File("Input24.txt");
      Scanner input = new Scanner(file);
      ArrayList<Character> temp = new ArrayList<Character>();
      while (input.hasNextLine()) {
        x = 0;
        temp = new ArrayList<Character>();
        char[] cArr = input.nextLine().toCharArray();
        for (char c : cArr) {
          temp.add(c);
          if (Character.isDigit(c)) {
            xCords[c - '0'] = x;
            yCords[c - '0'] = y;
          }
          x++;
        }
        y++;
        arr.add(temp);
      }
      input.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    int[][] visited = new int[x][y];
    int[][] distances = new int[8][8];
    int count, curX, curY, curD;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    ArrayList<Integer> xArr = new ArrayList<Integer>(), yArr = new ArrayList<Integer>(), length = new ArrayList<Integer>();
    for (int i = 0; i < 8; i++) {
      visited = new int[x][y];
      count = 0;
      xArr = new ArrayList<Integer>();
      yArr = new ArrayList<Integer>();
      length = new ArrayList<Integer>();
      xArr.add(xCords[i]);
      yArr.add(yCords[i]);
      length.add(0);
      while (count < 8) {
        curX = xArr.getFirst();
        curY = yArr.getFirst();
        curD = length.getFirst();
        xArr.remove(0);
        yArr.remove(0);
        length.remove(0);
        if (visited[curX][curY] == 1) continue;
        if (arr.get(curY).get(curX) == '#') continue;
        visited[curX][curY] = 1;
        if (Character.isDigit(arr.get(curY).get(curX))) {
          distances[i][arr.get(curY).get(curX) - '0'] = curD;
          count++;
        }
        for (int[] direction : directions) {
          xArr.add(curX + direction[0]);
          yArr.add(curY + direction[1]);
          length.add(curD + 1);
        }
      }
      System.out.println(Arrays.toString(distances[i]));
    }
  }
}