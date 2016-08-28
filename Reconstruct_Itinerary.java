ipublic class Solution {
  public List<String> findItinerary(String[][] tickets) {
    Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
    LinkedList<String> res = new LinkedList<String>();
    for (int i = 0; i < tickets.length; i++) {
      String from = tickets[i][0];
      String to = tickets[i][1];
      if (!graph.containsKey(from)) {
        PriorityQueue<String> out = new PriorityQueue<String>();
        out.offer(to);
        graph.put(from, out);
      } else {
        graph.get(from).offer(to);
      }
    }
    findItineraryHelper(graph, "JFK", res);
    return res;
  }
  public void findItineraryHelper(Map<String, PriorityQueue<String>> graph, String src,
                                  LinkedList<String> res) {
    PriorityQueue<String> q = graph.get(src);
    while (q != null && !q.isEmpty()) {
      String to = q.poll();
      findItineraryHelper(graph, to, res);
    }
    res.addFirst(src);
  }
}
