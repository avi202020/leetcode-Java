public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle.size() == 0) {
      return 0;
    }
    if (triangle.size() == 1) {
      return triangle.get(0).get(0);
    }
    for (int i = 1; i < triangle.size(); ++i) {
      for (int j = 0; j <= i; ++j) {
        int cur = triangle.get(i).get(j);
        if (j == 0) {
          int pre = triangle.get(i-1).get(j);
          triangle.get(i).set(j, cur + pre);
        } else if (j == i) {
          int pre = triangle.get(i-1).get(j-1);
          triangle.get(i).set(j, cur + pre);
        } else {
          int pre1 = triangle.get(i-1).get(j-1);
          int pre2 = triangle.get(i-1).get(j);
          triangle.get(i).set(j, cur + Math.min(pre1, pre2));
        }
      }
    }
    int index = triangle.size() - 1;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < triangle.size(); ++i )
      if (triangle.get(index).get(i) < min)
        min = triangle.get(index).get(i);
    return min;
  }
}
