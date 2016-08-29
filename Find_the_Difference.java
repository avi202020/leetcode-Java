public class Solution {
  public char findTheDifference(String s, String t) {
    int[] counter1 = new int[26];
    int[] counter2 = new int[26];
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      counter1[ch - 'a']++;
    }
    for (int i = 0; i < t.length(); ++i) {
      char ch = t.charAt(i);
      counter2[ch - 'a']++;
    }
    char res= ' ';
    for (int i = 0; i < counter1.length; ++i) {
      if (counter1[i] != counter2[i]) {
        res = (char)('a' + i);
      }
    }
    return res;
  }
}
