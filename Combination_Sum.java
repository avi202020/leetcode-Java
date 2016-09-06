public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) {
      return res;
    }
    Arrays.sort(candidates);
    List<Integer> item = new ArrayList<Integer>();
    combinationSumHelper(candidates, 0, target, item, res);
    return res;
  }
  public void combinationSumHelper(int[] candidates, int index, int target, List<Integer> item, List<List<Integer>> res) {
    if (target == 0) {
      List<Integer> temp = new ArrayList<Integer>(item);
      res.add(temp);
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      if (target - candidates[i] < 0) {
        return;
      }
      item.add(candidates[i]);
      combinationSumHelper(candidates, i, target - candidates[i], item, res);
      item.remove(item.size() - 1);
    }
  }
}
