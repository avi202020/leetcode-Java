// Solution 1. O(n) time, 0(1) space
public class Solution {
  public void sortColors(int[] nums) {
    int index0 = 0;
    int cur = 0;
    int index2 = nums.length - 1;
    while (cur <= index2) {
      if (nums[cur] == 1) {
        cur++;
      } else if (nums[cur] == 2) {
        swap(nums, cur, index2);
        index2--;
      } else if (nums[cur] == 0) {
        swap(nums, cur, index0);
        index0++;
        cur++;
      } 
    }
  }
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

// Solution 2. naive solution O(n) time, O(n) space
public class Solution {
  public void sortColors(int[] nums) {
    // Start typing your Java solution below
    // DO NOT write main() function
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; ++i) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }
    int index = 0;
    for (int i = 0; i <= 2; ++i) {
      if (map.containsKey(i)) {
        for (int j = 0; j < map.get(i); ++j) {
          nums[index++] = i;
        }
      }
    }
  }
}


