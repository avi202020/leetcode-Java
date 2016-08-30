public class Solution {
  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return -1;
    }
    
    int slowp = nums[0];
    int fastp = nums[nums[0]];
    while (fastp != slowp) {
      slowp = nums[slowp];
      fastp = nums[nums[fastp]];
    }
    slowp = 0;
    while (fastp != slowp) {
      slowp = nums[slowp];
      fastp = nums[fastp];
    }
    return slowp;
  }
}
