class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[n+1];
        int[] rank=new int[n+1];
        
        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(find(u,parent)==find(v,parent)){
                return edge;
            }
            union(u,v,parent,rank);
        }
        return new int[0];
    }

    public void union(int u,int v,int[] parent,int[] rank){
        int xp=parent[u];
        int yp=parent[v];
        if(xp==yp){
            return;
        }
        if(rank[xp]>rank[yp]){
            parent[yp]=xp;
        }
        else if(rank[yp]>rank[xp]){
            parent[xp]=yp;
        }
        else{
            parent[xp]=yp;
            rank[yp]++;
        }

    }
    public int find(int x,int[] parent){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x],parent);
    }
}