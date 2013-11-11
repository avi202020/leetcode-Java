/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// Solution 1: dfs
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		if( node == null ) return null;
		HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> visit = new HashSet<UndirectedGraphNode>();
		UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
		map.put(node,newnode);
		dfs( node, newnode, map, visit );
		return newnode;
	}
	public void dfs( UndirectedGraphNode node, UndirectedGraphNode newnode, HashMap<UndirectedGraphNode,UndirectedGraphNode> map, HashSet<UndirectedGraphNode> visit ) {
		if( visit.contains(node) )
			return;
		visit.add(node);
		for( int i = 0; i < node.neighbors.size(); ++i ) {
			UndirectedGraphNode next = node.neighbors.get(i);
			if( !map.containsKey(next) ) {
				UndirectedGraphNode newnext = new UndirectedGraphNode(next.label);
				newnode.neighbors.add(newnext);
				map.put(next, newnext);
				dfs( next, newnext, map, visit );
			} else {
				newnode.neighbors.add(map.get(next));
			}
		}
	}
}

// Updated solution 1: dfs
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		if( node == null ) return null;
		HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> visit = new HashSet<UndirectedGraphNode>();
		UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
		map.put(node,newnode);
		dfs( node, map, visit );
		return newnode;
	}
	public void dfs( UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> map, HashSet<UndirectedGraphNode> visit ) {
		if( visit.contains(node) )
			return;
		visit.add(node);
		for( int i = 0; i < node.neighbors.size(); ++i ) {
			UndirectedGraphNode next = node.neighbors.get(i);
			if( !map.containsKey(next) ) {
				UndirectedGraphNode newnext = new UndirectedGraphNode(next.label);
				map.get(node).neighbors.add(newnext);
				map.put(next, newnext);
				dfs( next, map, visit );
			} else {
				map.get(node).neighbors.add(map.get(next));
			}
		}
	}
}
