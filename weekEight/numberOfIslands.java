class Solution {
    int m, n;
    int[] parent;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        //makeSet
        parent = new int[m*n];
        for (int i = 0; i < m*n; i++) {
            parent[i] = i;
        }
        
        //go through the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                for (int[] d: directions) {
                    int newR = i + d[0];
                    int newC = j + d[1];
                    if (newR >= 0 && newR < m && newC >= 0 && newC < n
                       && grid[newR][newC] == '1') {
                        union(getIndex(newR, newC), getIndex(i, j));
                    }
                }
            }
        }

        //number of islands = number of representitives with a value of '1'
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = getIndex(i,j);
                if (parent[index] == index && grid[i][j] == '1') {
                    ret++;
                }
            }
        }
        return ret;
    }
    
    private int getIndex(int r, int c) {
        return r * n + c;
    }
    
    private int find(int num) {
        if (parent[num] == num) return num;
        parent[num] = find(parent[num]);
        return parent[num];
    }
    
    private void union(int n1, int n2) {
        int pa1 = find(n1);
        int pa2 = find(n2);
        if (pa1 != pa2) {
            parent[pa1] = pa2;
        }
    }
    //Time: ~O(m*n)
    //Space: O(m*n)
}
