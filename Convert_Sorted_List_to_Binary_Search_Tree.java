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
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while( head != null )
		{
			arr.add( head.val );
			head = head.next;
		}
		return buildBST( arr, 0, arr.size() - 1 );
	}
	public TreeNode buildBST( ArrayList<Integer> num, int low, int hi )
	{
		if( low > hi ) return null;
		int mid = ( low + hi ) / 2;
		TreeNode node = new TreeNode( num.get(mid) );
		node.left = buildBST( num, low, mid - 1 );
		node.right = buildBST( num, mid + 1, hi );
		return node;
	}
}
