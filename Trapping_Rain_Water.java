public class Solution {
  public int trap(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    int leftHighest = height[0];
    for (int i = 1; i < height.length; ++i) {
      leftMax[i] = leftHighest;
      leftHighest = Math.max(leftHighest, height[i]);
    }
    int rightHighest = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; --i) {
      rightMax[i] = rightHighest;
      rightHighest = Math.max(rightHighest, height[i]);
    }
    int sum = 0;
    for (int i = 0; i < height.length; ++i) {
      if (Math.min(leftMax[i], rightMax[i]) > height[i] ) {
        sum = sum + (Math.min(leftMax[i], rightMax[i]) - height[i]);
      }
    }
    return sum;
  }
}
