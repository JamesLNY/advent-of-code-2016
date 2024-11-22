import java.util.ArrayList;
public class Problem11 {
  public static ArrayList<ArrayList<Integer>> copy(ArrayList<ArrayList<Integer>> a) {
    ArrayList<ArrayList<Integer>> copy = new ArrayList<ArrayList<Integer>>();
    for (ArrayList<Integer> p : a) {
      copy.add(new ArrayList<Integer>());
      for (Integer n : p) {
        copy.getLast().add(n);
      }
    }
    return copy;
  }

  public static int recurse(ArrayList<ArrayList<Integer>> a, int floor, int moves) {
    if (moves > 40) return 0;
    ArrayList<Integer> microchips = new ArrayList<Integer>(), generators = new ArrayList<Integer>();
    int answer = 0, temp;
    for (int i : a.get(floor)) {
      if (i > 10) {
        generators.add(i);
      } else {
        microchips.add(i);
      }
    }
    if (generators.size() > 0) {
      for (int i : a.get(floor)) {
        if ((i < 10) && (! a.get(floor).contains(i + 10))) {
          return 0;
        }
      }
    }
    for (int i : a.get(floor)) {
      generators.remove(Integer.valueOf(i));
    }
    if (floor == 3 && a.get(3).size() == 10) return moves;
    if (floor < 3) {
      for (int i = 0; i < microchips.size(); ++i) {
        for (int n = i + 1; n < microchips.size(); ++n) {
          if (n + i >= microchips.size()) break;
          ArrayList<ArrayList<Integer>> copy = copy(a);
          copy.get(floor).remove(microchips.get(i));
          copy.get(floor).remove(microchips.get(i + n));
          copy.get(floor + 1).add(microchips.get(i));
          copy.get(floor + 1).add(microchips.get(i + n));
          temp = recurse(copy, floor + 1, moves + 1);
          if (temp != 0 && answer != 0) {
            answer = Math.min(answer, temp);
          } else {
            answer = temp;
          }
        }
        ArrayList<ArrayList<Integer>> copy = copy(a);
        copy.get(floor).remove(microchips.get(i));
        copy.get(floor).remove(Integer.valueOf(microchips.get(i) + 10));
        copy.get(floor + 1).add(microchips.get(i));
        copy.get(floor + 1).add(microchips.get(i) + 1);
        temp = recurse(copy, floor + 1, moves + 1);
        if (temp != 0 && answer != 0) {
          answer = Math.min(answer, temp);
        } else {
          answer = temp;
        }
        copy = copy(a);
        copy.get(floor).remove(microchips.get(i));
        copy.get(floor + 1).add(microchips.get(i));
        temp = recurse(copy, floor + 1, moves + 1);
        if (temp != 0 && answer != 0) {
          answer = Math.min(answer, temp);
        } else {
          answer = temp;
        }
      }
      for (int i = 0; i < generators.size(); i++) {
        for (int n = i + 1; n < generators.size(); n++) {
          if (n + i >= generators.size()) break;
          ArrayList<ArrayList<Integer>> copy = copy(a);
          copy.get(floor).remove(generators.get(i));
          copy.get(floor).remove(generators.get(i + n));
          copy.get(floor + 1).add(generators.get(i));
          copy.get(floor + 1).add(generators.get(i + n));
          temp = recurse(copy, floor + 1, moves + 1);
          if (temp != 0 && answer != 0) {
            answer = Math.min(answer, temp);
          } else {
            answer = temp;
          }
          copy = copy(a);
          copy.get(floor).remove(generators.get(i));
          copy.get(floor + 1).add(generators.get(i));
          temp = recurse(copy, floor + 1, moves + 1);
          if (temp != 0 && answer != 0) {
            answer = Math.min(answer, temp);
          } else {
            answer = temp;
          }
        }
      }
    }
    if (floor > 0) {
      for (int i = 0; i < microchips.size(); i++) {
        for (int n = i + 1; n < microchips.size(); n++) {
          if (n + i >= microchips.size()) break;
          ArrayList<ArrayList<Integer>> copy = copy(a);
          copy.get(floor).remove(microchips.get(i));
          copy.get(floor).remove(microchips.get(i + n));
          copy.get(floor - 1).add(microchips.get(i));
          copy.get(floor - 1).add(microchips.get(i + n));
          temp = recurse(copy, floor - 1, moves + 1);
          if (temp != 0 && answer != 0) {
            answer = Math.min(answer, temp);
          } else {
            answer = temp;
          }
        }
        ArrayList<ArrayList<Integer>> copy = copy(a);
        copy.get(floor).remove(microchips.get(i));
        copy.get(floor).remove(Integer.valueOf(microchips.get(i) + 10));
        copy.get(floor - 1).add(microchips.get(i));
        copy.get(floor - 1).add(microchips.get(i) + 1);
        temp = recurse(copy, floor - 1, moves + 1);
        if (temp != 0 && answer != 0) {
          answer = Math.min(answer, temp);
        } else {
          answer = temp;
        }
        copy = copy(a);
        copy.get(floor).remove(microchips.get(i));
        copy.get(floor - 1).add(microchips.get(i));
        temp = recurse(copy, floor - 1, moves + 1);
        if (temp != 0 && answer != 0) {
          answer = Math.min(answer, temp);
        } else {
          answer = temp;
        }
      }
      for (int i = 0; i < generators.size(); i++) {
        for (int n = i + 1; n < generators.size(); n++) {
          if (n + i >= generators.size()) break;
          ArrayList<ArrayList<Integer>> copy = copy(a);
          copy.get(floor).remove(generators.get(i));
          copy.get(floor).remove(generators.get(i + n));
          copy.get(floor - 1).add(generators.get(i));
          copy.get(floor - 1).add(generators.get(i + n));
          temp = recurse(copy, floor - 1, moves + 1);
          if (temp != 0 && answer != 0) {
            answer = Math.min(answer, temp);
          } else {
            answer = temp;
          }
          copy = copy(a);
          copy.get(floor).remove(generators.get(i));
          copy.get(floor - 1).add(generators.get(i));
          temp = recurse(copy, floor - 1, moves + 1);
          if (temp != 0 && answer != 0) {
            answer = Math.min(answer, temp);
          } else {
            answer = temp;
          }
        }
      }
    }
    return answer;
  }
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> floors = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < 4; i++) floors.add(new ArrayList<Integer>());
    floors.get(0).add(0);
    floors.get(0).add(10);
    for (int i = 0; i < 4; i++) floors.get(1).add(i + 11);
    for (int i = 0; i < 4; i++) floors.get(2).add(i + 1);
    System.out.println(recurse(floors, 0, 0));
  }
}
