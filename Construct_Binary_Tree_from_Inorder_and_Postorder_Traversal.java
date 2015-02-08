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
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if( inorder.length != postorder.length )
      return null;
    return buildTreeHelperInPost( inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1 );
  }
  public TreeNode buildTreeHelperInPost( int[] inorder, int instart, int inend, int[] poorder, int postart, int poend ) {
    if( instart > inend )
      return null;
    TreeNode root = new TreeNode( poorder[poend] );
    int position = findPosition(inorder, instart, inend, poorder[poend] );
    root.left = buildTreeHelperInPost(inorder, instart, position - 1, poorder, postart, postart + position - instart - 1);
    root.right = buildTreeHelperInPost(inorder, position + 1, inend, poorder, postart + position - instart, poend - 1);
    return root;
  }
  public int findPosition( int[] inorder, int start, int end, int key ) {
    for (int i = start; i <= end; ++i)
      if (inorder[i] == key)
        return i;
    return -1;
  } 
}
