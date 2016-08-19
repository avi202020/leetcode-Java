public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<SmallestHeapNode> heap = new PriorityQueue<SmallestHeapNode>(
        new Comparator<SmallestHeapNode>() {
          public int compare(SmallestHeapNode o1, SmallestHeapNode o2) {
            return o1.value - o2.value;
          }
    });
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] visited = new boolean[m][n];
    heap.offer(new SmallestHeapNode(matrix[0][0], 0, 0));
    visited[0][0] = true;
    int[][] dir = new int[][]{{1,0},{0,1}};
    int res = 0;
    for (int i = 0; i < k; ++i) {
      SmallestHeapNode node = heap.poll();
      res = node.value;
      for (int j = 0; j < dir.length; ++j) {
        int nx = node.x + dir[j][0];
        int ny = node.y + dir[j][1];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
          continue;
        }
        if (visited[nx][ny]) {
          continue;
        }
        heap.offer(new SmallestHeapNode(matrix[nx][ny], nx, ny));
        visited[nx][ny] = true;
      }
    }
    return res;
  }
  class SmallestHeapNode {
    int value;
    int x;
    int y;
    SmallestHeapNode(int value, int x, int y) {
      this.value = value;
      this.x = x;
      this.y = y;
    }
  }
}
