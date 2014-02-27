public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int n = A.length;
        while (i < n) {
            if( A[i] < 1 || A[i] >= n || A[i] == i + 1 ) {
                i++;
            }
            else if( A[i] != i + 1 ) {
                if( A[A[i]-1] != A[i] ) {
                    int pos = A[i] - 1;
                    int tmp = A[i];
                    A[i] = A[pos];
                    A[pos] = tmp;
                }
                else 
                    i++;
            }

        }
        for (i = 0; i < n; ++i)
            if ( A[i] != i + 1 )
                return i + 1;
        return n + 1;
    }
}
