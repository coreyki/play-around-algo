class Solution {
    char[][] board;
    int rows, cols;
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        //run DFS for all 'O's on the border and mark them as unflippable
        //then go through the board to flip the rest of 'O's
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            if (this.board[0][i] == 'O') {
                dfs(0, i);
            } 
            if (this.board[rows-1][i] == 'O') {
                dfs(rows-1, i);
            }
        }       
        for (int i = 0; i < rows; i++) {
            if (this.board[i][0] == 'O') {
                dfs(i, 0);
            } 
            if (this.board[i][cols-1] == 'O') {
                dfs(i, cols-1);
            }
        }
        switchChar('O', 'X');
        switchChar('U', 'O');
    }
    
    private void switchChar(char from, char to) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.board[i][j] == from) {
                    this.board[i][j] = to;
                }
            }
        } 
    }
    
    private void dfs(int r, int c) {
        //'OO' marks unflippable
        board[r][c] = 'U';
        for (int[] d: directions) {
            int newR = r + d[0];
            int newC = c + d[1];
            if (newR >= 0 && newR < rows
               && newC >= 0 && newC < cols
               && board[newR][newC] == 'O') {
                dfs(newR, newC);
            }
        }
    }
    //Time: O(n)
    //Space: O(n)
}
