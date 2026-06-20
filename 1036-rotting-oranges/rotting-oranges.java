class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
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
            while(size>0){
                int[] temp=q.poll();
                int r=temp[0];
                int c=temp[1];
                for(int[] dir:dirs){
                    int nr=r+dir[0];
                    int nc=c+dir[1];
                    if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1){
                        fresh--;
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                        rotten=true;
                    }

                }
                size--;
            }
            if(rotten){
                min++;
            }
        }
        if(fresh==0) return min;
        return -1;
    }
}