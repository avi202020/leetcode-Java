public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<List<String>>();
    if (strs == null || strs.length == 0) {
      return res;
    }
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (int i = 0; i < strs.length; ++i) {
      char[] arr = strs[i].toCharArray();
      Arrays.sort(arr);
      String key = new String(arr);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<String>());
      }
      map.get(key).add(strs[i]);
    }
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      res.add(entry.getValue());
    }
    return res;
  }
}
