/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int mid = 0;
    int left = 1;
    int right = n;
    while (left < right) {
      mid = left + (right - left) / 2;
      int ret = guess(mid);
      if (ret == 0) {
        return mid;
      } else if (ret > 0) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}
