public class Solution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<Character>();
    int max = 0;
    int left = 0;
    int right = 0;
    while (right < s.length()) {
      char cur = s.charAt(right);
      if (!set.contains(cur)) {
        set.add(cur);
        if (right - left + 1 > max) {
          max = right - left + 1;
        }
        right++;
      } else {
        while (s.charAt(left) != cur) {
          set.remove(s.charAt(left));
          left++;
        }
        set.remove(cur);
        left++;
      }
    }
    return max;
  }
}
