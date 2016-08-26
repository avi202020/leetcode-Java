// Solution 1. DFS + memorization
public class Solution {
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int res = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] mem = new int[m][n];
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int length = longestIncreasingPathHelper(matrix, mem, dirs, i, j);
        res = Math.max(res, length);
      }
    }
    return res;
  }
  private int longestIncreasingPathHelper(int[][] matrix, int[][] mem, int[][] dirs, int x, int y) {
    if (mem[x][y] != 0) {
      return mem[x][y];
    }
    int longest = 1;
    for (int i = 0; i < dirs.length; ++i) {
      int nx = x + dirs[i][0];
      int ny = y + dirs[i][1];
      if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length) {
        continue;
      }
      if (matrix[nx][ny] > matrix[x][y]) {
        int length = longestIncreasingPathHelper(matrix, mem, dirs, nx, ny);
        longest = Math.max(longest, length + 1);
      }
    }
    mem[x][y] = longest;
    return longest;
  }
}

// Solution 2. DFS but TLE
public class Solution {
  private int longest;
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    longest = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        longestIncreasingPathHelper(matrix, dirs, i, j, 1);
      }
    }
    return longest;
  }
  private void longestIncreasingPathHelper(int[][] matrix, int[][] dirs, int x, int y, int len) {
    longest = Math.max(longest, len);
    for (int i = 0; i < dirs.length; ++i) {
      int nx = x + dirs[i][0];
      int ny = y + dirs[i][1];
      if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length ) {
        continue;
      }
      if (matrix[nx][ny] > matrix[x][y]) {
        longestIncreasingPathHelper(matrix, dirs, nx, ny, len + 1);
      }
    }
  }
}
