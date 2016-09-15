public class Solution {
  
  private int []nums;
  private Random r = new Random();
  public Solution(int[] nums) {
    this.nums = nums;
  }

  public int pick(int target) {
    List<Integer> idxs = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (target == nums[i]) {
        idxs.add(i);
      }
    }
    return idxs.get(r.nextInt(idxs.size()));
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
