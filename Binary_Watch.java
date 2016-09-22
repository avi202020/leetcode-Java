public class Solution {
  public List<String> readBinaryWatch(int num) {
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < 12; ++i) {
      for (int j = 0; j < 60; ++j ) {
        int count1 = getBitOneNumber(i);
        int count2 = getBitOneNumber(j);
        if (count1 + count2 == num) {
          if (j < 10) {
            ans.add(i + ":" + "0" + j);
          } else {
            ans.add(i + ":" + j);
          }
        }
      }
    }
    return ans;
  }
  private int getBitOneNumber(int num) {
    int count = 0;
    while (num != 0) {
      num = num & (num - 1);
      count++;
    }
    return count;
  }
}
