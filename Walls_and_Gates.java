// Solution 1. DFS from gate
public class Solution {
  private static int INF = 2147483647;
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0) {
      return;
    }
    int m = rooms.length;
    int n = rooms[0].length;
    boolean[][] visited = new boolean[m][n];
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (rooms[i][j] == 0) {
          wallsAndGatesHelper(rooms, dirs, i, j, 0);
        }
      }
    }
    int a = 0;
  }
  private void wallsAndGatesHelper(int[][] rooms, int[][] dirs, int x, int y, int dist) {
    rooms[x][y] = dist;
    for (int i = 0; i < dirs.length; ++i) {
      int nx = x + dirs[i][0];
      int ny = y + dirs[i][1];
      if (nx < 0 || nx >= rooms.length || ny < 0 || ny >= rooms[0].length) {
        continue;
      }
      if (rooms[nx][ny] == -1) {
        continue;
      }
      if (dist + 1 >= rooms[nx][ny]) {
        continue;
      }
      wallsAndGatesHelper(rooms, dirs, nx, ny, dist + 1);
    }
  }
}


// Solution 2. BFS from gate
public class Solution {
  private static int INF = 2147483647;
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0) {
      return;
    }
    int m = rooms.length;
    int n = rooms[0].length;
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    Queue<int[]> queue = new LinkedList<int[]>();
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (rooms[i][j] == 0) {
          queue.offer(new int[]{i,j});
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] pos = queue.poll();
      int x = pos[0];
      int y = pos[1];
      for (int i = 0; i < dirs.length; ++i) {
        int nx = x + dirs[i][0];
        int ny = y + dirs[i][1];
        if (nx < 0 || nx >= rooms.length || ny < 0 || ny >= rooms[0].length) {
          continue;
        }
        if (rooms[nx][ny] == -1) {
          continue;
        }
        if (rooms[nx][ny] == INF) {
          rooms[nx][ny] = rooms[x][y] + 1;
          queue.offer(new int[]{nx,ny});
        }
      }
    }
  }
}
