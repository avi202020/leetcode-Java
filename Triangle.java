public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if( triangle.size() == 0 ) return 0;
        if( triangle.size() == 1 ) return triangle.get(0).get(0);
        int max = Integer.MAX_VALUE;
        for( int i = 1; i < triangle.size(); ++i )
        {
            for( int j = 0; j <= i; ++j )
            {
                int now = triangle.get(i).get(j);
                if( j == 0 ){
                    int pre = triangle.get(i-1).get(0);
                    triangle.get(i).set(j, pre + now );
                }else if( j == i ){
                    int pre = triangle.get(i-1).get(i-1);
                    triangle.get(i).set(j, pre + now );
                }else{
                    int pre1 = triangle.get(i-1).get(j-1);
                    int pre2 = triangle.get(i-1).get(j);
                    int minpre = pre1 < pre2 ? pre1 : pre2;
                    triangle.get(i).set( j, now + minpre );
                }
            }
        }
        int index = triangle.size() -1;  
        for( int i = 0; i < triangle.size(); ++i )
            if( max > triangle.get(index).get(i) )
                max = triangle.get(index).get(i);
        return max;
    }
}
