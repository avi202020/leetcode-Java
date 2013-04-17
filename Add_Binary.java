public class Solution {
	public String addBinary(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		StringBuffer sb = new StringBuffer();
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		while( i >= 0 || j >= 0 || carry != 0 )
		{
			int sum = 0;
			int value_a = ( i >= 0 ? a.charAt(i) - '0' : 0 );
			int value_b = ( j >= 0 ? b.charAt(j) - '0' : 0 );
			sum += value_a + value_b + carry;
			carry = sum / 2;
			sum = sum % 2;
			sb.insert( 0, (char)(sum + '0') );
			i = (i >= 0 ? --i : i);
			j = (j >= 0 ? --j : j);
		}
		return sb.toString();
	}
}
