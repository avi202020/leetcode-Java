package Tree;
import Tree.TreeNode;
import Tree.BinaryTree;

public class Morris {
	
	// inOrder Morris Traversal
	public static void inMorrisTraversal( TreeNode root ) {
		if( root == null ) return;
		TreeNode cur = null;
		TreeNode pre = null;
		cur = root;
		while( cur != null ) {
			// 当前节点没有左后代, 访问当前节点, 跳到右后代
			if( cur.left == null ) {
				System.out.print( cur.data + " " );
				cur = cur.right;
			}
			// 当前节点有左后代
			else {
				pre = cur.left;
				while( pre.right != null && pre.right != cur ) {
					pre = pre.right;
				}
				
				// 将左后代的最右叶子指向当前节点, 跳到左后代
				// 表示当前节点的左子树未访问
				if( pre.right == null ) {
					pre.right = cur;
					cur = cur.left;
				}
				// 恢复该节点索引指针
				// 表示当前节点的左子树已访问
				else {
					pre.right = null;
					System.out.print( cur.data + " " );
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}
	
	// preOrder Morris Traversal
	public static void preMorrisTraversal( TreeNode root ) {
		if( root == null ) return;
		TreeNode cur = null;
		TreeNode pre = null;
		cur = root;
		while( cur != null ) {
			// 当前节点没有左后代, 访问当前节点, 跳到右后代
			if( cur.left == null ) {
				System.out.print( cur.data + " " );
				cur = cur.right;
			}
			// 当前节点有左后代
			else {
				pre = cur.left;
				while( pre.right != null && pre.right != cur ) {
					pre = pre.right;
				}
				
				// 将左后代的最右叶子指向当前节点, 跳到左后代
				// 表示当前节点的左子树未访问
				if( pre.right == null ) {
					pre.right = cur;
					System.out.print( cur.data + " " );
					cur = cur.left;
				}
				// 恢复该节点索引指针
				// 表示当前节点的左子树已访问
				else {
					pre.right = null;
					
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}

	// postOrder Morris Traversal
	public static void postMorrisTraversal(TreeNode root) {
		if( root == null ) return;
		TreeNode cur = null;
		TreeNode pre = null;
		cur = root;
		while( cur != null ) {
			// 当前节点没有左后代, 访问当前节点, 跳到右后代
			if( cur.left == null ) {
			//	System.out.print( cur.data + " " );
				cur = cur.right;
			}
			// 当前节点有左后代
			else {
				pre = cur.left;
				while( pre.right != null && pre.right != cur ) {
					pre = pre.right;
				}
				
				// 将左后代的最右叶子指向当前节点, 跳到左后代
				// 表示当前节点的左子树未访问
				if( pre.right == null ) {
					pre.right = cur;
					
					cur = cur.left;
				}
				// 恢复该节点索引指针
				// 表示当前节点的左子树已访问
				else {
					pre.right = null;	
					cur = cur.right;
				}
				System.out.print( cur.data + " " );
			}
			
		}
		System.out.println();
	}
	
	public static void main( String[] argv ) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = BinaryTree.createBinaryTree(arr);
		BinaryTree.preOrder(root);
		preMorrisTraversal(root);
		System.out.println("=======================================================");
		BinaryTree.inOrder(root);
		inMorrisTraversal(root);
		System.out.println("=======================================================");
		BinaryTree.postOrder(root);
		postMorrisTraversal(root);
	}
}