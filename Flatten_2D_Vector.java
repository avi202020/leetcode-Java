ipublic class Vector2D implements Iterator<Integer> {

  List<List<Integer>> vec2d;
  int i;
  int j;

  public Vector2D(List<List<Integer>> vec2d) {
    this.vec2d = vec2d;
    i = 0;
    j = 0;
    while (i < vec2d.size() && j >= vec2d.get(i).size()) {
      i++;
    }
  }

  @Override
  public Integer next() {
    int res = vec2d.get(i).get(j);
    j++;
    while (i < vec2d.size() && j >= vec2d.get(i).size()) {
      i++;
      j = 0;
    }
    return res;
  }

  @Override
  public boolean hasNext() {
    return i < vec2d.size();
  }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
