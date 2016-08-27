public class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null) {
      return 0;
    }
    int m = matrix.length;
    if (m == 0) {
      return 0;
    }
    int n = matrix[0].length;
    if (n == 0) {
      return 0;
    }
    int[][] dp = new int[m][n];
    int max = 0;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == '1') {
        dp[i][0] = 1;
        max = 1;
      }
    }
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == '1') {
        dp[0][j] = 1;
        max = 1;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == '1') {
          dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
          max = Math.max(max, dp[i][j] * dp[i][j]);
        }
      }
    }
    return max;
  }
}
