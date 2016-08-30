/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializeHelper(root, sb);
    return sb.toString();
  }

  private void serializeHelper(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("# ");
    } else {
      sb.append(root.val + " ");
      serializeHelper(root.left, sb);
      serializeHelper(root.right, sb);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Deque<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(data.split(" ")));
    TreeNode root = deserializeHelper(nodes);
    return root;
  }

  private TreeNode deserializeHelper(Deque<String> nodes) {
    String nodeValue = nodes.pollFirst();
    if (nodeValue.equals("#")) {
      return null;
    } else {
      TreeNode root = new TreeNode(Integer.parseInt(nodeValue));
      root.left = deserializeHelper(nodes);
      root.right = deserializeHelper(nodes);
      return root;
    }
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
