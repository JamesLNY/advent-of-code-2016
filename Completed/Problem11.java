import java.util.LinkedList;
import java.util.ArrayList;

public class Problem11 {
  public static void main(String[] args) {
    LinkedList<State> queue = new LinkedList<State>();
    LinkedList<Integer> moves = new LinkedList<Integer>();
    queue.add(new State());
    moves.add(0);
    State currentState, newState;
    ArrayList<Integer> generators, chips;
    ArrayList<Long> visited = new ArrayList<Long>();
    int currentMoves, minlocation = 1, outputedMove = 0;
    while (true) {
      currentState = queue.getFirst();
      currentMoves = moves.getFirst();
      queue.removeFirst();
      moves.removeFirst();
      if (! currentState.isValid()) continue;
      if (visited.contains(currentState.id())) continue;
      if (currentState.getLocation() < minlocation) continue;
      if (currentState.isComplete()) {
        System.out.println(currentMoves);
        break;
      }
      if (currentMoves > outputedMove) {
        System.out.println(currentMoves);
        outputedMove++;
      }
      minlocation = Math.min(currentState.getLocation(), minlocation);
      visited.add(currentState.id());
      generators = currentState.getGenerators();
      for (int i = 0; i < generators.size(); i++) {
        for (int n = i + 1; n < generators.size(); n++) {
          for (int w = -1; w <= 1; w += 2) {
            newState = currentState.copy();
            newState.moveTwoGenerator(generators.get(i), generators.get(n), w);
            queue.add(newState);
            moves.add(currentMoves + 1);
          }
        }
        for (int w = -1; w <= 1; w += 2) {
          newState = currentState.copy();
          newState.moveOneGenerator(generators.get(i), w);
          queue.add(newState);
          moves.add(currentMoves + 1);
        }
      }
      chips = currentState.getChips();
      for (int i = 0; i < chips.size(); i++) {
        for (int n = i + 1; n < chips.size(); n++) {
          for (int w = -1; w <= 1; w += 2) {
            newState = currentState.copy();
            newState.moveTwoChip(chips.get(i), chips.get(n), w);
            queue.add(newState);
            moves.add(currentMoves + 1);
          }
        }
        for (int w = -1; w <= 1; w += 2) {
          newState = currentState.copy();
          newState.moveOneChip(chips.get(i), w);
          queue.add(newState);
          moves.add(currentMoves + 1);
        }
      }
      for (int i = 0; i < chips.size(); i++) {
        for (int n = 0; n < generators.size(); n++) {
          for (int w = -1; w <= 1; w += 2) {
            newState = currentState.copy();
            newState.moveGeneratorAndChip(generators.get(n), chips.get(i), w);
            queue.add(newState);
            moves.add(currentMoves + 1);
          }
        }
      }
    }
  }
}
