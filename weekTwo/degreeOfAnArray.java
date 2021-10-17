class Solution {
    public int findShortestSubArray(int[] nums) {
        //record the index where the num first seen
        HashMap<Integer, Integer> left = new HashMap<>();
        //record the index where the num last seen
        HashMap<Integer, Integer> right = new HashMap<>();
        //keep track of num's frequency
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!left.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            int curCount = count.getOrDefault(nums[i], 0) + 1;
            maxCount = Math.max(maxCount, curCount);
            count.put(nums[i], curCount);
        }
        
        int ret = nums.length;
        for (int num: count.keySet()) {
            if (count.get(num) == maxCount) {
                ret = Math.min(ret, right.get(num) - left.get(num) + 1);
            }
        }
        return ret;
    }
    //Time: O(N)
    //Space: O(N)
}
