class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i < dp.length; i++) {
            dp[i] = (i&1) + dp[i >> 1];

        }
        return dp;
    }
}
