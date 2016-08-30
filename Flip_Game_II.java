public class Solution {
  public boolean canWin(String s) {
    char[] arr = s.toCharArray();
    for (int i = 0; i < s.length() - 1; i++) {
      if (arr[i] == '+' && arr[i + 1] == '+') {
        arr[i] = '-';
        arr[i + 1] = '-';
        String next = String.valueOf(arr);
        if (!canWin(next)) {
          return true;
        }
        arr[i] = '+';
        arr[i + 1] = '+';
      }
    }
    return false;
  }
}
