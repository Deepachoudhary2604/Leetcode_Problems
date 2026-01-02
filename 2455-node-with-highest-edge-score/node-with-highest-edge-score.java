class Solution {
    public int edgeScore(int[] edges) {
        long[] arr=new long[edges.length];
        for(int i=0;i<edges.length;i++){
            int src=i;
            int dest=edges[i];
            arr[dest]+=src;
        }
        long max=Long.MIN_VALUE;
        int ans=-1;
        for(int i=0;i<edges.length;i++){
            if(max<arr[i]){
                max=arr[i];
                ans=i;
            }
        }
        return ans;
    }
}