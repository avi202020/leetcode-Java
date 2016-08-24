public class Solution {
   public List<Integer> spiralOrder(int[][] matrix) {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    List<Integer> res = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0) {
      return res;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] visited = new boolean[m][n];
    spiralOrderHelper(matrix, 0, 0, dirs, 0, visited, res);
    return res;
  }
  private void spiralOrderHelper(int[][] matrix, int x, int y, int[][] dirs, int dir,
                                          boolean[][] visited, List<Integer> res) {
    if (res.size() >= matrix.length * matrix[0].length) {
      return;
    }
    res.add(matrix[x][y]);
    visited[x][y] = true;
    int nx = x + dirs[dir][0];
    int ny = y + dirs[dir][1];
    if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || visited[nx][ny]) {
      dir = (dir + 1) % 4;
      nx = x + dirs[dir][0];
      ny = y + dirs[dir][1];
    }
    spiralOrderHelper(matrix, nx, ny, dirs, dir, visited, res);
  }
}
