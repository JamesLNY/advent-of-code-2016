import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Problem10Challenge {
    public static void main(String[] args) {
    try {
      File file = new File("Input10.txt");
      Scanner input = new Scanner(file);
      ArrayList<Integer> queue = new ArrayList<Integer>();
      int[][] bots = new int[1000][2], instructions = new int[1000][2], output = new int[1000][1];
      while (input.hasNext()) {
        if (input.next().equals("value")) {
          int value = input.nextInt();
          for (int i = 0; i < 3; i++) input.next();
          int bot = input.nextInt();
          if (bots[bot][0] == 0) {
            bots[bot][0] = value;
          } else {
            bots[bot][1] = value;
            queue.add(bot);
          }
        } else {
          int bot = input.nextInt();
          input.next();
          input.next();
          input.next();
          if (input.next().equals("output")) {
            instructions[bot][0] = 100000 + input.nextInt();
          } else {
            instructions[bot][0] = input.nextInt();
          }
          for (int i = 0; i < 3; i++) input.next();
          if (input.next().equals("output")) {
            instructions[bot][1] = 100000 + input.nextInt();
          } else {
            instructions[bot][1] = input.nextInt();
          }
        }
      }
      input.close();
      while (! queue.isEmpty()) {
        int[] givingBot = bots[queue.getFirst()];
        int[] instruction = instructions[queue.getFirst()];
        if (instruction[0] < 100000) {
          if (bots[instruction[0]][0] == 0) {
            bots[instruction[0]][0] = Math.min(givingBot[0], givingBot[1]);
          } else {
            bots[instruction[0]][1] = Math.min(givingBot[0], givingBot[1]);
            queue.add(instruction[0]);
          }
        } else {
          output[instruction[0] - 100000][0] = Math.min(givingBot[0], givingBot[1]);
        }
        if (instruction[1] < 100000) {
          if (bots[instruction[1]][0] == 0) {
            bots[instruction[1]][0] = Math.max(givingBot[0], givingBot[1]);
          } else {
            bots[instruction[1]][1] = Math.max(givingBot[0], givingBot[1]);
            queue.add(instruction[1]);
          }
        } else {
          output[instruction[0] - 100000][0] = Math.max(givingBot[0], givingBot[1]);
        }
        queue.remove(0);
      }
      System.out.println(output[0][0] * output[1][0] * output[2][0]);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}