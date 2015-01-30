public class Solution {
  public int ladderLength(String start, String end, Set<String> dict) {
    if( start.equals(end) || !dict.contains(end) || (start.length() != end.length()) )
      return 0;
    if( dict == null || dict.size() == 0 )
      return 0;
    Queue<String> queue = new LinkedList<String>();
    queue.add(start);
    dict.remove(start);
    int step = 1;
    while( !queue.isEmpty() ) {
      int size = queue.size();
      for( int i = 0; i < size; ++i ) {
        String current = queue.poll();
        for( int j = 0; j < current.length(); ++j ) {
          for( char c = 'a'; c <= 'z'; ++c ) {
            if( current.charAt(j) == c )
              continue;
            String tmp = replace(current, j, c);
            if( tmp.equals(end) )
              return step + 1;
            if( dict.contains(tmp) ) {
              queue.offer(tmp);
              dict.remove(tmp);
            }
          }
        }
      }
      step++;
    }
    return 0;
  }
  public String replace(String word, int pos, char c) {
    char[] str = word.toCharArray();
    str[pos] = c;
    return new String(str);
  }
}


public class Solution {

  class QueueNode {
    public String data;
    public int step;
    public QueueNode(String str, int n) {
      data = str;
      step = n;
    }
  }

  public int ladderLength(String start, String end, HashSet<String> dict) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (start.equals(end))
      return 0;
    HashSet<String> visited = new HashSet<String>();
    visited.add(start);
    Queue<QueueNode> queue = new LinkedList<QueueNode>();
    queue.add(new QueueNode(start, 1));
    while (!queue.isEmpty()) {
      QueueNode cur = queue.poll();
      if (cur.data.equals(end))
        return cur.step;
      StringBuilder sb = null;
      for (int i = 0; i < cur.data.length(); ++i) {
        for (int j = 0; j < 26; ++j) {
          char ch = (char) ('a' + j);
          sb = new StringBuilder(cur.data);
          sb.setCharAt(i, ch);
          String candidate = sb.toString();
          if (candidate.equals(end))
            return cur.step + 1;
          if (!dict.contains(candidate))
            continue;
          if (visited.contains(sb.toString()))
            continue;
          QueueNode node = new QueueNode(candidate, cur.step + 1);
          queue.offer(node);
          visited.add(candidate);
        }
      }
    }
    return 0;
  }
}

