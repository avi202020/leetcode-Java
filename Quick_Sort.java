public class Solution {
  public void sort( int[] num ) {
    int left = 0;
    int right = num.length - 1;
    quickSort(num, left, right);
  }
  public void quickSort( int[] num, int lo, int hi ) {
    int p = num[lo];
    int left = lo;
    int right = hi + 1;
    while( true ) {
      do{left++;} while( left < right && num[left] < p );
      do{right--;}while( left < right && num[right] > p );
      if( left > right ) 
        break;
      swap( num, left, right );
    }
    swap( num, lo, right );
    quickSort( num, lo, right - 1 );
    quickSort( num, right + 1, hi );
  }
  public void swap( int[] num, int left, int right ) {
    int tmp = num[left];
    num[left] = num[right];
    num[right] = tmp;
  }
}
