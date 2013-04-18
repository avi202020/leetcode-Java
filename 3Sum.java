public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		QuickSort( num, 0, num.length - 1 );
		int i = 0;
		while( i <= len - 3 )
		{
			if( num[i] > 0 ) break;
			int left = i + 1;
			int right = len - 1;
			int tmp_target = 0 - num[i];
			while( left < right )
			{
				if( num[left] + num[right] < tmp_target )
					do{left++;}while( left < right && num[left] == num[left-1] );
				else if( num[left] + num[right] > tmp_target )
					do{right--;}while( left < right && num[right] == num[right+1] );
				else if( num[left] + num[right] == tmp_target )
				{
					ArrayList<Integer> line = new ArrayList<Integer>();
					line.add( num[i] );
					line.add( num[left] );
					line.add( num[right] );
					ans.add( line );
					do{left++;}while( left < right && num[left] == num[left-1] );
					do{right--;}while( left < right && num[right] == num[right+1] );
				}
			}
			do{i++;}while( i <= len - 3 && num[i] == num[i-1] );
		}
		return ans;
	}
	public void QuickSort( int[] arr, int lo, int up )
	{
		if( lo >= up ) return;
		int p = arr[lo];
		int left = lo;
		int right = up + 1;
		while( true )
		{
			do{left++;}while( left < right && arr[left] < p );
			do{right--;}while( left < right && arr[right] > p );
			if( left > right ) break;
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
		}
		int tmp = arr[lo];
		arr[lo] = arr[right];
		arr[right] = tmp;
		QuickSort( arr, lo, right - 1 );
		QuickSort( arr, right + 1, up );
	}
}
