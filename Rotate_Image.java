// Solution 1.
public class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int[][] result = new int[n][];
    for (int i = 0; i < n; ++i) {
      result[i] = new int[n];
    }
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        result[i][j] = matrix[n - 1 - j][i];
      }
    }
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        matrix[i][j] = result[i][j];
      }
    }
  }
}
