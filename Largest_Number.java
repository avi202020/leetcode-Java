public class Solution {
  public String largestNumber(int[] nums) {
    List<Integer> numbers = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; ++i) {
      numbers.add(nums[i]);
    }
    Collections.sort(numbers, new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2) {
        String tmp1 = "" + o1 + o2;
        String tmp2 = "" + o2 + o1;
        return tmp2.compareTo(tmp1);
      }
    });
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < numbers.size(); ++i) {
      if (numbers.get(i) == 0 && res.length() == 0) {
        continue;
      }
      res.append(numbers.get(i));
    }
    if (res.length() == 0) {
      return "0";
    }
    return res.toString();
  }
}
