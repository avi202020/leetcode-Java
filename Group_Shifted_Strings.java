public class Solution {
  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> res = new ArrayList<List<String>>();
    if (strings == null || strings.length == 0) {
      return res;
    }
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (int i = 0; i < strings.length; ++i) {
      String key = getKey(strings[i]);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<String>());
      }
      map.get(key).add(strings[i]);
    }
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      res.add(entry.getValue());
    }
    return res;
  }
  private String getKey(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    StringBuilder shifted = new StringBuilder();
    int shift = s.charAt(0) - 'a';
    for (int i = 0; i < s.length(); ++i) {
      int ascii = s.charAt(i) - shift;
      if ((char)ascii < 'a') {
        ascii = ascii + 26;
      }
      shifted.append((char)ascii);
    }
    return shifted.toString();
  }
}
