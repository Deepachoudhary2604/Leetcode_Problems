class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        // Step 1: Build adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                
                int dist = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                
                adj.get(i).add(new int[]{j, dist});
                adj.get(j).add(new int[]{i, dist});
            }
        }
        
        // Step 2: Run Prim's
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        pq.offer(new int[]{0,0});
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        while(edgesUsed < n){
            
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            
            if(visited[node]) continue;
            
            visited[node] = true;
            totalCost += cost;
            edgesUsed++;
            
            for(int[] neighbor : adj.get(node)){
                int nextNode = neighbor[0];
                int nextCost = neighbor[1];
                
                if(!visited[nextNode]){
                    pq.offer(new int[]{nextCost, nextNode});
                }
            }
        }
        
        return totalCost;
    }
}
