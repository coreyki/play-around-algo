class Solution {
    int maxRect = 0;
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        //accumulate on each row and construct histogram
        //on each row, get max rectangle based on current histogram
        int[] hist = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                hist[j] = matrix[i][j] == '1' ? hist[j] + 1 : 0;
            }
            updateMaxRect(hist);
        }
        return maxRect;
    }
    
    Stack<int[]> stack;
    private void updateMaxRect(int[] hist) {
        //[0]: width
        //[1]: height
        stack = new Stack<>();
        for (int i = 0; i < hist.length; i++) {
            processStack(hist[i]);
        }
        processStack(0);
    }
    
    private void processStack(int height) {
        int accWidth = 0;
        while (!stack.isEmpty() && stack.peek()[1] >= height) {
            int[] rect = stack.pop();
            accWidth += rect[0];
            maxRect = Math.max(maxRect, accWidth * rect[1]);
        }
        stack.push(new int[]{accWidth + 1, height});
    }
}
