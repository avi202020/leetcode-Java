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
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    int[] result = new int[nums.length - k + 1];
    LinkedList<Integer> deque = new LinkedList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (!deque.isEmpty() && deque.peekFirst() == i - k) {
        deque.poll();
      }
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.removeLast();
      }
      deque.offer(i);
      if (i + 1 >= k) {
        result[i + 1 - k] = nums[deque.peek()];
      }
    }
    return result;
  }
}
