public class Solution {
  public int largestRectangleArea(int[] height) {
    int ans = 0;
    Stack<Integer> heights = new Stack<Integer>();
    Stack<Integer> indexes = new Stack<Integer>();
    for (int i = 0; i < height.length; ++i) {
      if (heights.isEmpty() || height[i] > heights.peek()) {
        indexes.push(i);
        heights.push(height[i]);
      } else if (height[i] < heights.peek()) {
        int lastIndex = 0;
        while (!heights.isEmpty() && height[i] < heights.peek()) {
          lastIndex = indexes.pop();
          int tmp = heights.pop() * (i - lastIndex);
          ans = Math.max(ans, tmp);
        }
        heights.push(height[i]);
        indexes.push(lastIndex);
      }
    }
    while (!heights.isEmpty()) {
      int tmp = heights.pop() * (height.length - indexes.pop());
      ans = Math.max(ans, tmp);
    }
    return ans;
  }
}
