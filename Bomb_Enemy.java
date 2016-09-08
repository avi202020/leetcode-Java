public class Solution {
  public int maxKilledEnemies(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int[][] left = new int[m][n];
    int[][] right = new int[m][n];
    int[][] top = new int[m][n];
    int[][] bottom = new int[m][n];
    for (int i = 0; i < m; ++i) {
      int sum = 0;
      for (int j = 0; j < n; ++j) {
        sum = processHelper(grid, i, j, left, sum);
      }
      sum = 0;
      for (int j = n - 1; j >= 0; --j) {
        sum = processHelper(grid, i, j, right, sum);
      }
    }
    for (int j = 0; j < n; ++j) {
      int sum = 0;
      for (int i = 0; i < m; ++i) {
        sum = processHelper(grid, i, j, top, sum);
      }
      sum = 0;
      for (int i = m - 1; i >= 0; --i) {
        sum = processHelper(grid, i, j, bottom, sum);
      }
    }
    int res = 0;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        int local = left[i][j] + right[i][j] + top[i][j] + bottom[i][j];
        res = Math.max(res, local);
      }
    }
    return res;
  }

  private int processHelper(char[][] grid, int i, int j, int[][] enemy, int sum) {
    if (grid[i][j] == 'E') {
      enemy[i][j] = 0;
      sum = sum + 1;
    } else if (grid[i][j] == 'W') {
      enemy[i][j] = 0;
      sum = 0;
    } else if (grid[i][j] == '0') {
      enemy[i][j] = sum;
    }
    return sum;
  }
}
