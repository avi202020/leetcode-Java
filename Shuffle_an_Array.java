public class Solution {

  private int[] nums;
  private Random random;
  public Solution(int[] nums) {
    this.nums = nums;
    random = new Random();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return nums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    int[] a = nums.clone();
    for(int i = 0; i < a.length; i++) {
      int j = random.nextInt(a.length);
      swap(a, i, j);
    }
    return a;
  }
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
