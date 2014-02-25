public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int count = 1 << n;
        for( int i = 0; i < count; ++i )
            ans.add( i ^ (i >> 1 ));
        return ans;
    }
}
