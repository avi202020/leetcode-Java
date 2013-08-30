package Tree;

import java.util.ArrayList;

import Tree.TreeNode;

public class BinaryTree {

	public static TreeNode createBinaryTree(int[] arr) {
		TreeNode node = _createBinaryTree(arr, 0, arr.length - 1);
		return node;
	}

	private static TreeNode _createBinaryTree(int[] arr, int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = _createBinaryTree(arr, left, mid - 1);
		node.right = _createBinaryTree(arr, mid + 1, right);
		return node;
	}

	public static void inOrder(TreeNode root) {
		_inOrder(root);
		System.out.println();
	}

	private static void _inOrder(TreeNode root) {
		if (root == null)
			return;
		_inOrder(root.left);
		System.out.print(root.data + " ");
		_inOrder(root.right);
	}

	public static void preOrder(TreeNode root) {
		_preOrder(root);
		System.out.println();
	}

	private static void _preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		_preOrder(root.left);
		_preOrder(root.right);
	}

	public static void postOrder(TreeNode root) {
		_postOrder(root);
		System.out.println();
	}

	private static void _postOrder(TreeNode root) {
		if (root == null)
			return;
		_postOrder(root.left);
		_postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void levelOrder(TreeNode root) {
		if (root == null)
			return;
		ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
		arr.add(root);
		int end = arr.size() - 1;
		int cur = 0;
		while (cur < arr.size()) {
			while (cur <= end) {
				TreeNode node = arr.get(cur);
				System.out.print(node.data + " ");
				if (node.left != null)
					arr.add(node.left);
				if (node.right != null)
					arr.add(node.right);
				cur++;
			}
			System.out.println(", ");
			end = arr.size() - 1;
		}
	}

	public static void serialize(TreeNode root) {
		if (root == null) {
			System.out.print("# ");
		} else {
			System.out.print(root.data + " ");
			serialize(root.left);
			serialize(root.right);
		}
	}
/*	
	public static TreeNode deserialize( String str ) {
		
	}
	
	private static TreeNode _deserialize( String str, int index ) {
		for( int i = index; i <  )
	}
*/
	
	public static void main(String[] argv) {
		TreeNode root = BinaryTree.createBinaryTree(new int[] { 1, 2, 3, 4, 5,
				6, 7, 8, 9 });
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		BinaryTree.serialize(n1);
		//levelOrder(root);
	}

}
