class Solution {
    int p=0;
    public int islandPerimeter(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    return p;
                }
            }
        }
        return 0;
    }
    public void dfs(int[][] grid,int sr,int sc){
        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc]==0){
            p++;
            return;
        }
        if(grid[sr][sc]==-1){
            return;
        }
        grid[sr][sc]=-1;
        dfs(grid,sr+1,sc);
        dfs(grid,sr-1,sc);
        dfs(grid,sr,sc-1);
        dfs(grid,sr,sc+1);
    }
}