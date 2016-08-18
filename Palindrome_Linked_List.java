/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution 1. O(n) time, O(1) space
public class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode pre = head;
    ListNode p1 = head;
    ListNode p2 = head;
    while (p2 != null) {
      pre = p1;
      p1 = p1.next;
      p2 = p2.next;
      if (p2 == null) {
        break;
      }
      p2 = p2.next;
    }
    pre.next = null;
    ListNode head2 = isPalindromeHelper(p1);
    while (head != null && head2 != null) {
      if (head.val != head2.val) {
        return false;
      }
      head = head.next;
      head2 = head2.next;
    }
    return true;
  }
  public ListNode isPalindromeHelper(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode next = head.next;
    ListNode newHead = isPalindromeHelper(next);
    next.next = head;
    head.next = null;
    return newHead;
  }
}

// Solution 2. O(n) time, O(n) space
public class Solution {
  public boolean isPalindrome(ListNode head) {
    Stack<ListNode> stack = new Stack<ListNode>();
    ListNode current = head;
    while (current != null) {
      stack.push(current);
      current = current.next;
    }
    current = head;
    while (current != null) {
      ListNode node = stack.pop();
      if (current.val != node.val) {
        return false;
      }
      current = current.next;
    }
    return true;
  }
}


