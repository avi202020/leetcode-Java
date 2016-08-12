public class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    int position1 = -1;
    int position2 = -1;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; ++i) {
      if (words[i].equals(word1)) {
        if (position2 != -1) {
          min = Math.min(min, i - position2);
        }
        position1 = i;
      }
      if (words[i].equals(word2)) {
        if (position1 != -1) {
          min = Math.min(min, i - position1);
        }
        position2 = i;
      }
    }
    return min;
  }
}
