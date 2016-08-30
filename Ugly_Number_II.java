public class Solution {
  public int nthUglyNumber(int n) {
    PriorityQueue<Long> queue = new PriorityQueue<Long>();
    queue.add(1L);
    int count = 0;
    long res = 0;
    while (count < n) {
      res = queue.poll();
      if (!queue.isEmpty()) {
        while (res == queue.peek()) {
          queue.poll();
        }
      }
      queue.offer(res * 2);
      queue.offer(res * 3);
      queue.offer(res * 5);
      count++;
    }
    return (int)res;
  }
}
