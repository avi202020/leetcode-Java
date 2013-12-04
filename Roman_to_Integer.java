public class Solution {
	public int romanToInt(String s) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
		int ans = 0;
		int i = 0;
		for( i = 0; i < s.length() - 1; ++i ) {
			if( map.get(s.charAt(i)) < map.get(s.charAt(i+1)) )
				ans = ans - map.get(s.charAt(i));
			else
				ans = ans + map.get(s.charAt(i));
		}
		ans = ans + map.get(s.charAt(i));
		return ans;
	}
}
