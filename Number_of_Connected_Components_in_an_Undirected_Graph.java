public class Solution {
  public int countComponents(int n, int[][] edges) {
    Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

    // build the graph
    for (int i = 0; i < edges.length; ++i) {
      int node1 = edges[i][0];
      int node2 = edges[i][1];
      if (!graph.containsKey(node1)) {
        graph.put(node1, new HashSet<Integer>());
      }
      graph.get(node1).add(node2);
      if (!graph.containsKey(node2)) {
        graph.put(node2, new HashSet<Integer>());
      }
      graph.get(node2).add(node1);
    }

    int count = 0;
    boolean[] visisted = new boolean[n];
    for (int i = 0; i < n; ++i) {
      if (!visisted[i]) {
        countComponentsHelper(graph, visisted, i);
        count++;
      }
    }
    return count;
  }

  private void countComponentsHelper(Map<Integer, Set<Integer>> graph, boolean[] visited, int i) {
    if (visited[i]) {
      return;
    }
    visited[i] = true;
    Set<Integer> neighbors = graph.get(i);
    if (neighbors == null || neighbors.size() == 0) {
      return;
    }
    for (int neighbor : neighbors) {
      countComponentsHelper(graph, visited, neighbor);
    }
  }
}
