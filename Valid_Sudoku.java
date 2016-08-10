public class Solution {
  public boolean isValidSudoku(char[][] board) {
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] cub = new boolean[9][10];
    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[0].length; ++j) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '0';
          if (row[i][num]) {
            return false;
          }
          if (col[j][num]) {
            return false;
          }
          int cubindex = i / 3 * 3 + j / 3;
          if (cub[cubindex][num]) {
            return false;
          }
          row[i][num] = true;
          col[j][num] = true;
          cub[cubindex][num] = true;
        }
      }
    }
    return true;
  }
}
