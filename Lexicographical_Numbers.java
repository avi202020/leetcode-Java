public class Solution {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<Integer>();
    if (n <= 0) {
      return result;
    }
    int tmp = 1;
    for (int i = 1; i <= n; i++) {
      result.add(tmp);
      if (tmp * 10 <= n) {
        tmp *= 10;
      } else if (tmp + 1 <= n && tmp % 10 != 9) {
        tmp += 1;
      } else if (tmp % 10 != 9) {
        tmp = tmp / 10 + 1;
      } else {
        tmp++;
        while (tmp == (tmp / 10) * 10) {
          tmp /= 10;
        }
      }
    }
    return result;
  }
}
