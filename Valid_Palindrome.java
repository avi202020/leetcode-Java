public class Solution {
  public boolean isPalindrome(String s) {
    if (s.length() <= 1) {
      return true;
    }
    int left = 0;
    int right = s.length() - 1;
    s = s.toLowerCase();
    while (left < right) {
      if (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
        left++;
      } else if (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
        right--;
      } else {
        if (s.charAt(left) != s.charAt(right)) {
          return false;
        }
        left++;
        right--;
      }
    }
    return true;
  }
}
