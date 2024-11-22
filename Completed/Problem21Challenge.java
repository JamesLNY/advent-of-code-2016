import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Problem21Challenge {
  public static void main(String[] args) {
    ArrayList<String> commands = new ArrayList<String>();
    ArrayList<ArrayList<Integer>> instructions = new ArrayList<ArrayList<Integer>>(0);
    ArrayList<Integer> tempArr;
    try {
      String s;
      tempArr = new ArrayList<Integer>();
      File file = new File("Input21.txt");
      Scanner input = new Scanner(file);
      while (input.hasNext()) {
        s = "";
        s += input.next().charAt(0);
        s += input.next().charAt(0);
        commands.add(s);
        tempArr = new ArrayList<Integer>();
        if (s.equals("sp") || s.equals("mp")) {
          tempArr.add(input.nextInt());
          input.next();
          input.next();
          tempArr.add(input.nextInt());
        } else if (s.equals("sl")) {
          tempArr.add(input.next().charAt(0) - 'a');
          input.next();
          input.next();
          tempArr.add(input.next().charAt(0) - 'a');
        } else if (s.equals("rb")) {
          input.next();
          input.next();
          input.next();
          input.next();
          tempArr.add(input.next().charAt(0) - 'a');
        } else if (s.equals("rl") || s.equals("rr")) {
          tempArr.add(input.nextInt());
          input.next();
        } else {
          tempArr.add(input.nextInt());
          input.next();
          tempArr.add(input.nextInt());
        }
        instructions.add(tempArr);
      }
      input.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
    Collections.reverse(instructions);
    Collections.reverse(commands);
    int[] positions = {6, 1, 4, 3, 5, 0, 2, 7};
    // int[] positions = {3, 4, 2, 0, 1};
    int temp;
    String s = "";
    ArrayList<Integer> instruction = new ArrayList<Integer>();
    for (int n = 0; n < instructions.size(); n++) {
      s = commands.get(n);
      instruction = instructions.get(n);
      System.out.println(s);
      System.out.println(instruction);
      if (s.equals("sp")) {
        for (int i = 0; i < 8; i++) {
          if (positions[i] == instruction.get(0)) {
            positions[i] = instruction.get(1);
          } else if (positions[i] == instruction.get(1)) {
            positions[i] = instruction.get(0);
          }
        }
      } else if (s.equals("sl")) {
        temp = positions[instruction.get(0)];
        positions[instruction.get(0)] = positions[instruction.get(1)];
        positions[instruction.get(1)] = temp;
      } else if (s.equals("rl")) {
        for (int i = 0; i < 8; i++) {
          positions[i] = (8 + (positions[i] + instruction.get(0))) % 8;
        }
      } else if (s.equals("rr")) {
        for (int i = 0; i < 8; i++) {
          positions[i] = (8 + (positions[i] - instruction.get(0))) % 8;
        }
      } else if (s.equals("rb")) {
        int rotations = 0;
        temp = positions[instruction.get(0)];
        if (temp >= 4) temp++;
        temp++;
        while (temp != rotations) {
          rotations++;
          for (int i = 0; i < 8; i++) {
            positions[i] = (8 + (positions[i] - 1)) % 8;
          }
          temp = positions[instruction.get(0)];
          if (temp >= 4) temp++;
          temp++;
        }
      } else if (s.equals("rp")) {
        for (int i = 0; i < 8; i++) {
          temp = instruction.get(1) - instruction.get(0);
          if (positions[i] < instruction.get(0) || positions[i] > instruction.get(1)) continue;
          positions[i] = temp - (positions[i] - instruction.get(0)) + instruction.get(0);
        }
      } else {
        temp = 0;
        for (int i = 0; i < 8; i++) {
          if (positions[i] == instruction.get(1)) {
            temp = i;
          }
        }
        for (int i = 0; i < 8; i++) {
          if (positions[i] > Math.max(instruction.get(0), instruction.get(1)) || positions[i] < Math.min(instruction.get(1), instruction.get(0))) continue;
          if (instruction.get(0) > instruction.get(1)) {
            positions[i]--;
          } else {
            positions[i]++;
          }
        }
        positions[temp] = instruction.get(0);
      }
      System.out.println(Arrays.toString(positions));

    }
  }
}