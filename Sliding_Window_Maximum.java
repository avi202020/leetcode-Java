// Solution 1. naive solution using heap O(nlogn) time
public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k == 0) {
      return new int[0];
    }
    int[] res = new int[nums.length - k + 1];
    int index = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    for (int i = 0; i < nums.length; ++i) {
      queue.add(nums[i]);
      if (queue.size() > k) {
        queue.remove(nums[i - k]);
      }
      if (queue.size() == k) {
        res[index] = queue.peek();
        index++;
      }
    }
    return res;
  }
}


// solution 2. dequeue O(n) time
public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k == 0) {
      return new int[0];
    }
    LinkedList<Integer> q = new LinkedList<Integer>();
    int[] res = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
        q.removeLast();
      }
      q.addLast(i);
      if (i - q.getFirst() + 1 > k) {
        q.removeFirst();
      }
      if (i + 1 >= k) {
        res[i - k + 1] = nums[q.getFirst()];
      }
    }
    return res;
  }
}
