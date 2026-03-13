class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int time=0;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            boolean rotten=false;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] val=q.poll();
                int r=val[0];
                int c=val[1];
                for(int[] dir:dirs){
                    int nr=r+dir[0];
                    int nc=c+dir[1];
                    if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1){
                        q.add(new int[]{nr,nc});
                        fresh--;
                        rotten=true;
                        grid[nr][nc]=2;
                    }
                }
            }
            if(rotten){
                time++;
            }
        }
        if(fresh!=0){
            return -1;
        }
        return time;
    }
}