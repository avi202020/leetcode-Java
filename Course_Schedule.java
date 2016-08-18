public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for(int i = 0; i < prerequisites.length; i++) {
      // p is the dependency of q
      int p = prerequisites[i][1];
      int q = prerequisites[i][0];
      if (!graph.containsKey(p)) {
        graph.put(p, new ArrayList<Integer>());
      }
      graph.get(p).add(q);
      indegree[q]++;
    }
    //each course in this queue has no dependency on other courses.
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < numCourses; i++){
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    int res = 0;
    while (!queue.isEmpty()) {
      int c = queue.poll();
      res++;
      if (graph.containsKey(c)) {
        List<Integer> dep = graph.get(c);
        for (int cc : dep) {
          indegree[cc]--;
          if(indegree[cc] == 0) {
            queue.offer(cc);
          }
        }
      }
    }

    return res == numCourses;
  }
}
