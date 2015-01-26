public class Solution {
  public int strStr(String haystack, String needle) {
    if( haystack.equals(needle) || needle.equals("") )
      return 0;
    int next[] = getNext(needle);
    int len1 = haystack.length();
    int len2 = needle.length();
    int i = 0;
    int j = 0;
    int ans = -1;
    while( i < len1 && j < len2 ) {
      if( haystack.charAt(i) == needle.charAt(j) ) {
        i++;
        j++;
        if( j == len2 ) {
          ans = i - j;
          return ans;
        }
      } else if( j == 0 ) {
        i++;
      } else if( j != 0 ) {
        j = next[j-1] + 1;
      }
    }
    return ans;
  }
  public int[] getNext(String str) {
    int[] next = new int[str.length()];
    int index;
    next[0] = -1;
    for( int i = 1; i < str.length(); ++i ) {
      index = next[i-1];
      while( index >= 0 && str.charAt(i) != str.charAt(index+1) )
        index = next[index];
      if( str.charAt(i) == str.charAt(index+1) )
        next[i] = index + 1;
      else
        next[i] = -1;
    }
    return next;
  }
}


public class Solution {
    public String strStr(String haystack, String needle) {
        int needleLen = needle.length();
        int haystackLen = haystack.length();

        if (needleLen == haystackLen && needleLen == 0)
            return "";
        if (needleLen == 0)
            return haystack;

        int[] next = new int[needle.length()];
        for( int i = 0; i < next.length; ++i )
            next[i] = -1;
        getNext(needle, next);
        int i = 0;
        int j = 0;
        while( i < haystack.length() && j < needle.length() ) {
            if( haystack.charAt(i) == needle.charAt(j) ) {
                i++;
                j++;
                if( j == needle.length() ) {
                    return haystack.substring( i - needle.length() );
                }
            }
            else if( j == 0 )
                i++;
            else if( j != 0 )
                j = next[j-1] + 1;
        }
        return null;
    }

    public void getNext(String needle, int[] next) {
        int index;
        next[0] = -1;
        for( int i = 1; i < needle.length(); ++i ) {
            index = next[i-1];
            while( index >= 0 && needle.charAt(i) != needle.charAt(index+1) )
                index = next[index];
            if( needle.charAt(i) == needle.charAt(index+1) )
                next[i] = index + 1;
            else
                next[i] = -1;
        }
    }
}
