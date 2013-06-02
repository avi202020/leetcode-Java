public class Solution {
	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = num.length;
		int i = len - 1;
		while( i >= 1 && num[i] <= num[i-1] )
			i--;
		if( i == 0 )
		{
			int left = 0;
			int right = len - 1;
			while( left <= right )
			{
				int tmp = num[left];
				num[left] = num[right];
				num[right] = tmp;
				left++;
				right--;
			}
			return;
		}
		int j = len;
		while( num[j-1] <= num[i-1] )
			j--;
		int tmp = num[j-1];
		num[j-1] = num[i-1];
		num[i-1] = tmp;
		i++;
		j = len;
		while (i < j) {
			tmp = num[i - 1];
			num[i - 1] = num[j - 1];
			num[j - 1] = tmp;
			i++;
			j--;
		}
	}
}
