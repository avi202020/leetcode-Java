public class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> res = new ArrayList<String>();
    if (s == null || s.length() <= 10) {
      return res;
    }
    Map<String, Integer> counter = new HashMap<String, Integer>();
    for (int i = 0; i <= s.length() - 10; ++i) {
      String str = s.substring(i, i + 10);
      if (!counter.containsKey(str)) {
        counter.put(str, 1);
      } else {
        counter.put(str, counter.get(str) + 1);
      }
    }
    for (String key : counter.keySet()) {
      if (counter.get(key) > 1) {
        res.add(key);
      }
    }
    return res;
  }
}
