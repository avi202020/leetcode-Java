public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (ratings.length == 0 || ratings == null)
            return 0;
        int[] cand = new int[ratings.length];
        for (int i = 0; i < cand.length; ++i)
            cand[i] = 1;
        for (int i = 1; i < cand.length; ++i)
            if (ratings[i] > ratings[i - 1])
                cand[i] = cand[i - 1] + 1;
        for (int i = cand.length - 2; i >= 0; --i)
            if (ratings[i] > ratings[i + 1] && cand[i] <= cand[i + 1])
                cand[i] = cand[i + 1] + 1;
        int ans = 0;
        for (int i = 0; i < cand.length; ++i)
            ans += cand[i];
        return ans;
    }
}
