public class Solution {
  public int myAtoi(String str) {
    if (str == null || str.equals("")) {
      return 0;
    }
    long ans = 0;
    int index = 0;
    int positive = 1;
    while (str.charAt(index) == ' ') {
      index++;
    }
    if (str.charAt(index) == '-') {
      positive = -1;
      index++;
    } else if(str.charAt(index) == '+') {
      positive = 1;
      index++;
    }
    while (index < str.length()) {
      if (!Character.isDigit(str.charAt(index))) {
        break;
      }
      int num = (int)(str.charAt(index) - '0');
      ans = ans * 10 + num;
      index++;
      if (positive > 0 && ans * positive > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else if (positive < 0 && ans * positive < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
    }
    if (positive == -1) {
      ans = -ans;
    }
    return (int)ans;
  }
}
