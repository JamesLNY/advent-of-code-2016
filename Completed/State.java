import java.util.ArrayList;
import java.util.HashSet;

public class State {
  private int[] chipLocations;
  private int[] generatorLocations;
  private int location;

  public State() {
    chipLocations = new int[] {1, 1, 1, 3, 3, 3, 3};
    generatorLocations = new int[] {1, 1, 1, 2, 2, 2, 2};
    location = 1;
  }

  public String toString() {
    return id() + "";
  }

  public State(int[] initChipLocations, int[] initGeneratorLocations, int initLocation) {
    chipLocations = initChipLocations.clone();
    generatorLocations = initGeneratorLocations.clone();
    location = initLocation;
  }

  public State copy() {
    return new State(chipLocations, generatorLocations, location);
  }

  public long id() {
    long id = 1;
    int[] pairsOnFloors = new int[5];
    for (int i = 0; i < chipLocations.length; i++) {
      if (generatorLocations[i] != chipLocations[i]) {
        id *= 10;
        id += chipLocations[i];
        id *= 10;
        id += generatorLocations[i];
      } else {
        pairsOnFloors[generatorLocations[i]]++;
      }
    }
    for (int i = 1; i < 5; i++) {
      for (int n = 0; n < pairsOnFloors[i]; n++) {
        id *= 10;
        id += i;
      }
    }
    id *= 10;
    id += location;
    return id;
  }

  public boolean isValid() {
    HashSet<Integer> floorsWithGenerators = new HashSet<Integer>();
    for (int i : generatorLocations) {
      floorsWithGenerators.add(i);
      if (i > 4 || i < 1) return false;
    }
    for (int i = 0; i < chipLocations.length; i++) {
      if (chipLocations[i] > 4 || chipLocations[i] < 1) return false;
      if (chipLocations[i] != generatorLocations[i]) {
        if (floorsWithGenerators.contains(chipLocations[i])) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isComplete() {
    for (int i = 0; i < chipLocations.length; i++) {
      if (chipLocations[i] != 4 || generatorLocations[i] != 4) {
        return false;
      }
    }
    return true;
  }

  public void moveGeneratorAndChip(int generator, int chip, int direction) {
    chipLocations[chip - 1] += direction;
    generatorLocations[generator - 1] += direction;
    location += direction;
  }

  public void moveTwoGenerator(int generatorOne, int generatorTwo, int direction) {
    generatorLocations[generatorOne - 1] += direction;
    generatorLocations[generatorTwo - 1] += direction;
    location += direction;
  }

  public void moveTwoChip(int chipOne, int chipTwo, int direction) {
    chipLocations[chipOne - 1] += direction;
    chipLocations[chipTwo - 1] += direction;
    location += direction;
  }

  public void moveOneChip(int chip, int direction) {
    chipLocations[chip - 1] += direction;
    location += direction;
  }

  public void moveOneGenerator(int generator, int direction) {
    generatorLocations[generator - 1] += direction;
    location += direction;
  }

  public ArrayList<Integer> getGenerators() {
    ArrayList<Integer> currentGenerators = new ArrayList<Integer>();
    for (int i = 0; i < generatorLocations.length; i++) {
      if (generatorLocations[i] == location) {
        currentGenerators.add(i + 1);
      }
    }
    return currentGenerators;
  }

  public ArrayList<Integer> getChips() {
    ArrayList<Integer> currentChips = new ArrayList<Integer>();
    for (int i = 0; i < chipLocations.length; i++) {
      if (chipLocations[i] == location) {
        currentChips.add(i + 1);
      }
    }
    return currentChips;
  }

  public int getLocation() {
    return location;
  }
}
