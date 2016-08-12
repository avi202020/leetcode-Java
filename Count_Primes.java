public class Solution {
  public int countPrimes(int n) {
    boolean[] notPrime = new boolean[n+1];
    for (int i = 2; i <= n/2; ++i) {
      if (!notPrime[i]) {
        for (int j = 2; j * i < n; ++j) {
          notPrime[j*i] = true;
        }
      }
    }
    int res = 0;
    for (int i = 2; i < n; ++i) {
      if (!notPrime[i]) {
        res++;
      }
    }
    return res;
  }
}
