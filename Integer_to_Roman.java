public class Solution {
  public String intToRoman(int num) {
    if (num <= 0) {
      return "";
    }
    char[] roman = "IVXLCDM".toCharArray();
    int index = 0;
    StringBuilder res = new StringBuilder();
    while (num > 0) {
      int curdigit = num % 10;
      num = num / 10;
      StringBuilder digit = new StringBuilder();
      if (curdigit == 9) {
        digit.append(roman[index]);
        digit.append(roman[index+2]);
      } else if (curdigit == 4) {
        digit.append(roman[index]);
        digit.append(roman[index+1]);
      } else {
        if (curdigit >= 5) {
          digit.append(roman[index+1]);
          curdigit = curdigit - 5;
        }
        for (int i = 1; i <= curdigit; ++i) {
          digit.append(roman[index]);
        }
      }
      res.insert(0, digit.toString());
      index = index + 2;
    }
    return res.toString();
  }
}
