public class Solution {
	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( n == 1 ) return "1";
		StringBuffer sb = new StringBuffer();
		sb.append("1");
		char pre;
		int num;
		for( int test = 2; test <= n; ++test )
		{
			StringBuffer tmp = new StringBuffer();
			pre = sb.charAt(0);
			num = 1;
			for( int i = 1; i < sb.length(); ++i )
			{
				if( sb.charAt(i) == pre )
					num++;
				else
				{
					tmp.append((char)(num+'0'));
					tmp.append( pre );
					num = 1;
					pre = sb.charAt(i);
				}
			}
			tmp.append((char)(num+'0'));
			tmp.append(pre);
			sb = tmp;
		}
		return sb.toString();
	}
}
