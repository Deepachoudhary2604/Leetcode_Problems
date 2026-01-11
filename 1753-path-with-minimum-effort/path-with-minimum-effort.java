class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int[] val=pq.poll();
            int effort=val[0];
            int r=val[1];
            int c=val[2];
            if(r==m-1 && c==n-1){
                return effort;
            }
            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int newEffort=Math.max(effort,Math.abs(heights[nr][nc]-heights[r][c]));
                    if(newEffort<dist[nr][nc]){
                        dist[nr][nc]=newEffort;
                        pq.add(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}