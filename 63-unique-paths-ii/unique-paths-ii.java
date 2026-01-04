class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, m, n,arr);
    }

    public int solve(int i, int j, int m, int n,int[][] arr) {
        if (i >= m || j >= n || arr[i][j]==1) return 0;
        if (i == m - 1 && j == n - 1) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int down = solve(i + 1, j, m, n,arr);
        int right = solve(i, j + 1, m, n,arr);

        return dp[i][j] = down + right;
    }
    
}