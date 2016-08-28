/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// Solution 1. DFS
public class Solution {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    if (nestedList == null || nestedList.size() == 0) {
      return 0;
    }
    List<Integer> counter = new ArrayList<Integer>();
    depthSumInverseHelper(nestedList, 0, counter);
    int sum = 0;
    for (int i = counter.size() - 1; i >=0; i--) {
      sum = sum + counter.get(i) * (counter.size() - i);
    }
    return sum;
  }
  private void depthSumInverseHelper(List<NestedInteger> nestedList, int depth, List<Integer> counter) {
    if (depth >= counter.size()) {
      counter.add(0);
    }
    List<NestedInteger> nextLevel = new ArrayList<NestedInteger>();
    for (int i = 0; i < nestedList.size(); ++i) {
      NestedInteger ni = nestedList.get(i);
      if (ni.isInteger()) {
        counter.set(depth, counter.get(depth) + ni.getInteger());
      } else {
        depthSumInverseHelper(ni.getList(), depth + 1, counter);
      }
    }
  }
}


// Solution 2. BFS
public class Solution {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    if (nestedList == null || nestedList.size() == 0) {
      return 0;
    }
    int unweighted = 0;
    int weighted = 0;
    List<NestedInteger> queue = new ArrayList<NestedInteger>();
    for (int i = 0; i < nestedList.size(); i++) {
      NestedInteger nestedInteger = nestedList.get(i);
      queue.add(nestedInteger);
    }

    int cur = 0;
    while (cur < queue.size()) {
      int end = queue.size();
      while (cur < end) {
        NestedInteger nestedInteger = queue.get(cur);
        if (nestedInteger.isInteger()) {
          unweighted += nestedInteger.getInteger();
        } else {
          queue.addAll(nestedInteger.getList());
        }
        cur++;
      }
      weighted += unweighted;
    }
    return weighted;
  }
}
