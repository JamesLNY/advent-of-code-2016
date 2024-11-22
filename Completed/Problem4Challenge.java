import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Problem4Challenge {
  public static void main(String[] args) {
    ArrayList<Character> characters;
    ArrayList<Integer> quanties, newQuanties, sectorIDs = new ArrayList<Integer>();
    String s, checksum;
    ArrayList<String> realRooms = new ArrayList<String>();
    int sectorID;
    try {
      File file = new File("Input4.txt");
      Scanner input = new Scanner(file);
      while (input.hasNext()) {
        s = input.next();
        sectorID = 0;
        checksum = "";
        characters = new ArrayList<Character>();
        quanties  = new ArrayList<Integer>();
        for (int i = 0; i < s.length() - 7; i++) {
          if (s.charAt(i) == '-') continue;
          if (Character.isDigit(s.charAt(i))) {
            sectorID *= 10;
            sectorID += Integer.parseInt(s.substring(i, i + 1));
            continue;
          }
          if (characters.contains(s.charAt(i))) {
            quanties.set(characters.indexOf(s.charAt(i)), quanties.get(characters.indexOf(s.charAt(i))) + 1);
          } else {
            characters.add(s.charAt(i));
            quanties.add(1);
          }
        }
        checksum = s.substring(s.length() - 6, s.length() - 1);
        s = s.substring(0, s.length() - 7);
        newQuanties = new ArrayList<Integer>(quanties);
        Collections.sort(newQuanties);
        Collections.reverse(newQuanties);
        for (int i = 0; i < checksum.length(); i++) {
          if (characters.indexOf(checksum.charAt(i)) == -1) break;
          if (newQuanties.get(i) != quanties.get(characters.indexOf(checksum.charAt(i)))) break;
          if (i < checksum.length() - 1) {
            if (newQuanties.get(i) == newQuanties.get(i + 1) && checksum.charAt(i + 1) < checksum.charAt(i)) break;
          }
          if (i == checksum.length() - 1) {
            realRooms.add(s);
            sectorIDs.add(sectorID);
          }
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    for (int i = 0; i < realRooms.size(); i++) {
      String newString = "";
      for (int n = 0; n < realRooms.get(i).length(); n++) {
        if (realRooms.get(i).charAt(n) == '-') {
          newString += ' ';
        } else {
          newString += (char) ((realRooms.get(i).charAt(n) - 'a' + sectorIDs.get(i)) % 26 + 'a');
        }
      }
      if (newString.contains("northpole")) {
        System.out.println(sectorIDs.get(i));
        break;
      }
    }
  }
}