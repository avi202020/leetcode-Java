public class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> ans = new ArrayList<Integer>();
    for (int i = 0; i <= rowIndex; ++i) {
      ans.add(0);
    }
    ans.set(0, 1);
    for (int i = 1; i <= rowIndex; ++i) {
      for (int j = i; j >= 0; --j) {
        if (j == i || j == 0) {
          ans.set(j, 1);
        } else {
          ans.set(j, ans.get(j - 1) + ans.get(j));
        }
      }
    }
    return ans;
  }
}
