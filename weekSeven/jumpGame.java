class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        
        for (int i = n-2; i >= 0; i--) {
            int maxJump = Math.min(i + nums[i], n-1);
            for (int j = i + 1; j <= maxJump; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
        //Time: O(n^2)
        //Space: O(n)
    }
}
