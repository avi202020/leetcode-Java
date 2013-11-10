public class Solution {
    boolean success;
    public boolean wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        success = false;
		
		// optimization: 
		// if there is a char of s that doesn't exist in dict, return false
        HashSet<Character> present = new HashSet<Character>();
        Iterator<String> it = dict.iterator();
        while(it.hasNext()) {
            String str = it.next();
            for( int i = 0; i < str.length(); ++i )
                present.add( str.charAt(i) );
        }
        for( int i = 0; i < s.length(); ++i ) {
            if( !present.contains(s.charAt(i)) )
                return false;
        }
        dfs( s, dict, 0 );
        return success;
    }
    public boolean dfs( String s, Set<String> dict, int depth ) {
        if( depth >= s.length() ) {
            success = true;
            return true;
        }
        if( success == true )
            return true;
        for( int i = depth + 1; i <= s.length(); ++i ) {
            if( dict.contains( s.substring(depth,i) ) ) {
                boolean found = dfs( s, dict, i );
                if( found == true )
                    return true;
            }
        }
        return false;
    }
}
