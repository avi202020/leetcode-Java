// Solution 1. Map counter
public class Solution {
  public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    Map<Character, Integer> counter = new HashMap<Character, Integer>();
    for (int i = 0; i < secret.length(); ++i) {
      if (i >= guess.length()) {
        break;
      }
      char charSecret = secret.charAt(i);
      char charGuess  = guess.charAt(i);
      if (charSecret == charGuess) {
        bulls++;
      } else {
        if (!counter.containsKey(charSecret)) {
          counter.put(charSecret, 0);
        }
        counter.put(charSecret, counter.get(charSecret) + 1);
        if (counter.get(charSecret) <= 0) {
          cows++;
        }
        if (!counter.containsKey(charGuess)) {
          counter.put(charGuess, 0);
        }
        counter.put(charGuess, counter.get(charGuess) - 1);
        if (counter.get(charGuess) >= 0) {
          cows++;
        }
      }
    }
    return "" + bulls + "A" + cows + "B";
  }
}

// Solution 2. Native solution
public class Solution {
  public String getHint2(String secret, String guess) {
    if (secret == null || guess == null || secret.length() != guess.length()) {
      return "";
    }
    int countA = 0;
    int countB = 0;
    char[] arrA = secret.toCharArray();
    char[] arrB = guess.toCharArray();
    // calculate the number of bulls
    for (int i = 0; i < arrA.length; i++) {
      if (arrA[i] == arrB[i]) {
        countA++;
        arrA[i] = ' ';
        arrB[i] = ' ';
      }
    }
    // calculate the number of cows
    for (int i = 0; i < arrA.length; i++) {
      for (int j = 0; j < arrB.length; j++) {
        if (arrA[i] == ' ' || arrB[j] == ' ') {
          continue;
        } else if (arrA[i] == arrB[j]) {
          countB++;
          arrA[i] = ' ';
          arrB[j] = ' ';
        }
      }
    }
    return "" + countA + "A" + countB + "B";
  }
}
