class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = matrix[mid/n][mid%n];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    //Time: O(log(mn))
    //Space: O(1)
}
