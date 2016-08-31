public class Solution {
  public static int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null || s.length() <= 0) {
      return 0;
    }
    Map<Character, Integer> counter = new HashMap<Character, Integer>();
    int left = 0;
    int right = 0;
    int maxLen = 0;
    while (right < s.length()) {

      char chRight = s.charAt(right);
      if (!counter.containsKey(chRight)) {
        counter.put(chRight, 1);
      } else {
        counter.put(chRight, counter.get(chRight) + 1);
      }

      if (counter.size() > 2) {
        while (counter.size() > 2) {
          char charToRemove = s.charAt(left);
          counter.put(charToRemove, counter.get(charToRemove) - 1);
          if (counter.get(charToRemove) == 0) {
            counter.remove(charToRemove);
          }
          left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);

      } else {
        maxLen = Math.max(maxLen, right - left + 1);
      }
      right++;
    }
    return maxLen;
  }
}
