public class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> res = new ArrayList<Integer>();
    if (nums == null || nums.length <= 0) {
      return res;
    }
    Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; ++i) {
      if (!counter.containsKey(nums[i])) {
        counter.put(nums[i], 1);
      } else {
        counter.put(nums[i], counter.get(nums[i]) + 1);
      }
    }
    PriorityQueue<HeapNode> heap = new PriorityQueue<HeapNode>(new Comparator<HeapNode>() {
      public int compare(HeapNode o1, HeapNode o2) {
        if (o1.freq < o2.freq) {
          return -1;
        } else if (o1.freq > o2.freq) {
          return 1;
        }
        return 0;
      }
    });
    for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
      HeapNode node = new HeapNode(entry.getKey(), entry.getValue());
      heap.offer(node);
      if (heap.size() > k) {
        heap.poll();
      }
    }
    while (!heap.isEmpty()) {
      res.add(heap.poll().word);
    }
    return res;
  }
}

class HeapNode {
  int word;
  int freq;
  
  HeapNode(int word, int freq) {
    this.word = word;
    this.freq = freq;
  }
}
