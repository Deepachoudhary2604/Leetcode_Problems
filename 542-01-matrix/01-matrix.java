class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //We need to find the nearest 0 from 1
        int n=mat.length;
        int m=mat[0].length;
        int[][] adj=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(adj[i],-1);
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    adj[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] val=q.poll();
            int i=val[0];
            int j=val[1];
            for(int[] dir:dirs){
                int nr=i+dir[0];
                int nc=j+dir[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && adj[nr][nc]==-1){
                    adj[nr][nc]=1+adj[i][j];
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return adj;
    }
}