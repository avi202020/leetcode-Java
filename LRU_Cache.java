import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	private LinkedHashMap<Integer, Integer> cache = null;
	int capacity;

	public LRUCache(int capacity) {
		cache = new LinkedHashMap<Integer, Integer>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		boolean found = cache.containsKey(key);
		if (found == true) {
			int value = cache.get(key);
			cache.remove(key);
			cache.put(key, value);
			return value;
		}
		return -1;
	}

	public void set(int key, int value) {
		boolean found = cache.containsKey(key);
		if (found == true) {
			cache.remove(key);
			cache.put(key, value);
		} else if (found == false) {
			if (cache.size() < this.capacity) {
				cache.put(key, value);
			} else if (cache.size() == this.capacity) {
				Iterator it = (Iterator) cache.entrySet().iterator();
				Map.Entry pairs = (Map.Entry) it.next();
				cache.remove(pairs.getKey());
				cache.put(key, value);
			}
		}
	}
}
