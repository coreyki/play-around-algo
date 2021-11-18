class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLen = 0, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] == maxLen) {
                ret += count[i];
            } else if (dp[i] > maxLen) {
                maxLen = dp[i];
                ret = count[i];
            }
        }
        return ret;
        //Time: O(n^2);
        //Space: O(n);
    }
}
