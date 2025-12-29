class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.offer(new int[] {i,j});
                }
            }
        }
        if(fresh==0){
            return 0;
        }

        int min=0;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int size=q.size();
            boolean rotten=false;
            for(int i=0;i<size;i++){
                int[] val=q.poll();
                int r=val[0];
                int c=val[1];
                for(int[] dir:dirs){
                    int nr=r+dir[0];
                    int nc=c+dir[1];
                    if(nr>=0 && nc>=0 && nr<row && nc<col && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.offer(new int[]{nr,nc});
                        fresh--;
                        rotten=true;
                    }
                }
                
            }
            if(rotten){
                    min++;
            }
        }
        if(fresh==0){
            return min;
        }
        return -1;
    }

}