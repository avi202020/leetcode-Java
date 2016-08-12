public class Solution {
  public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (pattern.length() != words.length) {
      return false;
    }
    Map<Character, String> relation = new HashMap<Character, String>();
    Set<String> existingWords = new HashSet<String>();
    for (int i = 0; i < pattern.length(); ++i) {
      char ch = pattern.charAt(i);
      String word = words[i];
      if (!relation.containsKey(ch)) {
        if (existingWords.contains(word)) {
          return false;
        } else {
          relation.put(ch, word);
          existingWords.add(word);
        }
      } else {
        if (!relation.get(ch).equals(word)) {
          return false;
        }
      }
    }
    return true;
  }
}
