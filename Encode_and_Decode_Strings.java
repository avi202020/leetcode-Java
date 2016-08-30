public class Codec {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    if (strs == null) {
      return null;
    }
    StringBuilder buffer = new StringBuilder();
    for (String str : strs) {
      buffer.append(str.length());
      buffer.append(":");
      buffer.append(str);
    }
    return buffer.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    List<String> ret = new ArrayList<String> ();
    int nextStart = 0;
    while (nextStart < s.length()) {
      int splitIndex = s.indexOf(":", nextStart);
      int len = Integer.valueOf(s.substring(nextStart, splitIndex));
      String item = s.substring(splitIndex + 1, splitIndex + 1 + len);
      ret.add(item);
      nextStart = splitIndex + 1 + len;
    }
    return ret;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
