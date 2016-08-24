// Solution 1. heap
public class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
    for (int i = 0; i < nums.length; ++i) {
      heap.offer(nums[i]);
      if (heap.size() > k) {
        heap.poll();
      }
    }
    return heap.peek();
  }
}
