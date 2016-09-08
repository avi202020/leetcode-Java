public class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<List<String>>();
    if (s == null || s.length() == 0) {
      return ans;
    }
    List<String> path = new ArrayList<String>();
    partitionHelper(s, 0, path, ans);
    return ans;
  }
  public void partitionHelper(String s, int depth, List<String> path, List<List<String>> ans) {
    if (depth >= s.length()) {
      ArrayList<String> tmp = new ArrayList<String>(path);
      ans.add(tmp);
      return;
    }
    for (int i = depth + 1; i <= s.length(); ++i) {
      if (isPalindromeHelper(s.substring(depth, i))) {
        path.add(s.substring(depth, i));
        partitionHelper(s, i, path, ans);
        path.remove(path.size() - 1);
      }
    }
  }
  public boolean isPalindromeHelper(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
