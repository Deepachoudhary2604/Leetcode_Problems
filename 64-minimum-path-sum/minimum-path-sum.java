class Solution {
    int[][] dp;
    public int solve(int[][] grid,int sr,int sc,int er,int ec){
        if(sr>=er || sc>=ec){
            return Integer.MAX_VALUE;
        }
        
        if (sr == er - 1 && sc == ec - 1) {
            return grid[sr][sc];
        }
        if(dp[sr][sc]!=-1){
            return dp[sr][sc];
        }
        
        int bottom=solve(grid,sr+1,sc,er,ec);
        int right=solve(grid,sr,sc+1,er,ec);
        return dp[sr][sc]=grid[sr][sc]+Math.min(bottom,right);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n+1][m+1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(grid, 0, 0, n, m);
    }
}