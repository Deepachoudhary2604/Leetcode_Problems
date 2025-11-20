class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int sr=n-1;
        int sc=m-1;
        int er=0;
        int ec=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    sr=Math.min(sr,i);
                    sc=Math.min(sc,j);
                    er=Math.max(er,i);   
                    ec=Math.max(ec,j);   
                }
                
            }
        }
        int a=er-sr+1;
        int b=ec-sc+1;
        int area=a*b;
        return area;
    }
}