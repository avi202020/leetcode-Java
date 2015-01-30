public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if( k == 0 || k == 1 )
      return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode cur = dummy;
    while( true ) {
      for( int i = 1; i <= k; ++i ) {
        if( cur != null )
          cur = cur.next;
        else
          break;
      }
      if( cur == null )
        break;
      ListNode oldhead = prev.next;
      ListNode next = cur.next;
      cur.next = null;
      _reverseLinkList(oldhead);
      prev.next = cur;
      oldhead.next = next;
      prev = oldhead;
      cur = prev;
    }
    return dummy.next;
  }
  public ListNode _reverseLinkList(ListNode head) {
    if( head == null || head.next == null )
      return head;
    ListNode next = head.next;
    ListNode newhead = _reverseLinkList(head.next);
    next.next = head;
    head.next = null;
    return newhead;
  }
}
