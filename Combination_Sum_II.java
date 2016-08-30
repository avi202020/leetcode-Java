public class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) {
      return res;
    }
    Arrays.sort(candidates);
    List<Integer> item = new ArrayList<Integer>();
    combinationSum2Helper(candidates, 0, target, item, res);
    return res;
  }
  public void combinationSum2Helper(int[] candidates, int index, int target, List<Integer> item, List<List<Integer>> res) {
    if (target == 0) {
      List<Integer> temp = new ArrayList<Integer>(item);
      res.add(temp);
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }
      if (target - candidates[i] < 0) {
        return;
      }
      item.add(candidates[i]);
      combinationSum2Helper(candidates, i + 1, target - candidates[i], item, res);
      item.remove(item.size() - 1);
    }
  }
}
