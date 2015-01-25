public class Solution {
  public String largestNumber(int[] num) {
    String strs[] = new String[num.length];
    for( int i = 0; i < strs.length; ++i )
      strs[i] = String.valueOf(num[i]);
    Arrays.sort(strs, new MyComparator() );
    StringBuilder sb = new StringBuilder();
    for( int i = 0; i < strs.length; ++i )
      sb.append(strs[i]);
    java.math.BigInteger result = new java.math.BigInteger(sb.toString());
    return result.toString();
  }
  class MyComparator implements Comparator<String> {
    public int compare(String a, String b)  {
      String str1 = a.concat(b);
      String str2 = b.concat(a);
      return str2.compareTo(str1);
    }
  }
}
