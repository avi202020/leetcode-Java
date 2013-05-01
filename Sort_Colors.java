// naive solution
public class Solution {
	public void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap< Integer, Integer > map = new HashMap< Integer, Integer >();
		for( int i = 0; i < A.length; ++i )
		{
			if( map.containsKey(A[i]) )
				map.put( A[i], map.get(A[i]) + 1 );
			else
				map.put( A[i], 1 );
		}
		int index = 0;
		for( int i = 0; i <= 2; ++i )
		{
			if( map.containsKey(i) )
				for( int j = 0; j < map.get(i); ++j )
					A[index++] = i;
		}
	}
}

// one-pass solution
public class Solution {
    public void sortColors(int[] A) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		int left = 0;
		int right = A.length - 1;
		int cur = 0;
		while( cur <= right )
		{
			if( A[cur] == 0 )
			{
				int tmp = A[cur];
				A[cur] = A[left];
				A[left] = tmp;
				left++;
                cur++;
			}
			else if( A[cur] == 2 )
			{
				int tmp = A[cur];
				A[cur] = A[right];
				A[right] = tmp;
				right--;
			}
            else if( A[cur] == 1 )
			    cur++;
		}
	}
}
