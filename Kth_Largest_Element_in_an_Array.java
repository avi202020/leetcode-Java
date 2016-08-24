// Solution 1. quick select
public class Solution {
  public int findKthLargest(int[] nums, int k) {
    if (k < 1 || nums == null || nums.length == 0) {
      return 0;
    }
    return findKthLargestHelper(nums, nums.length - k + 1, 0, nums.length - 1);
  }

  private int findKthLargestHelper(int[] nums, int k, int lo, int hi) {
    int pivot = nums[hi];
    int left = lo;
    int right = hi;
    while (true) {
      while (nums[left] < pivot && left < right) {
        left++;
      }
      while (nums[right] >= pivot && right > left) {
        right--;
      }
      if (left >= right) {
        break;
      }
      swap(nums, left, right);
    }
    swap(nums, left, hi);
    if (k == left + 1) {
      return pivot;
    } else if (k < left + 1) {
      return findKthLargestHelper(nums, k, lo, left - 1);
    } else {
      return findKthLargestHelper(nums, k, left + 1, hi);
    }
  }
  
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

// Solution 2. heap
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
