class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValidCapacity(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    
    private boolean isValidCapacity(int[] weights, int days, int capacity) {
        int sum = 0;
        int day = 1;
        for (int w: weights) {
            if (sum + w > capacity) {
                day++;
                sum = w;
            } else {
                sum += w;
            }
        }
        return day <= days;
    }
    //Time: O(nlogm), where n is num of packages and m is sum of all packages' weights
    //Space: O(1)
}
