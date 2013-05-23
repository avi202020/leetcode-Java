public class Solution {
	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = digits.length;
		int carry = 1;
		for( int i = len - 1; i >= 0; --i )
		{
			int sum = digits[i] + carry;
			carry = sum / 10;
			digits[i] = sum % 10;
		}
		if( carry != 0 )
		{
			int[] tmp = new int[len+1];
			for( int i = len; i >= 1; --i )
				tmp[i] = digits[i-1];
			tmp[0] = 1;
			digits = tmp;
		}
		return digits;
	}
}
