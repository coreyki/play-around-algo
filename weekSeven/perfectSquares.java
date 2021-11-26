class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int maxSqr = (int) Math.sqrt(n) +1;
        int[] squareNum = new int[maxSqr + 1];
        for (int i = 0; i <= maxSqr; i++) {
            squareNum[i] = i * i;
        }
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxSqr; j++) {
                if (i < squareNum[j]) {
                    break;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - squareNum[j]] + 1);
                }
            }
        }
        return dp[n];
        //Time: O(n*sqr(n))
        //Space: O(n)
    }
}
