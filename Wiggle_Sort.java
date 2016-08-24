public class Solution {
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int len = nums.length;
    if (len <= 2) {
      return;
    }
    for (int i = 1; i < len - 1; i = i + 2) {
      int temp = nums[i];
      nums[i] = nums[i+1];
      nums[i+1] = temp;
    }
    return;
  }
}
