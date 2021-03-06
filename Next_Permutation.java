public class Solution {
  public void nextPermutation(int[] num) {
    int len = num.length;
    int i = len - 1;
    // num[i] is the peak
    while (i >= 1 && num[i] <= num[i-1]) {
      i--;
    }
    // descending order
    if (i == 0) {
      int left = 0;
      int right = len - 1;
      while( left <= right ) {
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
        left++;
        right--;
      }
      return;
    }
    int j = len - 1;
    while (num[j] <= num[i-1]) {
      j--;
    }
    int tmp = num[j];
    num[j] = num[i-1];
    num[i-1] = tmp;
    j = len - 1;
    while (i < j) {
      tmp = num[i];
      num[i] = num[j];
      num[j] = tmp;
      i++;
      j--;
    }
  }
}
