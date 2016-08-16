public class Solution {
  public int numIslands(char[][] grid) {
    int islands = 0;
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
        if (grid[i][j] == '1') {
          search(grid, i, j);
          islands++;
        }
      }
    }
    return islands;
  }
  public void search(char[][] grid, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
      return;
    }
    if (grid[x][y] == '0') {
      return;
    }
    grid[x][y] = '0';
    search(grid, x + 1, y);
    search(grid, x - 1, y);
    search(grid, x, y + 1);
    search(grid, x, y - 1);
  }
}
