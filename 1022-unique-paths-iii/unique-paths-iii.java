class Solution {
    int ans=0;
    int non_obstacle=0;
    public int uniquePathsIII(int[][] grid) {
        int st=0;
        int end=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    st=i;
                    end=j;
                }
                if(grid[i][j]==0 || grid[i][j]==1){
                    non_obstacle++;
                }
            }
        }
        solve(grid,0,st,end);
        return ans;
    }
    public void solve(int[][] grid,int c,int x,int y){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==-1){
            return;
        }
        if(grid[x][y]==2){
            if(c==non_obstacle){
                ans++;
            }
            return;
        }
        int temp=grid[x][y];
        grid[x][y]=-1;
        solve(grid,c+1,x-1,y);
        solve(grid,c+1,x+1,y);
        solve(grid,c+1,x,y-1);
        solve(grid,c+1,x,y+1);
        grid[x][y]=temp;
    }
}