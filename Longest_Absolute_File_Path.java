public class Solution {
  public int lengthLongestPath(String input) {
    if (input == null || input.length() == 0 || !input.contains(".")) {
      return 0;
    }
    int maxLength = 0;
    String[] lines = input.split("\n");
    Deque<String> deque = new LinkedList<String>();
    for (int i = 0; i < lines.length; ++i) {
      String s = lines[i];
      int tabs = 0;
      while (s.charAt(tabs) == '\t') {
        tabs++;
      }
      while (tabs < deque.size()) {
        deque.removeLast();
      }
      s = s.substring(tabs);
      if (s.contains(".")) {
        StringBuilder folderPath = new StringBuilder();
        for (String folder : deque) {
          folderPath.append(folder + "/");
        }
        maxLength = Math.max(maxLength, folderPath.length() + s.length());
      } else {
        deque.addLast(s);
      }
    }
    return maxLength;
  }
}
