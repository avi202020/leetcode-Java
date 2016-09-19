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
// solution 1. stack
public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    Stack<ListNode> stack = new Stack<ListNode>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    ListNode newHead = new ListNode(-1);
    ListNode pre = newHead;
    while (!stack.isEmpty()) {
      ListNode node = stack.pop();
      pre.next = node;
      pre = node;
    }
    pre.next = null;
    return newHead.next;
  }
}

// solution 2. recursion
public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode next = head.next;
    ListNode newhead = reverseList(next);
    next.next = head;
    head.next = null;
    return newhead;
  }
}

