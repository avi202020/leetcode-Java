// solution 1.
public class Solution {
  public int removeDuplicates(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (A.length == 0) {
      return 0;
    }
    int cur = 1;
    for (int i = 1; i < A.length; ++i) {
      if (A[i] != A[i-1])
        A[cur++] = A[i];
    }
    return cur;
  }
}

// solution 2.
public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int left = 0;
    int right = 0;
    while (right < nums.length) {
      if (nums[left] != nums[right]) {
        left++;
        nums[left] = nums[right];
      }
      right++;
    }
    return left + 1;
  }
}
