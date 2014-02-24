public class Solution {
    public int search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target)
                return mid;
            // determine the layout of this array. case 1.
            else if (A[left] <= A[mid]) {
                // make sure the target is in the interval [left, mid]
                if (target >= A[left] && target <= A[mid])
                    right = mid - 1;
                // if not, the target is in the other interval (mid, right]
                else
                    left = mid + 1;
            }
            // determine the layout of this array. case 2.
            else if (A[left] >= A[mid]) {
                // make sure the target is in the interval [mid, right]
                if (A[mid] <= target && target <= A[right])
                    left = mid + 1;
                // if not, the target is in the other interval [left, mid)
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
