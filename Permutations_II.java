public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		for( int i = 0; i < num.length; ++i )
			buffer.add(num[i]);
		ans.add(buffer);
		while( true ) {
			int i = num.length - 1;
			while( i > 0 && num[i] <= num[i-1] ) {
				i--;
			}
			if( i == 0 )
				break;
			int pos = i - 1;
			int j = num.length - 1;
			while( j > 0 && num[j] <= num[pos] )
				j--;
			int tmp = num[pos];
			num[pos] = num[j];
			num[j] = tmp;
			j = num.length - 1;
			while( i < j ) {
				tmp = num[i];
				num[i] = num[j];
				num[j] = tmp;
				i++;
				j--;
			}
			buffer = new ArrayList<Integer>();
			for( i = 0; i < num.length; ++i )
				buffer.add(num[i]);
			ans.add(buffer);
		}
		return ans;
	}
}
