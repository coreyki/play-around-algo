class Solution {
    int[] parent;
    int n;
    
    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        int[] ret = new int[2];
        for (int[] edge: edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (find(n1) != find(n2)) {
                union(n1, n2);
            } else {
                return new int[]{n1, n2};
            }
        }
        return new int[]{};
    }
    
    private int find(int n1) {
        if (parent[n1] == n1) {
            return n1;
        }
        parent[n1] = find(parent[n1]);
        return parent[n1];
    }
    
    private void union(int n1, int n2) {
        parent[find(n1)] = find(n2);
    }
    //Time: ~O(n)
    //Space: O(n)
}
