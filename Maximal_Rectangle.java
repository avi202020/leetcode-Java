public class Solution {
  public int maximalRectangle(char[][] matrix) {
    int max = 0;
    if (matrix.length == 0) return max;
    int[][] m = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[0].length; ++j) {
        if (i == 0) {
          m[i][j] = (matrix[i][j] == '1' ? 1 : 0);
        } else {
          m[i][j] = (matrix[i][j] == '1' ? m[i - 1][j] + 1 : 0);
        }
      }
    }
    for (int i = 0; i < matrix.length; ++i) {
      int area = largestRectangleArea(m[i]);
      if (area > max) max = area;
    }
    return max;
  }

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
