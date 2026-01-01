class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int min=0;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            boolean rotten=false;
            int size=q.size();
            while(size>0){
                int[] val=q.poll();
                int x=val[0];
                int y=val[1];
                for(int[] dir:dirs){
                    int nx=x+dir[0];
                    int ny=y+dir[1];
                    if(nx>=0 && ny>=0 && nx<row && ny<col && grid[nx][ny]==1){
                        q.add(new int[]{nx,ny});
                        fresh--;
                        grid[nx][ny]=2;
                        rotten=true;
                    }
                }
                size--;
            }
            if(rotten){
                min++;
            }
        }
        if(fresh!=0){
            return -1;
        }
        return min;
    }
}