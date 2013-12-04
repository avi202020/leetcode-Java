public class Solution {
	public String intToRoman(int num) {
		if( num <= 0 ) return "";
		//IVXLCDM
		String str = "IVXLCDM";
		char[] roman = new char[str.length()];
		for( int i = 0; i < str.length(); ++i )
			roman[i] = str.charAt(i);
		int index = 0;
		StringBuilder ans = new StringBuilder();
		while( num > 0 ) {
			int curdigit = num % 10;
			StringBuilder digit = new StringBuilder();
			num = num / 10;
			if( curdigit == 9 ){
				digit.append(roman[index]);
				digit.append(roman[index+2]);
			}
			else if( curdigit == 4 ){
				digit.append(roman[index]);
				digit.append(roman[index+1]);
			}
			else {
				if( curdigit >= 5 ) {
					digit.append( roman[index+1] );
					curdigit = curdigit - 5;
				}
				for( int i = 1; i <= curdigit; ++i )
					digit.append( roman[index] );
			}
			ans.insert(0, digit.toString());
			index = index + 2;
		}
		return ans.toString();
	}
}
