public class Solution {
  public void reverseWords(char[] s) {
    if (s == null || s.length <= 1) {
      return;
    }
    reverseWordsHelper(s, 0, s.length - 1);
    int lastStart = 0;
    for (int i = 0; i <= s.length; ++i) {
      if (i == s.length || s[i] == ' ') {
        reverseWordsHelper(s, lastStart, i - 1);
        lastStart = i + 1;
      }
    }
  }
  private void reverseWordsHelper(char[] s, int i, int j) {
    int left = i;
    int right = j;
    while (left < right) {
      char tmp = s[left];
      s[left] = s[right];
      s[right] = tmp;
      left++;
      right--;
    }
  }
}
