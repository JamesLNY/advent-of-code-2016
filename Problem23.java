import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Problem23 {
  public static void main(String[] args) {
    ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
    try {
      File file = new File("Input23.txt");
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        arr.add(new ArrayList<String>(Arrays.asList(input.nextLine().split(" "))));
      }
      input.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    int index = 0, tempNum;
    int[] nums = new int[4];
    nums[0] = 7;
    ArrayList<String> instruction, temp;
    while (index < arr.size()) {
      instruction = arr.get(index);
      if (instruction.getFirst().equals("cpy")) {
        if (Character.isAlphabetic(instruction.get(1).charAt(0))) {
          nums[instruction.get(2).charAt(0) - 'a'] = nums[instruction.get(1).charAt(0) - 'a'];
        } else {
          nums[instruction.get(2).charAt(0) - 'a'] = Integer.parseInt(instruction.get(1));
        }
      } else if (instruction.getFirst().equals("inc")) {
        if (Character.isAlphabetic(instruction.get(0).charAt(0))) {
          nums[instruction.get(1).charAt(0) - 'a']++;
        }
      } else if (instruction.getFirst().equals("dec")) {
        if (Character.isAlphabetic(instruction.get(0).charAt(0))) {
          nums[instruction.get(1).charAt(0) - 'a']--;
        }
      } else if (instruction.getFirst().equals("tgl")) {
        if (Character.isAlphabetic(instruction.get(1).charAt(0))) {
          tempNum = nums[instruction.get(1).charAt(0) - 'a'];
        } else {
          tempNum = Integer.parseInt(instruction.get(1));
        }
        if (index + tempNum < arr.size()) {
          temp = arr.get(index + tempNum);
          if (temp.getFirst().equals("cpy")) {
            temp.set(0, "jnz");
          } else if (temp.getFirst().equals("jnz")) {
            temp.set(0, "cpy");
          } else if (temp.getFirst().equals("inc")) {
            temp.set(0, "dec");
          } else {
            temp.set(0, "inc");
          }
        }
      } else {
        if (Character.isAlphabetic(instruction.get(2).charAt(0))) {
          tempNum = nums[instruction.get(2).charAt(0) - 'a'];
        } else {
          tempNum = Integer.parseInt(instruction.get(2));
        }
        if (Character.isAlphabetic(instruction.get(1).charAt(0))) {
          if (nums[instruction.get(1).charAt(0) - 'a'] != 0) {
            index += tempNum;
            continue;
          }
        } else {
          if (Integer.parseInt(instruction.get(1)) != 0) {
            index += tempNum;
            index--;
          }
        }
      }
      index++;
    }
    System.out.println(nums[0]);
  }
}
