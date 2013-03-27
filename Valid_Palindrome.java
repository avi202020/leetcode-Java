public class Valid_Palindrome
{
	public boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = s.length();
		if ( len <= 1 ) return true;
		int left = 0;
		int right = len-1;
		s = s.toLowerCase();
		while( left <= right )
		{
			while( !Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left)) )
			{
				left++;
				if( left >= len ) return true;
			}
			while( !Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right)) )
			{
				right--;
				if( right <= 0 ) return true;
			}
			if( s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
	public static void main( String[] argv )
	{
		String s = "la2";
		Valid_Palindrome vp = new Valid_Palindrome();
		boolean ans = vp.isPalindrome(s);
		System.out.println(ans);
	}
}
