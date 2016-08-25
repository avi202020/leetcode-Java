// Solution 1. fenwick tree solution
public class NumArray {

  int[] array;
  int[] helper;

  public NumArray(int[] nums) {
    array = new int[nums.length];
    helper = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      array[i] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      add(i + 1, nums[i]);
    }
  }
  private void add(int pos, int value) {
    while (pos < helper.length) {
      helper[pos] += value;
      pos += lowBit(pos);
    }
  }

  private int lowBit(int pos) {
    return pos & (-pos);
  }
  private int sum(int pos) {
    int rt = 0;
    while (pos > 0) {
      rt += helper[pos];
      pos -= lowBit(pos);
    }
    return rt;
  }
  void update(int i, int val) {
    int delta = val - array[i];
    array[i] = val;
    add(i + 1, delta);
  }
  public int sumRange(int i, int j) {
    return sum(j + 1) - sum(i);
  }
}


// Solution 2. segment tree solution, but got TLE
public class NumArray {

  SegmentTreeNode root = null;

  public NumArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    this.root = buildTree(nums, 0, nums.length-1);
  }

  public void update(int i, int val) {
    updateHelper(root, i, val);
  }

  private void updateHelper(SegmentTreeNode root, int i, int val) {
    if (root == null) {
      return;
    }
    int mid = root.start + (root.end - root.start) / 2;
    if (i <= mid) {
      updateHelper(root.left, i, val);
    } else {
      updateHelper(root.right, i, val);
    }
    if (root.start == root.end && root.start == i) {
      root.sum = val;
      return;
    }
    root.sum = root.left.sum + root.right.sum;
  }

  public int sumRange(int i, int j) {
    return sumRangeHelper(root, i, j);
  }

  private int sumRangeHelper(SegmentTreeNode root, int left, int right) {
    if (root == null || right < root.start || left > root.end) {
      return 0;
    }
    if (left <= root.start && right >= root.end) {
      return root.sum;
    }
    int mid = root.start + (root.end - root.start) / 2;
    int result = sumRangeHelper(root.left, left, Math.min(mid, right)) +
        sumRangeHelper(root.right, Math.max(mid + 1, left), right);
    return result;
  }

  private SegmentTreeNode buildTree(int[] nums, int left, int right) {
    if (nums == null || nums.length == 0 || left > right) {
      return null;
    }
    if (left == right) {
      return new SegmentTreeNode(left, right, nums[left]);
    }
    SegmentTreeNode root = new SegmentTreeNode(left, right);
    int mid = left + (right - left) / 2;
    root.left = buildTree(nums, left, mid);
    root.right = buildTree(nums, mid + 1, right);
    root.sum = root.left.sum + root.right.sum;
    return root;
  }

  public static void main(String[] argc) {
    NumArray numArray = new NumArray(new int[]{1,3,5});
    System.out.println(numArray.sumRange(0,2));
    //System.out.println(numArray.sumRange(2,5));
    numArray.update(1,2);
    System.out.println(numArray.sumRange(0,2));
  }
}

class SegmentTreeNode {
  int start;
  int end;
  int sum;
  SegmentTreeNode left;
  SegmentTreeNode right;

  public SegmentTreeNode(int left, int right, int sum) {
    this.start = left;
    this.end = right;
    this.sum = sum;
  }

  public SegmentTreeNode(int left, int right) {
    this.start = left;
    this.end = right;
    this.sum = 0;
  }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
