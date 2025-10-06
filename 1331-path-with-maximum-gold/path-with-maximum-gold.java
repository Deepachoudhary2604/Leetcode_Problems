class Solution {
    int max=0;
    public int getMaximumGold(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    solve(grid,i,j,0);
                }
            }
        }
        
        return max;
    }
    public void solve(int[][] grid,int sr,int sc,int sum){
        if(sr<0 || sc<0 || sr>grid.length-1 || sc>grid[0].length-1 || grid[sr][sc]==0){
            return;
        }
        sum+=grid[sr][sc];
        max=Math.max(max,sum);
        int temp=grid[sr][sc];
        grid[sr][sc]=0;
        solve(grid,sr+1,sc,sum);
        solve(grid,sr-1,sc,sum);
        solve(grid,sr,sc+1,sum);
        solve(grid,sr,sc-1,sum);
        grid[sr][sc]=temp;
    }
}