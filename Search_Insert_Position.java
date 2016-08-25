public class Solution {
  public int searchInsert(int[] nums, int target) {
    if (target <= nums[0]) {
      return 0;
    }
    if (target > nums[nums.length - 1]) {
      return nums.length;
    }
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (target <= nums[mid] && target > nums[mid-1]) {
        return mid;
      } else if (target > nums[mid]) {
        left = mid + 1;
      } else if (target <= nums[mid]) {
        right = mid - 1;
      }
    }
    return mid;
  }
}
