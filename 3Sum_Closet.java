import java.util.*;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int mindiff = Integer.MAX_VALUE;
		int sum = 0;
		int len = num.length;
		QuickSort( num, 0, num.length - 1 );
		for( int i = 0; i <= len - 3; ++i )
		{
			int left = i + 1;
			int right = len - 1;
			int tmp_target = target - num[i];
			int tmp_diff;
			while( left < right )
			{
				tmp_diff = Math.abs( tmp_target - num[left] - num[right] );
				if( tmp_diff < mindiff )
				{
					mindiff = tmp_diff;
					sum = num[i] + num[left] + num[right];
				}
				if( num[left] + num[right] < tmp_target )
					left++;
				else if( num[left] + num[right] > tmp_target )
					right--;
				else if( num[left] + num[right] == tmp_target )
					return target;
			}
		}
		return sum;
	}
	public void QuickSort(int[] num, int low, int hi)
	{
		if( low >= hi ) return;
		int left = low;
		int right = hi + 1;
		int p = num[low];
		while(true)
		{
			do left++; while( left < right && num[left] < p);
			do right--; while( left < right && num[right] > p);
			if( left > right ) break;
			int tmp = num[left];
			num[left] = num[right];
			num[right] = tmp;
		}
		int tmp = num[low];
		num[low] = num[right];
		num[right] = tmp;
		QuickSort( num, low, right - 1 );
		QuickSort( num, right + 1, hi );
	}
	public static void main(String[] argv)
	{
		Solution so = new Solution();
		int[] arr = new int[4];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 0;
		int ans = so.threeSumClosest(arr, -100);
			System.out.println(ans);
	}
}
