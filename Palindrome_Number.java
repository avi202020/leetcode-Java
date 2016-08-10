// 1. naive method 
public class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int div = 1;
    while (x / div >= 10) {
      div = div * 10;
    }
    while (x != 0) {
      int lh = x / div;
      int rh = x % 10;
      if (lh != rh) {
        return false;
      }
      x = (x % div) / 10;
      div = div / 100;
    }
    return true;
  }
}

// 2. recursive method 
public class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int div = 1;
    while (x / div >= 10) {
      div = div * 10;
    }
    return dfsIsPalindrome(x, div);
  }

  public boolean dfsIsPalindrome(int x, int div) {
    if (x / 10 == 0) {
      return true;
    }
    int l = x / div;
    int r = x % 10;
    if (l != r) {
      return false;
    }
    x = (x % div) / 10;
    return dfsIsPalindrome(x, div / 100);
  }
}
