//***********************************************************
//                   1. naive solution
//***********************************************************

public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		strnode[] arr = new strnode[strs.length];
		for( int i = 0; i < strs.length; ++i )
		{
			StringBuffer sb = new StringBuffer( strs[i] );
			sortString( sb, 0, sb.length() - 1 );
			strnode tmpnode = new strnode();
			tmpnode.str = strs[i];
			tmpnode.sorted = sb.toString();
			arr[i] = tmpnode;
		}
		sortStrings( arr, 0, strs.length - 1 );
		ArrayList<String> ans = new ArrayList<String>();
		int cnt = 1;
		for( int i = 1; i < arr.length; ++i )
		{
			if( arr[i].sorted.equals(arr[i-1].sorted) )
			{
				if( cnt == 1 )
					ans.add( arr[i-1].str );
				ans.add( arr[i].str );
				cnt++;
			}
			else if( !arr[i].sorted.equals(arr[i-1].sorted) )
				cnt = 1;
		}
		return ans;
	}
	public void sortStrings( strnode[] strs, int lo, int hi )
	{
		if( lo >= hi ) return;
		String p = strs[lo].sorted;
		int left = lo;
		int right = hi + 1;
		while( true )
		{
			do{left++;}while( left < right && strs[left].sorted.compareTo(p) < 0 );
			do{right--;}while( left < right && strs[right].sorted.compareTo(p) > 0 );
			if( left > right ) break;
			strnode tmp = strs[left];
			strs[left] = strs[right];
			strs[right] = tmp;
		}
		strnode tmp = strs[lo];
		strs[lo] = strs[right];
		strs[right] = tmp;
		sortStrings( strs, lo, right - 1 );
		sortStrings( strs, right + 1, hi );
	}
	public void sortString( StringBuffer sb, int lo, int hi )
	{
		if( lo >= hi ) return;
		char p = sb.charAt(lo);
		int left = lo;
		int right = hi + 1;
		while( true )
		{
			do{left++;}while( left < right && sb.charAt(left) < p );
			do{right--;}while( left < right && sb.charAt(right) > p );
			if( left > right ) break;
			char tmp = sb.charAt(left);
			sb.setCharAt(left, sb.charAt(right));
			sb.setCharAt(right, tmp);
		}
		char tmp = sb.charAt(lo);
		sb.setCharAt(lo, sb.charAt(right));
		sb.setCharAt(right, tmp);
		sortString( sb, lo, right - 1 );
		sortString( sb, right + 1, hi );
	}

	class strnode {
		public String str;
		public String sorted;
	}
}
