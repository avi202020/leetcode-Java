public class Solution {
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] nums = new int[length];
    for (int i = 0; i < updates.length; ++i) {
      int startIndex = updates[i][0];
      int endIndex = updates[i][1];
      int inc = updates[i][2];
      nums[startIndex] += inc;
      if (endIndex  + 1 < length) {
        nums[endIndex + 1] -= inc;
      }
    }
    int sum = nums[0];
    for (int i = 1; i < length; ++i) {
      sum += nums[i];
      nums[i] = sum;
    }
    return nums;
  }
}
