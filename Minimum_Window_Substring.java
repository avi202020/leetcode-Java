public class Solution {
  public String minWindow(String S, String T) {
    Map<Character, Integer> need = new HashMap<Character, Integer>();
    Map<Character, Integer> found = new HashMap<Character, Integer>();
    int minLength = Integer.MAX_VALUE;
    int ansBegin = 0;
    int ansEnd = 0;
    for (int i = 0; i < T.length(); ++i) {
      char c = T.charAt(i);
      if (need.containsKey(c)) {
        need.put(c, need.get(c) + 1);
      } else {
        need.put(c, 1);
      }
    }
    int begin = 0;
    int end = 0;
    int counter = 0;
    for (end = 0; end < S.length(); ++end) {
      char ch = S.charAt(end);
      if (!need.containsKey(ch)) {
        continue;
      }
      if (found.containsKey(ch)) {
        found.put(ch, found.get(ch) + 1);
      } else {
        found.put(ch, 1);
      }
      if (found.get(ch) <= need.get(ch)) {
        counter++;
      }

      if (counter == T.length()) {
        char ch2 = S.charAt(begin);
        while (!need.containsKey(ch2) || found.get(ch2) > need.get(ch2)) {
          if (found.containsKey(ch2) && found.get(ch2) > need.get(ch2)) {
            found.put(ch2, found.get(ch2) - 1);
          }
          begin++;
          ch2 = S.charAt(begin);
        }

        int curLen = end - begin + 1;
        if (curLen < minLength) {
          minLength = curLen;
          ansBegin = begin;
          ansEnd = end;
        }
      }
    }
    if (counter == T.length()) {
      return S.substring(ansBegin, ansEnd + 1);
    }
    return "";
  }
}
