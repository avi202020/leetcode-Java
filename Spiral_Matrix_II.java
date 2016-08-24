public class Solution {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    if (n <= 0) {
      return matrix;
    }
    boolean[][] visited = new boolean[n][n];
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    generateMatrixHelper(matrix, 0, 0, 1, dirs, 0, visited);
    return matrix;
  }
  private void generateMatrixHelper(int[][] matrix, int x, int y, int depth,
                                    int[][] dirs, int dir, boolean[][] visited) {
    if (depth > matrix.length * matrix[0].length) {
      return;
    }
    visited[x][y] = true;
    matrix[x][y] = depth;
    int nx = x + dirs[dir][0];
    int ny = y + dirs[dir][1];
    if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || visited[nx][ny]) {
      dir = (dir + 1) % 4;
      nx = x + dirs[dir][0];
      ny = y + dirs[dir][1];
    }
    generateMatrixHelper(matrix, nx, ny, depth + 1, dirs, dir, visited);
  }
}
