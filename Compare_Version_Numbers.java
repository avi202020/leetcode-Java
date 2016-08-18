public class Solution {
  public int compareVersion(String version1, String version2) {
    String[] str1 = version1.split("\\.");
    String[] str2 = version2.split("\\.");
    int maxLen = Math.max(str1.length, str2.length);
    for (int i = 0; i < maxLen; ++i) {
      int digit1 = 0;
      int digit2 = 0;
      if (i < str1.length) {
        digit1 = Integer.parseInt(str1[i]);
      }
      if (i < str2.length) {
        digit2 = Integer.parseInt(str2[i]);
      }
      if (digit1 > digit2) {
        return 1;
      }
      if (digit1 < digit2) {
        return -1;
      }
    }
    return 0;
  }
}
