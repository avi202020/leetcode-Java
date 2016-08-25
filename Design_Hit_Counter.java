// Solution 1. linked list queue
public class HitCounter {

  /** Initialize your data structure here. */
  Queue<Integer> queue;

  public HitCounter() {
    queue = new LinkedList<Integer>();
  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  public void hit(int timestamp) {
    queue.offer(timestamp);
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  public int getHits(int timestamp) {
    while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
      queue.poll();
    }
    return queue.size();
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

