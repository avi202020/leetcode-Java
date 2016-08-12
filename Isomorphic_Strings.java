public class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Character> relation = new HashMap<Character, Character>();
    Set<Character> existingChars = new HashSet<Character>();
    for (int i = 0; i < s.length(); ++i) {
      char charOfS = s.charAt(i);
      char charOfT = t.charAt(i);
      if (!relation.containsKey(charOfS)) {
        if (!existingChars.contains(charOfT)) {
          relation.put(charOfS, charOfT);
          existingChars.add(charOfT);
        } else {
          return false;
        }
      } else {
        if (charOfT != relation.get(charOfS)) {
          return false;
        }
      }
    }
    return true;
  }
}
