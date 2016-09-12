// Solution 1. rotate image in-place
public class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < Math.ceil(((double) n) / 2.0); j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - 1 - j][i];
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
        matrix[j][n - 1 - i] = temp;
      }
    }
  }
}


// Solution 2.
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
