import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Problem12 {
  public static void main(String[] args) {
    ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
    try {
      File file = new File("Input12.txt");
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        arr.add(new ArrayList<String>(Arrays.asList(input.nextLine().split(" "))));
      }
      input.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println(arr);
    int index = 0;
    int[] nums = new int[4];
    nums[2] = 1;
    ArrayList<String> instruction;
    while (index < arr.size()) {
      instruction = arr.get(index);
      if (instruction.getFirst().equals("cpy")) {
        if (Character.isAlphabetic(instruction.get(1).charAt(0))) {
          nums[instruction.get(2).charAt(0) - 'a'] = nums[instruction.get(1).charAt(0) - 'a'];
        } else {
          nums[instruction.get(2).charAt(0) - 'a'] = Integer.parseInt(instruction.get(1));
        }
      } else if (instruction.getFirst().equals("inc")) {
        nums[instruction.get(1).charAt(0) - 'a']++;
      } else if (instruction.getFirst().equals("dec")) {
        nums[instruction.get(1).charAt(0) - 'a']--;
      } else {
        if (Character.isAlphabetic(instruction.get(1).charAt(0))) {
          if (nums[instruction.get(1).charAt(0) - 'a'] != 0) {
            index += Integer.parseInt(instruction.get(2));
            continue;
          }
        } else {
          if (Integer.parseInt(instruction.get(1)) != 0) {
            index += Integer.parseInt(instruction.get(2));
            index--;
          }
        }
      }
      index++;
    }
    System.out.println(nums[0]);
  }
}
