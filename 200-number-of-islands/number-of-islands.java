class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,int sr,int sc){
        if(sc<0 || sr<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc]!='1'){
            return;
        }
        grid[sr][sc]='%';
        dfs(grid,sr+1,sc);
        dfs(grid,sr-1,sc);
        dfs(grid,sr,sc-1);
        dfs(grid,sr,sc+1);
    }
}