public class Solution {
  public int compareVersion(String version1, String version2) {
    String[] numbers1 = version1.split("\\.");
    String[] numbers2 = version2.split("\\.");
    int len = Math.max(numbers1.length, numbers2.length);
    int cur = 0;
    while (cur < len) {
      int v1 = cur < numbers1.length ? Integer.valueOf(numbers1[cur]) : 0;
      int v2 = cur < numbers2.length ? Integer.valueOf(numbers2[cur]) : 0;
      if (v1 < v2)
        return -1;
      else if (v1 > v2)
        return 1;
      cur++;
    }
    return 0;
  }
}
