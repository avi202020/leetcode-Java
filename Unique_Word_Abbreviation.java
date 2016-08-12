public class ValidWordAbbr {

  private Map<String, Set<String>> unique;

  public ValidWordAbbr(String[] dictionary) {
    unique = new HashMap<String, Set<String>>();
    for (int i = 0; i < dictionary.length; ++i) {
      String abbr = getAbbr(dictionary[i]);
      if (!unique.containsKey(abbr)) {
        unique.put(abbr, new HashSet<String>());
      }
      unique.get(abbr).add(dictionary[i]);
    }
  }

  private String getAbbr(String s) {
    if (s.length() <= 2) {
      return s;
    }
    char first = s.charAt(0);
    char last = s.charAt(s.length() - 1);
    int len = s.length() - 2;
    return "" + first + len + last;
  }

  public boolean isUnique(String word) {
    String key = getAbbr(word);
    if (!unique.containsKey(key)) {
      return true;
    } else if (unique.get(key).contains(word) && unique.get(key).size() == 1) {
      return true;
    }
    return false;
  }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
