class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(ans[i],-1);
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] val=q.poll();
            int x=val[0];
            int y=val[1];
            for(int[] dir:dirs){
                int nx=x+dir[0];
                int ny=y+dir[1];
                if(nx>=0 && ny>=0 && nx<m && ny<n && ans[nx][ny]==-1){
                    ans[nx][ny]=ans[x][y]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return ans;
    }
}