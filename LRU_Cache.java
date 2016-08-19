public class LRUCache {

  private LinkedHashMap<Integer, Integer> cache;
  private int capacity;
  public LRUCache(int capacity) {
    this.cache = new LinkedHashMap<Integer, Integer>(capacity);
    this.capacity = capacity;
  }

  public int get(int key) {
    int res = -1;
    if (cache.containsKey(key)) {
      res = cache.get(key);
      cache.remove(key);
      cache.put(key, res);
    }
    return res;
  }

  public void set(int key, int value) {
    if (cache.containsKey(key)) {
      cache.remove(key);
    } else if (cache.size() >= this.capacity) {
      Iterator<Map.Entry<Integer, Integer>> it = cache.entrySet().iterator();
      Map.Entry<Integer, Integer> pairs = it.next();
      cache.remove(pairs.getKey());
    }
    cache.put(key, value);
  }
}
