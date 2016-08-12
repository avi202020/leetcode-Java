public class TwoSum {

  private Map<Integer, Integer> counter;

  public TwoSum() {
    counter = new HashMap<Integer, Integer>();
  }

  // Add the number to an internal data structure.
  public void add(int number) {
    if (!counter.containsKey(number)) {
      counter.put(number, 1);
    } else {
      counter.put(number, counter.get(counter) + 1);
    }
  }

  // Find if there exists any pair of numbers which sum is equal to the value.
  public boolean find(int value) {
    for (int key : counter.keySet()) {
      int another = value - key;
      if (key != another && counter.containsKey(another)) {
        return true;
      } else if (counter.get(key) >= 2) {
        return true;
      }
    }
    return false;
  }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
