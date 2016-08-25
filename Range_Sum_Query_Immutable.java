public class NumArray {

  int[] nums;
  int[] sums;
  public NumArray(int[] nums) {
    this.nums = nums;
    sums = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      sums[i] = sum;
    }
  }

  public int sumRange(int i, int j) {
    return sums[j] - sums[i] + nums[i];
  }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
