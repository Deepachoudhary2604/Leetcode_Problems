class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j);
                    max=Math.max(max,area);
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid,int sr,int sc){
        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc]!=1){
            return 0;
        }
        grid[sr][sc]=-1;
        int area=1;
        area+=dfs(grid,sr+1,sc);
        area+=dfs(grid,sr-1,sc);
        area+=dfs(grid,sr,sc-1);
        area+=dfs(grid,sr,sc+1);
        return area;
    }
}