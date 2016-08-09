/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummyHead = new ListNode(-1);
    ListNode pre = dummyHead;
    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        if (o1.val < o2.val) {
          return -1;
        } else if (o1.val > o2.val) {
          return 1;
        }
        return 0;
      }
    });
    for (int i = 0; i < lists.length; ++i) {
      if (lists[i] != null) {
        heap.offer(lists[i]);
      }
    }
    while (!heap.isEmpty()) {
      ListNode cur = heap.poll();
      pre.next = cur;
      pre = cur;
      if (cur.next != null) {
        heap.offer(cur.next);
      }
    }
    return dummyHead.next;
  }
}
