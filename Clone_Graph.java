/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// Updated solution 1: dfs
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    map.put(node, newNode);
    cloneGraphHelper(node, map, visited);
    return newNode;
  }
  public void cloneGraphHelper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map,
                               Set<UndirectedGraphNode> visited) {
    if (visited.contains(node)) {
      return;
    }
    visited.add(node);
    for (int i = 0; i < node.neighbors.size(); ++i) {
      UndirectedGraphNode next = node.neighbors.get(i);
      if (!map.containsKey(next)) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(next.label);
        map.put(next, newNode);
        map.get(node).neighbors.add(newNode);
      } else {
        map.get(node).neighbors.add(map.get(next));
      }
      cloneGraphHelper(next, map, visited);
    }
  }
}

// Solution 2: bfs
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    queue.add(node);
    UndirectedGraphNode res = new UndirectedGraphNode(node.label);
    map.put(node, res);
    while (!queue.isEmpty()) {
      UndirectedGraphNode graphNode = queue.poll();
      for (int i = 0; i < graphNode.neighbors.size(); ++i) {
        if (!map.containsKey(graphNode.neighbors.get(i))) {
          UndirectedGraphNode newNode = new UndirectedGraphNode(graphNode.neighbors.get(i).label);
          map.put(graphNode.neighbors.get(i), newNode);
          map.get(graphNode).neighbors.add(newNode);
          queue.offer(graphNode.neighbors.get(i));
        } else {
          map.get(graphNode).neighbors.add(map.get(graphNode.neighbors.get(i)));
        }
      }
    }
    return res;
  }
}
