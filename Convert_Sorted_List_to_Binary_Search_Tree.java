/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if( head == null ) 
            return null;
        if( head.next == null )
            return new TreeNode( head.val );
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while( fast.next != null ) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if( fast.next != null )
                fast = fast.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST( head );
        root.right = sortedListToBST( slow.next );
        return root;
    }
}
