public class Solution {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    getFactors(res, list, n, 2);
    return res;
  }

  private void getFactors(List<List<Integer>> res, List<Integer> list, int n, int factor) {
    if (n <= 1) {
      if (list.size() > 1) {
        res.add(new ArrayList<Integer>(list));
      }
      return;
    }

    for (int i = factor; i <= n; i++) {
      if (n % i == 0) {
        list.add(i);
        getFactors(res, list, n / i, i);
        list.remove(list.size() - 1);
      }
    }
  }
}
