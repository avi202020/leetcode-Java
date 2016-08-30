public class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    int[] candidates = new int[9];
    for (int i = 0; i < candidates.length; ++i) {
      candidates[i] = i + 1;
    }
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> item = new ArrayList<Integer>();
    combinationSum3Helper(candidates, 0, k, n, item, res);
    return res;
  }
  public void combinationSum3Helper(int[] candidates, int index, int max, int target, List<Integer> item, List<List<Integer>> res) {
    if (target == 0) {
      if (item.size() == max) {
        List<Integer> temp = new ArrayList<Integer>(item);
        res.add(temp);
      }
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      if (target - candidates[i] < 0) {
        return;
      }
      item.add(candidates[i]);
      combinationSum3Helper(candidates, i + 1, max, target - candidates[i], item, res);
      item.remove(item.size() - 1);
    }
  }
}
