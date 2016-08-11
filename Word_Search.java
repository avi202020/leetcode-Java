public class Solution {
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (word.charAt(0) == board[i][j]) {
          boolean[][] visited = new boolean[m][n];
          boolean success = existHelper(board, word, visited, dir, i, j, 0);
          if (success) {
            return true;
          }
        }
      }
    }
    return false;
  }
  public boolean existHelper(char[][] board, String word, boolean[][] visited, int[][] dirs, int x, int y, int depth) {
    if (board[x][y] == word.charAt(depth)) {
      if (depth == word.length() - 1) {
        return true;
      }
      visited[x][y] = true;
      for (int i = 0; i < 4; ++i) {
        int nx = x + dirs[i][0];
        int ny = y + dirs[i][1];
        if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
          continue;
        }
        if (visited[nx][ny]) {
          continue;
        }
        boolean success = existHelper(board, word, visited, dirs, nx, ny, depth + 1);
        if (success) {
          return true;
        }
      }
      visited[x][y] = false;
    }
    return false;
  }
}
