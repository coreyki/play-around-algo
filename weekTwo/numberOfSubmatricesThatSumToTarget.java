class Solution {
    private int[][] sum;
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix.length == 0) return 0;
        //track prefix sum
        sum = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        
        //key: sum 
        //value: frequncy
        HashMap<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        //fix two rows and loop through each col to get all submatrix
        for (int rUp = 1; rUp <= matrix.length; rUp++) {
            for (int rDown = rUp; rDown <= matrix.length; rDown++) {
                map.clear();
                map.put(0, 1);
                for (int c = 1; c <= matrix[0].length; c++) {
                    int curSum = sum[rDown][c] - sum[rUp-1][c];
                    ret += map.getOrDefault(curSum - target, 0);
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                }
            }
        }
        return ret;
        //Time: O(R^2C) (R = num of rows. C = num of cols)
        //Space: O(RC)
    }
}
