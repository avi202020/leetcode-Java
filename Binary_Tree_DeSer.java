public class Solution {
  // Serialization
  public List<String> serialize(TreeNode root) {
    ArrayList<String> ans = new ArrayList<String>();
    serializeHelper(root, ans);
    return ans;
  }
  public void serializeHelper(TreeNode root, List<String> ans) {
    if( root == null ) {
      ans.add("#");
      return;
    }
    ans.add(String.valueOf(root.val));
    serializeHelper(root.left, ans);
    serializeHelper(root.right, ans);
  }


  // Deserialization
  public TreeNode deserialize(List<String> arr) {
    int depth[] = new int[]{0};
    return deserializeHelper(arr, depth);
  }
  public TreeNode deserializeHelper(List<String> arr, int[] depth ) {
    if( arr.get(depth[0]).equals("#") ) {
      depth[0] = depth[0] + 1;
      return null;
    }
    int num = Integer.valueOf(arr.get(depth[0]));
    TreeNode root = new TreeNode(num);
    depth[0] = depth[0] + 1;
    root.left = deserializeHelper(arr, depth);
    root.right = deserializeHelper(arr, depth);
    return root;
  }
}
