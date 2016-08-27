public class MedianFinder {

  PriorityQueue<Integer> heap1;
  PriorityQueue<Integer> heap2;

  public MedianFinder() {
    heap1 = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    heap2 = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
  }

  // Adds a number into the data structure.
  public void addNum(int num) {
    heap1.offer(num);
    heap2.offer(heap1.poll());
    if (heap1.size() < heap2.size()) {
      heap1.offer(heap2.poll());
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (heap1.size() == heap2.size()) {
      int num1 = heap1.peek();
      int num2 = heap2.peek();
      return ((double)num1 + (double)num2) / 2.0;
    } else {
      return heap1.peek();
    }
  }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
