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
