public class Solution {
  public int firstUniqChar(String s) {
    Map<Character, Integer> counter = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      if (!counter.containsKey(ch)) {
        counter.put(ch, 1);
      } else {
        counter.put(ch, counter.get(ch) + 1);
      }
    }
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      int num = counter.get(ch);
      if (num == 1) {
        return i;
      }
    }
    return -1;
  }
}
