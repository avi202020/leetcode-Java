public class Solution {
  public String addBinary(String a, String b) {
    int len1 = a.length();
    int len2 = b.length();
    int diff = Math.abs(len2 - len1);
    if (len1 < len2) {
      for (int i = 0; i < diff; ++i) {
        a = "0" + a;
      }
    } else if (len1 > len2) {
      for (int i = 0; i < diff; ++i) {
        b = "0" + b;
      }
    }
    StringBuffer ans = new StringBuffer();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    while (i >= 0 || j >= 0) {
      int sum = 0;
      int digitA = a.charAt(i) - '0';
      int digitB = b.charAt(j) - '0';
      sum = digitA + digitB + carry;
      carry = sum / 2;
      sum = sum % 2;
      ans.insert(0, (char) (sum + '0'));
      i--;
      j--;
    }
    if (carry != 0) {
      ans.insert(0, "1");
    }
    return ans.toString();
  }
}
