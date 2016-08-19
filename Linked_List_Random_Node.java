/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

  private ListNode node;
 
  /** @param head The linked list's head.
  Note that the head is guaranteed to be not null, so it contains at least one node. */
  public Solution(ListNode head) {
    node = head;
  }

  /** Returns a random node's value. */
  public int getRandom() {
    ListNode current = node;
    int val = current.val;
    Random random = new Random();
    int count = 0;
    while (current != null) {
      count++;
      if (random.nextInt(count) == 0) {
        val = current.val;
      }
      current = current.next;
    }
    return val;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
